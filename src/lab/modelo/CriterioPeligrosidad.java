package lab.modelo;

import java.time.LocalDate;

public class CriterioPeligrosidad extends EstrategiaVencimiento {

	public CriterioPeligrosidad(String descripcion) {
		super(descripcion);
	}

	@Override
	public LocalDate calcularVencimiento(PruebaLote lote) {
		// TODO Auto-generated method stub
		long diasVencimientoMinimo  = Integer.MAX_VALUE;
		
		for (TipoPeligro i : lote.getProductoQuimico().getPeligros() ) {
			if(diasVencimientoMinimo  > i.getDiasVencimineto())
				diasVencimientoMinimo  = i.getDiasVencimineto();
		}
		
		
		return lote.getFechaFabricacion().plusDays(diasVencimientoMinimo );
	}
}
