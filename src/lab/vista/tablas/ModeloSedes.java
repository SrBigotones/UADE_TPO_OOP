package lab.vista.tablas;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import lab.vista.view.SedeView;

public class ModeloSedes extends AbstractTableModel {

	List<SedeView> datos;

	public ModeloSedes() {
		datos = new ArrayList<>();
	}

	public void setDatos(List<SedeView> datos) {
		this.datos = datos;
	}

	@Override
	public int getRowCount() {
		return datos.size();
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		SedeView sede = datos.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return sede.getProvincia();
		case 1:
			return sede.getAdministrativo();
		case 2:
			return sede.getNroLabs();
		default:
			return null;
		}
	}

}
