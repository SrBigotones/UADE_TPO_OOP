package lab.controlador;

import java.util.List;
import java.util.Optional;

import lab.excepciones.EmpleadoNoEncontrado;
import lab.modelo.Empresa;
import lab.modelo.empleado.Empleado;

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

	public boolean login(String username) throws EmpleadoNoEncontrado {
		List<Empleado> usuarios = Empresa.getInstance().getEmpleados();
		Optional<Empleado> optUsuario = usuarios.stream().filter((u) -> u.getUsername().equalsIgnoreCase(username))
				.findFirst();

		setUsuario(optUsuario.orElse(null));
		return optUsuario.isPresent();
	}
}
