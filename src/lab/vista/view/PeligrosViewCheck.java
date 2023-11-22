package lab.vista.view;

import lab.modelo.TipoPeligro;

public class PeligrosViewCheck {
	private boolean check;
	private int idPeligro;
	private String nombre;
	private double costo;
	private long diasVencimiento;
	public PeligrosViewCheck(TipoPeligro tipoPeligro) {
		this.idPeligro = tipoPeligro.getId();
		this.nombre = tipoPeligro.getNombre();
		this.costo = tipoPeligro.getCosto();
		this.diasVencimiento = tipoPeligro.getDiasVencimineto();
	}
	public int getIdPeligro() {
		return idPeligro;
	}
	public void setIdPeligro(int idPeligro) {
		this.idPeligro = idPeligro;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}
	public long getDiasVencimiento() {
		return diasVencimiento;
	}
	public void setDiasVencimiento(long diasVencimiento) {
		this.diasVencimiento = diasVencimiento;
	}
	public boolean isCheck() {
		return check;
	}
	public void setCheck(boolean check) {
		this.check = check;
	}



}
