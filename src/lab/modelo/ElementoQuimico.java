package lab.modelo;

public class ElementoQuimico {
	private int nroAtomico;
	private String simbolo;
	private String nombre;
	
	public ElementoQuimico(int nroAtomico, String simbolo, String nombre) {
		super();
		this.nroAtomico = nroAtomico;
		this.simbolo = simbolo;
		this.nombre = nombre;
	}

	public int getNroAtomico() {
		return nroAtomico;
	}

	public String getSimbolo() {
		return simbolo;
	}

	public String getNombre() {
		return nombre;
	}
}
