package lab.controlador;

import javax.swing.JFrame;
import javax.swing.JPanel;

import lab.modelo.Empresa;
import lab.modelo.empleado.Empleado;

public abstract class Controlador {
	protected static Empleado usuario;
	protected static Empresa empresaInstance;
	protected static JFrame jfLogin;
	protected static JFrame jfMenu;

	public Controlador() {
		this.empresaInstance = Empresa.getInstance();
	}

	protected void cambiarPanel(JPanel panel) {
		// TODO Se espera a que esté hecho el jframe principal
		JFrame jframe = new JFrame();
		jframe.setSize(1000, 700);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setLocationRelativeTo(null);
		jframe.add(panel);
		jframe.setVisible(true);
	}

	protected void loginExitoso(Empleado empleado) {
		if (jfMenu == null) {
			jfMenu = new JFrame();
		}

		usuario = empleado;
		jfLogin.setVisible(false);
		// jfMenu.setVisible(true); TODO Se espera as que esté hecho el jframe
		cambiarPanel(new JPanel());
		ControladorSoporte.getInstance().mostrarPantallaSedes();
	}
}
