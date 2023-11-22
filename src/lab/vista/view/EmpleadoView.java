package lab.vista.view;

import lab.modelo.Empresa;
import lab.modelo.Sede;
import lab.modelo.empleado.Empleado;
import lab.util.Utilidades;

public class EmpleadoView {
	private int idEmpleado;
	private String nombre;
	private String tipo;
	private String sede;

	public EmpleadoView(Empleado empleado) {
		this.idEmpleado = empleado.getId();
		this.nombre = empleado.getNombre();
		this.tipo = mapTipo(empleado);
		Sede sedePertenece = Utilidades.buscarEnListaPorId(empleado.getIdSedePertenece(),
				Empresa.getInstance().getSedes());
		this.sede = sedePertenece != null ? sedePertenece.getProvincia().getDescripcion() : " - ";
	}

	public String getNombre() {
		return nombre;
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public String getTipo() {
		return tipo;
	}

	public String getSede() {
		return sede;
	}
	
	private String mapTipo(Empleado empleado) {
		if (empleado.soyAdministrativo())
			return "Administrativo";
		if (empleado.soyGerente())
			return "Gerente";
		if (empleado.soySoporte())
			return "Soporte";
		if (empleado.soyTecnico())
			return "Técnico";
		return " - ";
	}
}
