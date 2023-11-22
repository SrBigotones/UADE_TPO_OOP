package lab.modelo.empleado;

import lab.modelo.Entidad;
import lab.util.GeneradorID;

public abstract class Empleado extends Entidad {
	private String username;
	private String nombre;
	private static GeneradorID generadorID = new GeneradorID();
	private int idSedePertenece;
	
	public Empleado(String nombre, String username, int idSedePertenece) {
		super(generadorID);
		this.nombre = nombre;
		this.username = username;
		this.idSedePertenece = idSedePertenece;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getUsername() {
		return username;
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

	public int getIdSedePertenece() {
		return idSedePertenece;
	}

	public void setIdSedePertenece(int idSedePertenece) {
		this.idSedePertenece = idSedePertenece;
	}

	@Override
	public String toString() {
		return "Empleado [username=" + username + ", nombre=" + nombre + ", idSedePertenece=" + idSedePertenece + "]";
	}
}
