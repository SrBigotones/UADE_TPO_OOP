package lab.modelo.empleado;

public class EmpleadoAdministrativo extends Empleado {

	public EmpleadoAdministrativo(String nombre, String username, int idSedePertenece) {
		super(nombre, username, idSedePertenece);
	}

	@Override
	public boolean soyAdministrativo() {
		return true;
	}
}
