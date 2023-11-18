package lab.modelo;

import java.time.LocalDate;

public abstract class EstrategiaVencimiento extends Entidad {
	
	private String descripcion;
	
	public EstrategiaVencimiento(String descripcion) {
		super();
		this.descripcion = descripcion;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public abstract LocalDate calcularVencimiento(PruebaLote lote);	
}
