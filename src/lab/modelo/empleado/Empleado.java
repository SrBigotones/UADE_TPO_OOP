package lab.modelo.empleado;

import lab.modelo.Entidad;
import lab.util.GeneradorID;

public abstract class Empleado extends Entidad {
	private String nombre;
	private static GeneradorID generadorID = new GeneradorID();
	
	public Empleado(String nombre) {
		super(generadorID);
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public boolean soyTecnico() {
		return false;
	}
	
	public boolean soyAdministrativo() {
		return false;
	}
	
	public boolean soySoporte() {
		return false;
	}
	
	public boolean soyGerente() {
		return false;
	}
}
