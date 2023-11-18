package lab.excepciones;

public class LaboratorioNoDisponible extends Exception {
	public LaboratorioNoDisponible() {
		super("El laboratorio no tiene el turno disponible");
	}
}
