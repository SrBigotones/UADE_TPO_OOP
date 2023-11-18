package lab.modelo;

import java.time.LocalDate;

public class CriterioMolecular extends EstrategiaVencimiento{

	public CriterioMolecular(String descripcion) {
		super(descripcion);
	}

	@Override
	public LocalDate calcularVencimiento(PruebaLote lote) {
		// TODO Auto-generated method stub
		return null;
	}


}
