package lab.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import lab.excepciones.LaboratorioNoDisponible;
import lab.excepciones.PruebaLoteNoEncontrado;
import lab.modelo.empleado.EmpleadoTecnico;
import lab.modelo.enums.EstadoLote;
import lab.util.GeneradorID;
import lab.util.Utilidades;

public class Laboratorio extends Entidad {
	private static GeneradorID generadorID = new GeneradorID();
	private Map<FechaTurno, PruebaLote[]> pruebas;
	private int capacidadPersonas;
	private Set<TipoPeligro> peligrosPermitidos;

	/**
	 * 
	 * @param capacidadPersonas
	 * @param tiposPeligro
	 */
	public Laboratorio(int capacidadPersonas, Set<TipoPeligro> tiposPeligro) {
		super(generadorID);
		this.peligrosPermitidos = tiposPeligro;
		this.capacidadPersonas = capacidadPersonas;
		pruebas = new HashMap<>();
	}

	public boolean disponible(ProductoQuimico productoQuimico, int auxiliaresRequeridos, FechaTurno fechaTurno) {
		PruebaLote[] pruebasEnTurno = pruebas.get(fechaTurno);
		boolean turnoDisponible = pruebasEnTurno == null || pruebasEnTurno[0] == null || pruebasEnTurno[1] == null;
		if (!turnoDisponible)
			return false;

		// TODO Verficar que el tipo de peligro del lote encaja con el laboratorio
		this.puedeProbarProductoQuimico(productoQuimico);

		// TODO Verificar la capacidad de personas del laboratorio con las pruebas y el lote
		int cuentaAuxiliares = capacidadPersonas - auxiliaresRequeridos;
		if(pruebasEnTurno != null && pruebasEnTurno[0]!= null) {
			cuentaAuxiliares -= pruebasEnTurno[0].getAuxiliaresRequeridos();
		}
		if(cuentaAuxiliares < 0)
			return false;

		// TODO Verficar que los productos de la prueba ya existente en esa fecha turno, sean compatibles (si es que ya habia una prueba)
		if(pruebasEnTurno != null && pruebasEnTurno[0] !=  null && !pruebasEnTurno[0].getProductoQuimico().esMismoTipo(productoQuimico)) {
			return false;
		}
		
		return true;
	}

	public PruebaLote reservar(ProductoQuimico productoQuimico, int auxiliaresRequeridos, EmpleadoTecnico empleadoResponsable, FechaTurno fechaTurno) throws LaboratorioNoDisponible {
		
		if (!disponible(productoQuimico, auxiliaresRequeridos, fechaTurno) || this.puedeProbarProductoQuimico(productoQuimico)) {
			throw new LaboratorioNoDisponible();
		}

		if (pruebas.get(fechaTurno) == null) {
			PruebaLote[] nuevoTurno = new PruebaLote[] { null, null };
			pruebas.put(fechaTurno, nuevoTurno);
		}

		PruebaLote[] pruebasEnTurno = pruebas.get(fechaTurno);
		PruebaLote nuevaPruebaLote = new PruebaLote(productoQuimico, empleadoResponsable, auxiliaresRequeridos );
		if (pruebasEnTurno[0] == null) {
			pruebasEnTurno[0] = nuevaPruebaLote;
		} else {
			pruebasEnTurno[1] = nuevaPruebaLote;
		}
		
		return nuevaPruebaLote;
	}

	public double calcularCostoPruebaTotal(int idLote) throws PruebaLoteNoEncontrado {
		// TODO Falta definir el tipo de salida en el diagrama
		PruebaLote pruebaLote = this.buscarLote(idLote);
		
		double costo = pruebaLote.calcularCostoPrueba();
		for(TipoPeligro tipoPeligro: peligrosPermitidos) {
			costo += tipoPeligro.getCosto();
		}
		
		return costo;
	}

	
	public void establecerPeligrosPermitidos(Set<TipoPeligro> tiposPeligro) {
		this.peligrosPermitidos = tiposPeligro;
	}
	
	
	private PruebaLote buscarLote(int idLote) throws PruebaLoteNoEncontrado {
		List<PruebaLote> auxPruebas = new ArrayList<>();
		
		for(PruebaLote[] arr: pruebas.values()) {
			for(PruebaLote value: arr)
				auxPruebas.add(value);
		}
		
		PruebaLote pruebaLote = Utilidades.buscarEnListaPorId(idLote, auxPruebas);
		if(pruebaLote != null)
			return pruebaLote;
		
		throw new PruebaLoteNoEncontrado();
	}

	
	public void registrarAyudanteAPrueba(EmpleadoTecnico empleadoTecnico, int idPrueba) throws PruebaLoteNoEncontrado {
		PruebaLote pruebaLote = this.buscarLote(idPrueba);
		pruebaLote.registrarAyudante(empleadoTecnico);
	}
	
	public boolean puedeProbarProductoQuimico(ProductoQuimico productoQuimico) {
		return this.peligrosPermitidos.containsAll(productoQuimico.getPeligros());
	}
	public int getCapacidadPersonas() {
		return capacidadPersonas;
	}

	public void setCapacidadPersonas(int capacidadPersonas) {
		this.capacidadPersonas = capacidadPersonas;
	}

	public void establecerEstrategiaVencimiento(int idPrueba, EstrategiaVencimiento estrategiaVencimiento) throws PruebaLoteNoEncontrado {
		// TODO Auto-generated method stub
		PruebaLote pruebaLote = this.buscarLote(idPrueba);
		pruebaLote.establecerEstrategiaVencimiento(estrategiaVencimiento);
		
	}

	public void finalizarPrueba(int idLote, EstadoLote estadoLote, EstrategiaVencimiento estrategiaVencimiento) throws PruebaLoteNoEncontrado {
		// TODO Auto-generated method stub
		PruebaLote pruebaLote = this.buscarLote(idLote);
		pruebaLote.finalizarPrueba(estadoLote, estrategiaVencimiento);
	}
	
	public List<PruebaLote> obtenerPruebas() {
		List<PruebaLote> lista = new ArrayList<>();
		
		for(PruebaLote[] pruebas: pruebas.values()) {
			if(pruebas[0] != null)
				lista.add(pruebas[0]);
			if(pruebas[1] != null)
				lista.add(pruebas[1]);
		}
		
		return lista;
	}
}
