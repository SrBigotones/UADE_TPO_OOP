package lab.modelo.empleado;

import lab.modelo.PerfilTecnico;
import lab.modelo.PruebaLote;

public class EmpleadoTecnico extends Empleado {

	private PerfilTecnico perfil;
	private int contadorReservasMesActual;
		
	public EmpleadoTecnico(String nombre, PerfilTecnico perfil) {
		super(nombre);
		this.contadorReservasMesActual = 0;
		this.perfil = perfil;
	}
	
	public void diagnosticarPrueba(PruebaLote lote) {
		// TODO
	}
	
	public int getContadorReservasMesActual() {
		return contadorReservasMesActual;
	}
}
