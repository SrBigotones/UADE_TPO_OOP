package lab.vista.tablas;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import lab.vista.view.LaboratorioView;

public class ModeloLaboratorio extends AbstractTableModel {
	private List<LaboratorioView> datos;
	private String[] colNames = { "ID", "Capacidad", "Tipos de peligro" };

	public ModeloLaboratorio(List<LaboratorioView> datos) {
		this.datos = datos;
	}

	@Override
	public String getColumnName(int column) {
		return colNames[column];
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
		LaboratorioView lab = datos.get(rowIndex);

		switch (columnIndex) {
		case 0:
			return lab.getIdLab();
		case 1:
			return lab.getCapacidadPersonas();
		case 2:
			return lab.getStringPeligros();
		}
		return null;
	}

	public List<LaboratorioView> getDatos() {
		return datos;
	}

	public void setDatos(List<LaboratorioView> datos) {
		this.datos = datos;
	}
	
}
