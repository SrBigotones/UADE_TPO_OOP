package lab.vista.view;

import lab.modelo.ProductoQuimico;
import lab.modelo.enums.TipoProducto;

public class ProductoQuimicoView {
	
	private int idProdQuimico;
	private String nombreComercial;
	private TipoProducto tipoProducto;

	public ProductoQuimicoView(ProductoQuimico x) {
		// TODO Auto-generated constructor stub
		this.idProdQuimico =x.getId();
		this.nombreComercial = x.getNombreComercial();
		this.tipoProducto = x.getTipoProducto();
	}

	public int getIdProdQuimico() {
		return idProdQuimico;
	}

	public void setIdProdQuimico(int idProdQuimico) {
		this.idProdQuimico = idProdQuimico;
	}

	public String getNombreComercial() {
		return nombreComercial;
	}

	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}

	public TipoProducto getTipoProducto() {
		return tipoProducto;
	}

	public void setTipoProducto(TipoProducto tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	@Override
	public String toString() {
		return nombreComercial;
	}

}
