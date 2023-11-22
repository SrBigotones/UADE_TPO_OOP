package lab.vista.tablas;

import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.table.AbstractTableModel;

import lab.vista.view.PeligrosViewCheck;
import lab.vista.view.PerfilTecnicoView;

public class ModeloPeligrosSeleccion extends AbstractTableModel{

	List<PeligrosViewCheck> datos;
	
	public ModeloPeligrosSeleccion(List<PeligrosViewCheck> datos) {
		this.datos = datos;
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return datos.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 4;
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
