package lab.vista.tablas;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import lab.vista.view.SedeView;

public class ModeloSedes extends AbstractTableModel {

	private List<SedeView> datos;
	private String[] columnas = new String[] { "ID","Provincia", "Administrativo", "Gerente", "Cantidad de laboratorios" };

	public ModeloSedes() {
		datos = new ArrayList<>();
	}

	public void setDatos(List<SedeView> datos) {
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
		SedeView sede = datos.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return sede.getId();
		case 1:
			return sede.getProvincia();
		case 2:
			return sede.getAdministrativo();
		case 3:
			return sede.getGerente();
		case 4:
			return sede.getNroLabs();
		default:
			return null;
		}
	}

}
