package lab.modelo.enums;

public enum Provincia {
	BUENOS_AIRES("Buenos Aires"), CORDOBA("Cordoba"), JUJUY("Jujuy"), RIO_NEGRO("Rio Negro"), MISIONES("Misiones");

	private String descripcion;

	Provincia(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public static Provincia[] crearListaProvincias() {
		return Provincia.values();
	}
}
