package lab.modelo;

import java.util.Map;
import java.util.Set;

import lab.modelo.enums.TipoProducto;
//import lab.modelo.enums.TipoProducto;
import lab.util.GeneradorID;

public class ProductoQuimico extends Entidad {
	private static GeneradorID generadorID = new GeneradorID();
	private Map<ElementoQuimico, Integer> formula; //Elemento, cantidad
	private String nombreComercial;
	private TipoProducto tipoProducto;
	private Set<TipoPeligro> peligros;

	public ProductoQuimico(Map<ElementoQuimico, Integer> formula, String nombreComercial, TipoProducto tipo,
			Set<TipoPeligro> peligros) {
		super(generadorID);
		this.formula = formula;
		this.nombreComercial = nombreComercial;
		this.tipoProducto = tipo;
		this.peligros = peligros;
	}

	public boolean esMismoTipo(ProductoQuimico prod) {
		return prod.tipoProducto.equals(tipoProducto);
	}

	public Set<TipoPeligro> getPeligros() {
		return peligros;
	}

	public Map<ElementoQuimico, Integer> getFormula() {
		return formula;
	}

	public TipoProducto getTipoProducto() {
		return tipoProducto;
	}
	
	
}
