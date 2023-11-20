package lab.modelo;

import java.time.LocalDate;

public class CriterioProducto extends EstrategiaVencimiento {

	public CriterioProducto(String descripcion) {
		super(descripcion);
	}

	@Override
	public LocalDate calcularVencimiento(PruebaLote lote) {
		// TODO Auto-generated method stub
		long minDiasVencimiento = Integer.MAX_VALUE;
		for(TipoPeligro peligro: lote.getProductoQuimico().getPeligros()) {
			minDiasVencimiento = Math.min(minDiasVencimiento, peligro.getDiasVencimineto());
		}
		
		return lote.getFechaFabricacion().plusDays(minDiasVencimiento);
	}

}
