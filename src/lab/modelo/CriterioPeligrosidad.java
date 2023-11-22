package lab.modelo;

import java.time.LocalDate;

public class CriterioPeligrosidad extends EstrategiaVencimiento {

	public CriterioPeligrosidad(String descripcion) {
		super(descripcion);
	}

	@Override
	public LocalDate calcularVencimiento(PruebaLote lote) {
		long diasVencimientoMinimo  = Integer.MAX_VALUE;
		
		for (TipoPeligro peligro : lote.getProductoQuimico().getPeligros() ) {
			if(diasVencimientoMinimo  > peligro.getDiasVencimineto())
				diasVencimientoMinimo  = peligro.getDiasVencimineto();
		}
		
		
		return lote.getFechaFabricacion().plusDays(diasVencimientoMinimo );
	}
}
