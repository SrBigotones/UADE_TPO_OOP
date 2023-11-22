package lab.vista.tablas;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import lab.vista.view.PerfilTecnicoView;

public class ModeloPerfilTecnico extends AbstractTableModel{
	private List<PerfilTecnicoView> datos;
	private final String[] colNames = {"ID", "Nombre", "Sueldo"};

	public ModeloPerfilTecnico(List<PerfilTecnicoView> datos) {
		this.datos = datos;
	}


	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return colNames[column];
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
		PerfilTecnicoView perfil = datos.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return perfil.getIdPerfil();
		case 1:
			return perfil.getNombre();
		case 2:
			return perfil.getSueldo();
		default:
			return null;
		}
	}
}
