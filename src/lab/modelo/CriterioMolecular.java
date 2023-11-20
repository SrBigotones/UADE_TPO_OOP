package lab.modelo;

import java.time.LocalDate;

public class CriterioMolecular extends EstrategiaVencimiento{

	public CriterioMolecular(String descripcion) {
		super(descripcion);
	}

	@Override
	public LocalDate calcularVencimiento(PruebaLote lote) {
		// TODO Auto-generated method stub
		
		long sumNumeroAtomico  = 0;
		
		for (ElementoQuimico i : lote.getProductoQuimico().getFormula().keySet() ) {
			sumNumeroAtomico = sumNumeroAtomico + i.getNroAtomico();
		}
		
		return lote.getFechaFabricacion().plusDays(sumNumeroAtomico/lote.getProductoQuimico().getFormula().size());
	}


}
