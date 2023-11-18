package lab.excepciones;

public class EstadoLoteInvalido extends Exception {
	public EstadoLoteInvalido() {
		super("El estado del lote no permite realizar la operacion");
	}
}
