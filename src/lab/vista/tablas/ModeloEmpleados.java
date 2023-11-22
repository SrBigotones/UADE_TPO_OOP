package lab.vista.tablas;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import lab.vista.view.EmpleadoView;

public class ModeloEmpleados  extends AbstractTableModel {

	private List<EmpleadoView> datos;
	private String[] columnas = new String[] { "Nombre", "Tipo de empleado", "Sede/Provincia"};

	public ModeloEmpleados() {
		datos = new ArrayList<>();
	}

	public void setDatos(List<EmpleadoView> datos) {
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
		EmpleadoView sede = datos.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return sede.getNombre();
		case 1:
			return sede.getTipo();
		case 2:
			return sede.getSede();
		default:
			return null;
		}
	}
}
