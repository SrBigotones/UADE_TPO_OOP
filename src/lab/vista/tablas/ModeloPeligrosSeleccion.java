package lab.vista.tablas;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import lab.vista.view.PeligrosViewCheck;

public class ModeloPeligrosSeleccion extends AbstractTableModel{

	private List<PeligrosViewCheck> datos;
	private String[] columnas = new String[] { "", "id", "Nombre", "Costo" };
	
	public ModeloPeligrosSeleccion(List<PeligrosViewCheck> datos) {
		this.datos = datos;
	}
	
	@Override
	public String getColumnName(int column) {
		return columnas[column];
	}
	
	@Override
	public int getRowCount() {
		return datos.size();
	}

	@Override
	public int getColumnCount() {
		return columnas.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		PeligrosViewCheck peligro = datos.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return peligro.isCheck();
		case 1:
			return peligro.getIdPeligro();
		case 2:
			return peligro.getNombre();
		case 3:
			return peligro.getCosto();
		default:
			return null;
		}
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		if(columnIndex == 0) {
			return Boolean.class;
		}
		return super.getColumnClass(columnIndex);
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
		if(columnIndex == 0)
			return true;
		
		return super.isCellEditable(rowIndex, columnIndex);
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		if(columnIndex == 0)
			datos.get(rowIndex).setCheck((boolean)aValue);
		fireTableCellUpdated(rowIndex, columnIndex);
	}

	public List<PeligrosViewCheck> getDatos() {
		return datos;
	}

	public void setDatos(List<PeligrosViewCheck> datos) {
		this.datos = datos;
	}
	
	

}
