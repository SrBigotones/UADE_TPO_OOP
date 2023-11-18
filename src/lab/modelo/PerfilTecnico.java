package lab.modelo;

public class PerfilTecnico extends Entidad {
	private String nombre;
	private double sueldo;
	private int maxReservas;

	public PerfilTecnico(String nombre, double sueldo, int maxReservas) {
		super();
		this.nombre = nombre;
		this.sueldo = sueldo;
		this.maxReservas = maxReservas;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public int getMaxReservas() {
		return maxReservas;
	}

	public void setMaxReservas(int maxReservas) {
		this.maxReservas = maxReservas;
	}

	public String getNombre() {
		return nombre;
	}
}
