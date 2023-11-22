package lab.modelo.empleado;

import lab.modelo.PerfilTecnico;
import lab.modelo.PruebaLote;

public class EmpleadoTecnico extends Empleado {

	private PerfilTecnico perfil;
	private int contadorReservasMesActual;

	public EmpleadoTecnico(String nombre, String username, PerfilTecnico perfil,int idSedePertenece) {
		super(nombre, username, idSedePertenece);
		this.contadorReservasMesActual = 0;
		this.perfil = perfil;
	}

	public void diagnosticarPrueba(PruebaLote lote) {
		// TODO
	}

	public int getContadorReservasMesActual() {
		return contadorReservasMesActual;
	}

	public double getSueldo() {
		return perfil.getSueldo();
	}

	public PerfilTecnico getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilTecnico perfil) {
		this.perfil = perfil;
	}

	@Override
	public boolean soyTecnico() {
		return true;
	}
}
