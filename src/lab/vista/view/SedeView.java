package lab.vista.view;

import lab.modelo.Sede;
import lab.modelo.enums.Provincia;

public class SedeView {

	private int nroLabs;
	private Provincia provincia;
	private String administrativo;
	
	public SedeView(Sede sede) {
		nroLabs = sede.getLaboratorios().size();
		provincia = sede.getProvincia();
		administrativo = sede.getGerente() != null ? sede.getGerente().getNombre() : " - ";
	}

	public int getNroLabs() {
		return nroLabs;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public String getAdministrativo() {
		return administrativo;
	}
	
	
}
