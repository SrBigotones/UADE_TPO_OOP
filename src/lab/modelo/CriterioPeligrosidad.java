package lab.modelo;

import java.time.LocalDate;

public class CriterioPeligrosidad extends EstrategiaVencimiento {

	public CriterioPeligrosidad(String descripcion) {
		super(descripcion);
	}

	@Override
	public LocalDate calcularVencimiento(PruebaLote lote) {
		// TODO Auto-generated method stub
		return null;
	}
}
