package lab.controlador;

import java.util.List;
import java.util.Optional;

import javax.swing.JFrame;

import lab.excepciones.EmpleadoNoEncontrado;
import lab.modelo.Empresa;
import lab.modelo.empleado.Empleado;
import lab.vista.Login;

public class ControladorLogin extends Controlador {

	private static ControladorLogin instance;

	ControladorLogin() {
	}

	public static synchronized ControladorLogin getInstance() {
		if (instance == null) {
			instance = new ControladorLogin();
		}
		return instance;
	}

	public boolean login(String username) {
		List<Empleado> usuarios = Empresa.getInstance().getEmpleados();
		Optional<Empleado> optUsuario = usuarios.stream().filter((u) -> u.getUsername().equalsIgnoreCase(username))
				.findFirst();

		if (optUsuario.isPresent()) {
			loginExitoso(optUsuario.get());
		}

		return optUsuario.isPresent();
	}

	public void inicializarLogin() {
		if (jfLogin == null) {
			jfLogin = new Login();
			jfLogin.setSize(400, 500);
			jfLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jfLogin.setLocationRelativeTo(null);
		}
		jfLogin.setVisible(true);
	}
}
