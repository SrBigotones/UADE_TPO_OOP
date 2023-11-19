package lab.modelo;

public enum ElementoQuimico {
	HIERRO(26, "Fe", "Hierro"), SODIO(11, "Na", "Sodio"), CALCIO(20, "Ca", "Calcio"), AZUFRE(16, "S", "Azufre");
	
	private int nroAtomico;
	private String simbolo;
	private String nombre;
	
	ElementoQuimico(int nroAtomico, String simbolo, String nombre) {
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
