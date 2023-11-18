package lab.modelo;

import java.time.LocalDate;

public class CriterioProducto extends EstrategiaVencimiento {

	public CriterioProducto(String descripcion) {
		super(descripcion);
	}

	@Override
	public LocalDate calcularVencimiento(PruebaLote lote) {
		// TODO Auto-generated method stub
		return null;
	}
}
