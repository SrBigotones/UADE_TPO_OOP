package lab.vista.tablas;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import lab.vista.view.LaboratorioView;

public class ModeloLaboratorio extends AbstractTableModel{
	private List<LaboratorioView> datos;
	private String[] colNames = {"ID","Capacidad"};
	
	
	public ModeloLaboratorio(List<LaboratorioView> datos) {
		this.datos = datos;
	}
	
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return colNames[column];
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return datos.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		LaboratorioView lab = datos.get(rowIndex);
		
		switch(columnIndex) {
		case 0:
			return lab.getIdLab();
		case 1:
			return lab.getCapacidadPersonas();
		}
		return null;
	}
	
}
