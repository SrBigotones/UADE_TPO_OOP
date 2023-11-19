package lab.modelo.empleado;

import lab.modelo.Entidad;

public abstract class Empleado extends Entidad {
	private String nombre;
	
	public Empleado(String nombre) {
		super();
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
