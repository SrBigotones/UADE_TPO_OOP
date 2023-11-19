package lab.modelo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import lab.excepciones.LaboratorioNoDisponible;
import lab.excepciones.PruebaLoteNoEncontrado;

public class Laboratorio extends Entidad {
	private Map<FechaTurno, PruebaLote[]> pruebas;
	private int capacidadPersonas;
	private Set<TipoPeligro> peligrosPermitidos;

	/**
	 * 
	 * @param capacidadPersonas
	 * @param tiposPeligro
	 */
	public Laboratorio(int capacidadPersonas, Set<TipoPeligro> tiposPeligro) {
		super();
		this.peligrosPermitidos = tiposPeligro;
		this.capacidadPersonas = capacidadPersonas;
		pruebas = new HashMap<>();
	}

	public boolean disponible(PruebaLote lote, FechaTurno fechaTurno) {
		PruebaLote[] pruebasEnTurno = pruebas.get(fechaTurno);
		boolean turnoDisponible = pruebasEnTurno == null || pruebasEnTurno[0] == null || pruebasEnTurno[1] == null;
		if (!turnoDisponible)
			return false;

		// TODO Verficar que el tipo de peligro del lote encaja con el laboratorio

		// TODO Verificar la capacidad de personas del laboratorio con las pruebas y el lote

		// TODO Verficar que los productos de la prueba ya existente en esa fecha turno, sean compatibles (si es que ya habia una prueba)
		
		return true;
	}

	public void reservar(PruebaLote lote, FechaTurno fechaTurno) throws LaboratorioNoDisponible {
		if (!disponible(lote, fechaTurno)) {
			throw new LaboratorioNoDisponible();
		}

		if (pruebas.get(fechaTurno) == null) {
			PruebaLote[] nuevoTurno = new PruebaLote[] { null, null };
			pruebas.put(fechaTurno, nuevoTurno);
		}

		PruebaLote[] pruebasEnTurno = pruebas.get(fechaTurno);
		if (pruebasEnTurno[0] == null) {
			pruebasEnTurno[0] = lote;
		} else {
			pruebasEnTurno[1] = lote;
		}
	}

	public double calcularCostoPruebaTotal(FechaTurno fechaTurno, int idLote) throws PruebaLoteNoEncontrado {
		// TODO Falta definir el tipo de salida en el diagrama
		PruebaLote pruebaLote = this.buscarLote(fechaTurno, idLote);
		
		double costo = pruebaLote.calcularCostoPrueba();
		for(TipoPeligro tipoPeligro: peligrosPermitidos) {
			costo += tipoPeligro.getCosto();
		}
		
		return costo;
	}

	
	public void establecerPeligrosPermitidos(Set<TipoPeligro> tiposPeligro) {
		this.peligrosPermitidos = tiposPeligro;
	}
	
	
	private PruebaLote buscarLote(FechaTurno fechaTurno, int idLote) throws PruebaLoteNoEncontrado {
		for(PruebaLote pruebaLote: pruebas.get(fechaTurno)) {
			if(pruebaLote.esPorId(idLote)) {
				return pruebaLote;
			}
		}
		
		throw new PruebaLoteNoEncontrado();
	}

	public int getCapacidadPersonas() {
		return capacidadPersonas;
	}

	public void setCapacidadPersonas(int capacidadPersonas) {
		this.capacidadPersonas = capacidadPersonas;
	}
}
