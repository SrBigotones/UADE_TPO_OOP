package lab.modelo.empleado;

public class EmpleadoGerente extends Empleado {

	public EmpleadoGerente(String nombre) {
		super(nombre);
	}

	@Override
	public boolean soyGerente() {
		return true;
	}
}
