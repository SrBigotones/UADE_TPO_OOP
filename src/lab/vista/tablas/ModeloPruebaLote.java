package lab.vista.tablas;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import lab.vista.view.PruebaLoteView;

public class ModeloPruebaLote extends AbstractTableModel {
	private List<PruebaLoteView> datos;
	
	private String[] colNames = { "ID", "Nombre Prod", "Tipo", "Fecha Fab", "Empleado", "Estado", "Auxiliares", "Aux. requeridos", "Formula Generica","FechaVTO"};

	@Override
	public String getColumnName(int column) {
		return colNames[column];
	}

	public ModeloPruebaLote(List<PruebaLoteView> datos) {
		this.datos = datos;
	}

	@Override
	public int getRowCount() {
		return datos.size();
	}

	@Override
	public int getColumnCount() {
		return colNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		PruebaLoteView prueba = datos.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return prueba.getIdPruebaLote();
		case 1:
			return prueba.getNombreProdQuimico();
		case 2:
			return prueba.getTipoProducto();
		case 3:
			return prueba.getFechaFabricacion();
		case 4:
			return prueba.getNombreResponsable();
		case 5:
			return prueba.getEstadoLote();
		case 6:
			return prueba.getAuxiliares().size();
		case 7:
			return prueba.getMaxAuxiliares();
		case 8:
			return prueba.getFormulaGenerica();
		case 9:
			return prueba.getFechaVTO();
		}
		return null;
	}

	public List<PruebaLoteView> getDatos() {
		return datos;
	}

	public void setDatos(List<PruebaLoteView> datos) {
		this.datos = datos;
	}

}
