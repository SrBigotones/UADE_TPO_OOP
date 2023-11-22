package lab.modelo.empleado;

public class EmpleadoSoporte extends Empleado {

	public EmpleadoSoporte(String nombre, String username) {
		super(nombre, username, 0);
	}

	@Override
	public boolean soySoporte() {
		return true;
	}
}
