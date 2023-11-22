package lab.vista.view;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lab.modelo.ElementoQuimico;
import lab.modelo.ProductoQuimico;
import lab.modelo.TipoPeligro;
import lab.modelo.enums.TipoProducto;

public class ProductoQuimicoView {

	private int idProductoQuimico;
	private Map<ElementoQuimico, Integer> formula;
	private String nombreComercial;
	private TipoProducto tipoProducto;
	private List<TipoPeligro> tiposPeligro;

	public ProductoQuimicoView(ProductoQuimico pq) {
		idProductoQuimico = pq.getId();
		nombreComercial = pq.getNombreComercial();
		tipoProducto = pq.getTipoProducto();
		formula = pq.getFormula();
		tiposPeligro = pq.getPeligros().stream().collect(Collectors.toList());
	}
	
	public String generarStringFormula() {
		String ret = "";
		for (Map.Entry<ElementoQuimico, Integer> entry : formula.entrySet()) {
			ret += entry.getKey().getSimbolo() + entry.getValue();
		}

		return ret;
	}
	
	public String generarStringPeligros() {
		if (tiposPeligro == null || tiposPeligro.size() == 0) {
			return " - ";
		}
		String ret = tiposPeligro.get(0).getNombre();
		for (int i = 1; i < tiposPeligro.size(); i++) {
			ret += ", " + tiposPeligro.get(i).getNombre();
		}

		return ret;		
	}
	
	public TipoProducto getTipoProducto() {
		return tipoProducto;
	}
	
	public String getNombreComercial() {
		return nombreComercial;
	}

	public int getIdProductoQuimico() {
		return idProductoQuimico;
	}

	@Override
	public String toString() {
		return nombreComercial;
	}
}
