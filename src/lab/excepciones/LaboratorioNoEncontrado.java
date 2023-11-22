package lab.excepciones;

public class LaboratorioNoEncontrado extends Exception{
	public LaboratorioNoEncontrado() {
		super("Laboratorio no encontrado");
	}
}
