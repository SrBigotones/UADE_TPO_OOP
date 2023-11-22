package lab.controlador;


import javax.swing.JFrame;
import javax.swing.JPanel;

import lab.modelo.Empresa;
import lab.modelo.empleado.Empleado;
import lab.vista.Menu;
import lab.vista.view.EmpleadoView;

public abstract class Controlador {
	protected static Empleado usuario;
	protected static Empresa empresaInstance;
	protected static JFrame jfLogin;
	protected static Menu jfMenu;

	public Controlador() {
		this.empresaInstance = Empresa.getInstance();
	}

	protected void cambiarPanel(JPanel panel) {
		jfMenu.updateView(panel);
	}
	
	public abstract void mostrarBienvenida();
	

	protected void loginExitoso(Empleado empleado) {
		usuario = empleado;
		
		if(usuario.soyAdministrativo())
			ControladorAdministrativo.getInstance().mostrarBienvenida();
		else if(usuario.soySoporte())
			ControladorSoporte.getInstance().mostrarBienvenida();
		else if(usuario.soyGerente())
			ControladorGerente.getInstance().mostrarBienvenida();
		else if(usuario.soyTecnico())
			ControladorTecnico.getInstance().mostrarBienvenida();
		
		jfLogin.setVisible(false);
	}
	
	public static EmpleadoView getUsuario() {
		return new EmpleadoView(usuario);
	}
}
