package lab.modelo.enums;

public enum TipoProducto {
	LIMPIEZA(15), PERFUMERIA(20), MEDICAMENTO(30);
	
	private int diasVencimiento;
	
	TipoProducto(int diasVencimiento) {
		this.diasVencimiento = diasVencimiento;
	}

	public int getDiasVencimiento() {
		return diasVencimiento;
	}
	
}
