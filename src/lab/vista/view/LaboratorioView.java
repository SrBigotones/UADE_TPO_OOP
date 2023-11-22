package lab.vista.view;

import lab.modelo.Laboratorio;

public class LaboratorioView {
	private int idLab;
	private int capacidadPersonas;
	
	
	public LaboratorioView(Laboratorio lab) {
		this.idLab = lab.getId();
		this.capacidadPersonas = lab.getCapacidadPersonas();
	}


	public int getIdLab() {
		return idLab;
	}


	public void setIdLab(int idLab) {
		this.idLab = idLab;
	}


	public int getCapacidadPersonas() {
		return capacidadPersonas;
	}


	public void setCapacidadPersonas(int capacidadPersonas) {
		this.capacidadPersonas = capacidadPersonas;
	}
}
