package lab.modelo;

import lab.util.GeneradorID;

public class TipoProducto extends Entidad {
	private static GeneradorID generadorID = new GeneradorID();
	private String nombre;
	private int diasVencimiento;
	
	
	
	public TipoProducto(String nombre, int diasVencimiento) {
		super(generadorID);
		this.nombre = nombre;
		this.diasVencimiento = diasVencimiento;
	}
	public String getNombre() {
		return nombre;
	}
	public int getDiasVencimiento() {
		return diasVencimiento;
	}
	public void setDiasVencimiento(int diasVencimiento) {
		this.diasVencimiento = diasVencimiento;
	}
	
	
	

}
