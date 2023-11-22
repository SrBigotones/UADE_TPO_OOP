package lab.vista.paneles;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

import lab.controlador.ControladorTecnico;
import lab.vista.dialog.DialogCrearProductoQuimico;
import lab.vista.tablas.ModeloProductosQuimicos;
import lab.vista.view.ProductoQuimicoView;
import net.miginfocom.swing.MigLayout;

public class ListadoProductosQuimicos extends JPanel {

	private ControladorTecnico controlador;

	public ListadoProductosQuimicos(List<ProductoQuimicoView> productos) {
		controlador = ControladorTecnico.getInstance();

		setLayout(new MigLayout("", "20[100%]20", "[][]"));

		ModeloProductosQuimicos modelo = new ModeloProductosQuimicos();
		modelo.setDatos(productos);
		JTable tabla = new JTable(modelo);
		JScrollPane scrollPane = new JScrollPane(tabla);

		JButton btnCrearProducto = new JButton("Crear producto químico");
		btnCrearProducto.addActionListener((e) -> {
			JDialog dialogCrearProductoQuimico = new DialogCrearProductoQuimico((JFrame) SwingUtilities.getWindowAncestor(this));
			dialogCrearProductoQuimico.setVisible(true);
			controlador.mostrarPantallaProductosQuimicos();
		});

		JPanel botonera = new JPanel(new MigLayout("", "", ""));
		botonera.add(btnCrearProducto, "wrap");

		add(botonera, "cell 0 0");
		add(scrollPane, "cell 0 1, grow");
	}
}
