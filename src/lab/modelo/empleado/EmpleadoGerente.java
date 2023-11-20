package lab.modelo.empleado;

public class EmpleadoGerente extends Empleado {

	public EmpleadoGerente(String nombre, String username) {
		super(nombre, username);
	}

	@Override
	public boolean soyGerente() {
		return true;
	}
}
