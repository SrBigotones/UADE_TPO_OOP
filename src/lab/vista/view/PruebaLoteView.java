package lab.vista.view;

import java.time.LocalDate;
<<<<<<< HEAD
import java.util.List;
import java.util.stream.Collectors;
=======
import java.util.Map;
>>>>>>> d68b2d8d0324f6375eb13f70f8c2cdc98a9d0e6b

import lab.modelo.ElementoQuimico;
import lab.modelo.ProductoQuimico;
import lab.modelo.PruebaLote;
import lab.modelo.enums.EstadoLote;
import lab.modelo.enums.TipoProducto;

public class PruebaLoteView {

	private int idPruebaLote;
	private String nombreProdQuimico;
	private TipoProducto tipoProducto;
	private LocalDate fechaFabricacion;
	private EmpleadoTecnicoView responsable;
	private EstadoLote estadoLote;
	private List<EmpleadoTecnicoView> auxiliares;
	private int maxAuxiliares;

	private String formulaGenerica;
	
	public PruebaLoteView(PruebaLote pruebaLote) {
		this.idPruebaLote = pruebaLote.getId();
		this.estadoLote = pruebaLote.getEstado();
		this.tipoProducto = pruebaLote.getProductoQuimico().getTipoProducto();
		this.nombreProdQuimico = pruebaLote.getProductoQuimico().getNombreComercial();
		this.fechaFabricacion = pruebaLote.getFechaFabricacion();
		this.responsable = new EmpleadoTecnicoView(pruebaLote.getResponsable());
		this.auxiliares = pruebaLote.getAuxiliares().stream().map((a) -> new EmpleadoTecnicoView(a))
				.collect(Collectors.toList());
		this.maxAuxiliares = pruebaLote.getAuxiliaresRequeridos();
		this.formulaGenerica = this.generateFormulaGenerica(pruebaLote.getProductoQuimico());
	}	
	
	private String generateFormulaGenerica(ProductoQuimico prodQuimico) {
		Map<ElementoQuimico, Integer> formula = prodQuimico.getFormula();
		String formulaGen = "";
		for(ElementoQuimico elQ: formula.keySet()) {
			formulaGen+= formula.get(elQ) + elQ.getSimbolo() + "-";
		}
		
		return formulaGen.substring(0, formulaGen.length() -1);
	}
	@Override
	public String toString() {
		return "PruebaLoteView [idPruebaLote=" + idPruebaLote + ", nombreProdQuimico=" + nombreProdQuimico
				+ ", tipoProducto=" + tipoProducto + ", fechaFabricacion=" + fechaFabricacion + ", nombreResponsable="
				+ responsable.getNombre() + ", estadoLote=" + estadoLote + "]";
	}

	public int getIdPruebaLote() {
		return idPruebaLote;
	}

	public String getNombreProdQuimico() {
		return nombreProdQuimico;
	}

	public LocalDate getFechaFabricacion() {
		return fechaFabricacion;
	}

	public String getNombreResponsable() {
		return responsable.getNombre();
	}
	
	public EmpleadoTecnicoView getResponsable() {
		return responsable;
	}

	public TipoProducto getTipoProducto() {
		return tipoProducto;
	}

	public EstadoLote getEstadoLote() {
		return estadoLote;
	}

	public List<EmpleadoTecnicoView> getAuxiliares() {
		return auxiliares;
	}

	public int getMaxAuxiliares() {
		return maxAuxiliares;
	}

	public String getFormulaGenerica() {
		return formulaGenerica;
	}	
}
