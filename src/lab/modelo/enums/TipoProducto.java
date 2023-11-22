package lab.modelo.enums;

public enum TipoProducto {
	LIMPIEZA(15, "Limpieza"), PERFUMERIA(20, "Perfumería"), MEDICAMENTO(30, "Medicamento");
	
	private int diasVencimiento;
	private String descripcion;
	
	TipoProducto(int diasVencimiento, String descripcion) {
		this.diasVencimiento = diasVencimiento;
		this.descripcion = descripcion;
	}

	public int getDiasVencimiento() {
		return diasVencimiento;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
}
