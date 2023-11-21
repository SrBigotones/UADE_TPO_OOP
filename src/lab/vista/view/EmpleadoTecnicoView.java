package lab.vista.view;

import lab.modelo.empleado.EmpleadoTecnico;

public class EmpleadoTecnicoView {
	private int idEmpleado;
	private String nombre;
	private String puesto;
	
	public EmpleadoTecnicoView(EmpleadoTecnico empleadoTecnico) {
		this.idEmpleado = empleadoTecnico.getId();
		this.nombre = empleadoTecnico.getNombre();
		this.puesto = empleadoTecnico.getPerfil().getNombre();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

}
