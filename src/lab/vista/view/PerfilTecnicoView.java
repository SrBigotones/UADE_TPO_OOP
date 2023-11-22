package lab.vista.view;

import lab.modelo.PerfilTecnico;

public class PerfilTecnicoView {
	private int idPerfil;
	private String nombre;
	private double sueldo;
	private int maxReservas;
	
	public PerfilTecnicoView(PerfilTecnico perfilTecnico) {
		this.idPerfil = perfilTecnico.getId();
		this.nombre = perfilTecnico.getNombre();
		this.sueldo = perfilTecnico.getSueldo();
		this.maxReservas = perfilTecnico.getMaxReservas();
	}



	public int getIdPerfil() {
		return idPerfil;
	}



	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	
	
}
