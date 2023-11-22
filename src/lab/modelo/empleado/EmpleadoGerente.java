package lab.modelo.empleado;

public class EmpleadoGerente extends Empleado {

	public EmpleadoGerente(String nombre, String username, int idSedePertenece) {
		super(nombre, username, idSedePertenece);
	}

	@Override
	public boolean soyGerente() {
		return true;
	}
}
