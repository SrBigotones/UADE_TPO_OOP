package lab.vista.tablas;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import lab.vista.view.PerfilTecnicoView;

public class ModeloPerfilesTecnicos extends AbstractTableModel {

	List<PerfilTecnicoView> datos;
	String[] columnas = new String[] { "Nombre de perfil", "Sueldo", "Máximo de reservas" };

	public ModeloPerfilesTecnicos() {
		datos = new ArrayList<>();
	}

	public void setDatos(List<PerfilTecnicoView> datos) {
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
		PerfilTecnicoView perfil = datos.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return perfil.getNombre();
		case 1:
			return perfil.getSueldo();
		case 2:
			return perfil.getMaxReservas();
		default:
			return null;
		}
	}
}
