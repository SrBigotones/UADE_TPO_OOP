package lab.vista.paneles;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

import lab.controlador.ControladorSoporte;
import lab.vista.dialog.DialogCrearSede;
import lab.vista.tablas.ModeloSedes;
import lab.vista.view.SedeView;
import net.miginfocom.swing.MigLayout;

public class ListadoSedes extends JPanel {

	private ControladorSoporte controlador;

	public ListadoSedes(List<SedeView> sedes) {
		controlador = ControladorSoporte.getInstance();
		System.out.println("Listado de sedes");

		setLayout(new MigLayout("debug", "[80%!]10[20%!]", "[]"));

		ModeloSedes modelo = new ModeloSedes();
		modelo.setDatos(sedes);
		JTable tabla = new JTable(modelo);
		JScrollPane scrollPane = new JScrollPane(tabla);
		

		JButton btnCrearSede = new JButton("Crear sede");
		btnCrearSede.addActionListener((e) -> {
			JDialog dialogCrearSede = new DialogCrearSede((JFrame) SwingUtilities.getWindowAncestor(this), controlador);
			dialogCrearSede.setVisible(true);
			controlador.mostrarPantallaSedes();
		});

		JPanel botonera = new JPanel(new MigLayout("", "[fill, grow]", ""));
		botonera.add(btnCrearSede, "wrap");
		
		add(scrollPane, "cell 0 0, grow");
		add(botonera, "cell 1 0");
	}
}
