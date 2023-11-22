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
import lab.vista.dialog.DialogCrearPerfilTecnico;
import lab.vista.tablas.ModeloPerfilesTecnicos;
import lab.vista.view.PerfilTecnicoView;
import net.miginfocom.swing.MigLayout;

public class ListadoPerfilesTecnicos extends JPanel {

	private ControladorSoporte controlador;

	public ListadoPerfilesTecnicos(List<PerfilTecnicoView> perfiles) {
		controlador = ControladorSoporte.getInstance();
		System.out.println("Listado de perfiles tecnicos");

		setLayout(new MigLayout("", "20[100%]20", "[][]"));

		ModeloPerfilesTecnicos modelo = new ModeloPerfilesTecnicos();
		modelo.setDatos(perfiles);
		JTable tabla = new JTable(modelo);
		JScrollPane scrollPane = new JScrollPane(tabla);

		JButton btnCrearPerfil = new JButton("Crear perfil");
		btnCrearPerfil.addActionListener((e) -> {
			JDialog dialogCrearPerfil = new DialogCrearPerfilTecnico((JFrame) SwingUtilities.getWindowAncestor(this));
			dialogCrearPerfil.setVisible(true);
			controlador.mostrarPantallaPerfilesTecnicos();
		});

		JPanel botonera = new JPanel(new MigLayout("", "", ""));
		botonera.add(btnCrearPerfil, "wrap");

		add(botonera, "cell 0 0");
		add(scrollPane, "cell 0 1, grow");

	}

}
