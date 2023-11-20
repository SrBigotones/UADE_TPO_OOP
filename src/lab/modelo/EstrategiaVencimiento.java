package lab.modelo;

import java.time.LocalDate;

import lab.util.GeneradorID;

public abstract class EstrategiaVencimiento extends Entidad {
	
	private static GeneradorID generadorID = new GeneradorID();
	private String descripcion;
	
	public EstrategiaVencimiento(String descripcion) {
		super(generadorID);
		this.descripcion = descripcion;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public abstract LocalDate calcularVencimiento(PruebaLote lote);	
}
