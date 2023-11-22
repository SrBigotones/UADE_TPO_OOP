package lab.vista.view;

import java.time.LocalDate;
import java.util.Map;

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
	private String nombreResponsable;
	private EstadoLote estadoLote;
	private String formulaGenerica;
	
	public PruebaLoteView(PruebaLote pruebaLote) {
		this.idPruebaLote = pruebaLote.getId();
		this.estadoLote = pruebaLote.getEstado();
		this.tipoProducto = pruebaLote.getProductoQuimico().getTipoProducto();
		this.nombreProdQuimico = pruebaLote.getProductoQuimico().getNombreComercial();
		this.fechaFabricacion = pruebaLote.getFechaFabricacion();
		this.nombreResponsable = pruebaLote.getResponsable().getNombre();
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
				+ nombreResponsable + ", estadoLote=" + estadoLote + "]";
	}


	public int getIdPruebaLote() {
		return idPruebaLote;
	}
	public void setIdPruebaLote(int idPruebaLote) {
		this.idPruebaLote = idPruebaLote;
	}
	public String getNombreProdQuimico() {
		return nombreProdQuimico;
	}
	public void setNombreProdQuimico(String nombreProdQuimico) {
		this.nombreProdQuimico = nombreProdQuimico;
	}
	public LocalDate getFechaFabricacion() {
		return fechaFabricacion;
	}
	public void setFechaFabricacion(LocalDate fechaFabricacion) {
		this.fechaFabricacion = fechaFabricacion;
	}
	public String getNombreResponsable() {
		return nombreResponsable;
	}
	public void setNombreResponsable(String nombreResponsable) {
		this.nombreResponsable = nombreResponsable;
	}


	public TipoProducto getTipoProducto() {
		return tipoProducto;
	}


	public void setTipoProducto(TipoProducto tipoProducto) {
		this.tipoProducto = tipoProducto;
	}


	public EstadoLote getEstadoLote() {
		return estadoLote;
	}


	public void setEstadoLote(EstadoLote estadoLote) {
		this.estadoLote = estadoLote;
	}



	public String getFormulaGenerica() {
		return formulaGenerica;
	}



	public void setFormulaGenerica(String formulaGenerica) {
		this.formulaGenerica = formulaGenerica;
	}
	
	
}
