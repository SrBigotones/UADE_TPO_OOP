package lab.modelo;

import lab.util.GeneradorID;

public class TipoPeligro extends Entidad {
	private static GeneradorID generadorID = new GeneradorID();
	private String nombre;
	private double costo;
	
	public TipoPeligro(String nombre, double costo) {
		super(generadorID);
		this.nombre = nombre;
		this.costo = costo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public double getCosto() {
		return costo;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}
	
	
	
	
}
