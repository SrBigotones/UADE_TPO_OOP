package lab.vista.view;

import lab.modelo.EstrategiaVencimiento;

public class CriterioVencimientoView {

	private int idEstrategia;
	private String descripcion;
	public CriterioVencimientoView(EstrategiaVencimiento x) {
		this.idEstrategia = x.getId();
		this.descripcion = x.getDescripcion();
	}
	public int getIdEstrategia() {
		return idEstrategia;
	}
	public void setIdEstrategia(int idEstrategia) {
		this.idEstrategia = idEstrategia;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return idEstrategia + ", " + descripcion + "";
	}
	
	
}
