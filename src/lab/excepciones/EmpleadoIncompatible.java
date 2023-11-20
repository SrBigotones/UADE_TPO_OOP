package lab.excepciones;

import lab.modelo.empleado.Empleado;

public class EmpleadoIncompatible extends Exception {

	public EmpleadoIncompatible(Empleado empleado) {
		super("El empleado " + empleado.getNombre() + " no es compatible con la operacion");
	}

}
