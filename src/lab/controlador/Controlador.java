package lab.controlador;

import lab.modelo.empleado.Empleado;

public abstract class Controlador {
	private Empleado usuario;
	private String panelActual;
	
	protected void setUsuario(Empleado usuario) {
		this.usuario = usuario;
	}
}
