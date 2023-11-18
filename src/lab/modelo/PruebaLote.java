package lab.modelo;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import lab.excepciones.EstadoLoteInvalido;
import lab.modelo.empleado.EmpleadoTecnico;
import lab.modelo.enums.EstadoLote;

public class PruebaLote extends Entidad {
	private int idProductoQuimico;
	private LocalDate fechaFabricacion;
	private EmpleadoTecnico responsable;
	private Set<EmpleadoTecnico> ayudantes;
	private EstrategiaVencimiento estrategiaVencimiento;
	private EstadoLote estado;

	public PruebaLote(int idProductoQuimico, LocalDate fechaFabricacion, EmpleadoTecnico responsable) {
		this.idProductoQuimico = idProductoQuimico;
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

	public double calcularCostoPrueba() {
		// TODO

		return -1;
	}

	public void registrarAyudante(EmpleadoTecnico empleado) {
		ayudantes.add(empleado);
	}

	public void establecerEstrategiaVencimiento(EstrategiaVencimiento estrategia) {
		this.estrategiaVencimiento = estrategia;
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
}
