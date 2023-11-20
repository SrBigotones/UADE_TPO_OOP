package lab.excepciones;

public class EmpleadoNoEncontrado extends Exception {

	public EmpleadoNoEncontrado() {
		super("Empleado/usuario no encontrado");
	}
}
