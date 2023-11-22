package lab.vista.view;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lab.excepciones.EstadoLoteInvalido;
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
	private String fechaVTO;
	
	public PruebaLoteView(PruebaLote pruebaLote){
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
		try {
			this.fechaVTO = pruebaLote.calcularFechaVencimiento().toString();
			System.out.println(pruebaLote.calcularFechaVencimiento());
		} catch (EstadoLoteInvalido e) {
			this.fechaVTO = "-";
		}
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

	public String getFechaVTO() {
		return fechaVTO;
	}
}
