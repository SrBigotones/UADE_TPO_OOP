package lab.modelo;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import lab.excepciones.EstadoLoteInvalido;
import lab.modelo.empleado.EmpleadoTecnico;
import lab.modelo.enums.EstadoLote;

public class PruebaLote extends Entidad {
	private ProductoQuimico productoQuimico; //Dentro de ProductoQuimico se almacena los tipos de peligros y tipoDeProducto
	private LocalDate fechaFabricacion;
	private EmpleadoTecnico responsable;
	private Set<EmpleadoTecnico> ayudantes;
	private EstrategiaVencimiento estrategiaVencimiento;
	private EstadoLote estado;

	public PruebaLote(ProductoQuimico productoQuimico, LocalDate fechaFabricacion, EmpleadoTecnico responsable) {
		this.productoQuimico = productoQuimico;
		this.fechaFabricacion = fechaFabricacion;
		this.responsable = responsable;

		estado = EstadoLote.PENDIENTE;
		ayudantes = new HashSet<>();
	}

	public LocalDate calcularFechaVencimiento() throws EstadoLoteInvalido {
		if (!EstadoLote.FINALIZADO.equals(estado)) {
			throw new EstadoLoteInvalido();
		}
		return estrategiaVencimiento.calcularVencimiento(this);
	}

	
	/**
	 * Calcula el costo de la prueba parcial, retorna el costo
	 * de los participantes en la prueba
	 * @return
	 */
	public double calcularCostoPrueba() {
		// TODO
		
		double costo = responsable.getSueldo() / 60;
		
		for(EmpleadoTecnico empTec: ayudantes) {
			costo += (empTec.getSueldo() / 60);
		}

		return costo;
	}

	public void registrarAyudante(EmpleadoTecnico empleado) {
		ayudantes.add(empleado);
	}

	public void establecerEstrategiaVencimiento(EstrategiaVencimiento estrategia) {
		this.estrategiaVencimiento = estrategia;
	}
	
	
	/**
	 * Una vez finalizada la prueba, el profesional que efectuo la reserva debe colar
	 * si la misma fue "Aceptada" o "Rechazada" y determinar
	 * que tipo de cirterio tendra ese lote para el calculo de la fecha
	 * de vencimiento, Este criterio puede ser modificado posteriormente
	 * @param resultado
	 * @param estaEstrategiaVencimiento
	 */
	public void finalizarPrueba(EstadoLote resultado, EstrategiaVencimiento estrategiaVencimiento) {
		if(resultado == EstadoLote.ACEPTADO || resultado == EstadoLote.RECHAZADO) {
			this.setEstado(resultado);
			this.establecerEstrategiaVencimiento(estrategiaVencimiento);
		}
		
		
	}

	public void habilitar() throws EstadoLoteInvalido {
		if (!EstadoLote.ACEPTADO.equals(estado)) {
			throw new EstadoLoteInvalido();
		}
		
		estado = EstadoLote.FINALIZADO;
	}
	
	public EstadoLote getEstado() {
		return estado;
	}

	private void setEstado(EstadoLote estado) {
		this.estado = estado;
	}

	public ProductoQuimico getProductoQuimico() {
		return productoQuimico;
	}
	
	
}
