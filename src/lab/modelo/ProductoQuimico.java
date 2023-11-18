package lab.modelo;

import java.util.Map;
import java.util.Set;

import lab.modelo.enums.TipoProducto;

public class ProductoQuimico extends Entidad {
	private Map<ElementoQuimico, Integer> formula;
	private String nombreComercial;
	private TipoProducto tipoProducto;
	private Set<TipoPeligro> peligros;

	public ProductoQuimico(Map<ElementoQuimico, Integer> formula, String nombreComercial, TipoProducto tipo,
			Set<TipoPeligro> peligros) {
		super();
		this.formula = formula;
		this.nombreComercial = nombreComercial;
		this.tipoProducto = tipo;
		this.peligros = peligros;
	}

	public boolean esMismoTipo(ProductoQuimico prod) {
		return prod.tipoProducto.equals(tipoProducto);
	}
}
