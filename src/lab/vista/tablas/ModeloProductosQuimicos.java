package lab.vista.tablas;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import lab.vista.view.EmpleadoView;
import lab.vista.view.ProductoQuimicoView;

public class ModeloProductosQuimicos extends AbstractTableModel {
	private List<ProductoQuimicoView> datos;
	private String[] columnas = new String[] { "Nombre comercial", "Tipo de producto", "Formula", "Peligros" };

	public ModeloProductosQuimicos() {
		datos = new ArrayList<>();
	}

	public void setDatos(List<ProductoQuimicoView> datos) {
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
		ProductoQuimicoView sede = datos.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return sede.getNombreComercial();
		case 1:
			return sede.getTipoProducto();
		case 2:
			return sede.generarStringFormula();
		case 3:
			return sede.generarStringPeligros();
		default:
			return null;
		}
	}
}
