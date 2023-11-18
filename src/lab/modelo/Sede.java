package lab.modelo;

import java.util.ArrayList;
import java.util.List;

import lab.modelo.empleado.EmpleadoAdministrativo;
import lab.modelo.enums.Provincia;
import lab.util.Utilidades;

public class Sede extends Entidad {
	private EmpleadoAdministrativo administrativo;
	private List<Laboratorio> laboratorios;
	private Provincia provincia;

	public Sede(Provincia provincia) {
		super();
		this.provincia = provincia;
		this.laboratorios = new ArrayList<>();
	}

	public void agregarLaboratorio(Laboratorio lab) {
		laboratorios.add(lab);
	}

	public void agendarPrueba() {

	}

	public void asignarEmpleadoAdministrativo(EmpleadoAdministrativo empleado) {
		this.administrativo = empleado;
	}

	public Laboratorio buscarLaboratorio(int id) {
		return Utilidades.buscarEnListaPorId(id, laboratorios);
	}

	public EmpleadoAdministrativo getAdministrativo() {
		return administrativo;
	}

	public void setAdministrativo(EmpleadoAdministrativo administrativo) {
		this.administrativo = administrativo;
	}

	public List<Laboratorio> getLaboratorios() {
		return laboratorios;
	}

	public void setLaboratorios(List<Laboratorio> laboratorios) {
		this.laboratorios = laboratorios;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}
}
