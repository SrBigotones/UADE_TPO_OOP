package lab.modelo;

public class TipoPeligro extends Entidad {
	private String nombre;
	private double costo;
	
	public TipoPeligro(String nombre, double costo) {
		super();
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
