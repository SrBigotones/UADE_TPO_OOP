package lab.modelo.empleado;

public class EmpleadoAdministrativo extends Empleado {

	public EmpleadoAdministrativo(String nombre, String username) {
		super(nombre, username);
	}

	@Override
	public boolean soyAdministrativo() {
		return true;
	}
}
