package lab.modelo.empleado;

public class EmpleadoSoporte extends Empleado {

	public EmpleadoSoporte(String nombre) {
		super(nombre);
	}

	@Override
	public boolean soySoporte() {
		return true;
	}
}
