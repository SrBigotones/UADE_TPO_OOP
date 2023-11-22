package lab.vista.view;

import java.util.Optional;

import lab.modelo.Empresa;
import lab.modelo.Sede;
import lab.modelo.empleado.Empleado;
import lab.modelo.enums.Provincia;

public class SedeView {

	private int id;
	private int nroLabs;
	private Provincia provincia;
	private String administrativo = " - ";
	private String gerente = " - ";

	public SedeView(Sede sede) {
		id = sede.getId();
		nroLabs = sede.getLaboratorios().size();
		provincia = sede.getProvincia();
		Empleado gerenteDeSede = sede.obtenerGerenteDeSede();
		if (gerenteDeSede != null) {
			gerente = gerenteDeSede.getNombre();
		}
		Empleado adminDeSede = sede.obtenerAdminDeSede();
		if (adminDeSede != null) {
			administrativo = adminDeSede.getNombre();
		}
	}

	public int getId() {
		return id;
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
	
	public String getGerente() {
		return gerente;
	}

	@Override
	public String toString() {
		return getProvincia().getDescripcion();
	}
}