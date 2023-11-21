package lab.vista.paneles;

import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import lab.vista.tablas.ModeloSedes;
import lab.vista.view.SedeView;

public class ListadoSedes extends JPanel {

	public ListadoSedes(List<SedeView> sedes) {
		System.out.println("Hello World!");
		ModeloSedes modelo = new ModeloSedes();
		modelo.setDatos(sedes);
		JTable tabla = new JTable(modelo);
		JScrollPane scrollPane = new JScrollPane(tabla);
		add(scrollPane);
	}
}
