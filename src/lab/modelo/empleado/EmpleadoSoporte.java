package lab.modelo.empleado;

public class EmpleadoSoporte extends Empleado {

	public EmpleadoSoporte(String nombre, String username) {
		super(nombre, username);
	}

	@Override
	public boolean soySoporte() {
		return true;
	}
}
