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
import lab.vista.dialog.DialogCrearEmpleado;
import lab.vista.tablas.ModeloEmpleados;
import lab.vista.view.EmpleadoView;
import net.miginfocom.swing.MigLayout;

public class ListadoAdministrativos extends JPanel {

	private ControladorSoporte controlador;

	public ListadoAdministrativos(List<EmpleadoView> empleados) {
		controlador = ControladorSoporte.getInstance();
		System.out.println("Listado de administrativos");

		setLayout(new MigLayout("", "20[80%]10[20%]20", "[]"));

		ModeloEmpleados modelo = new ModeloEmpleados();
		modelo.setDatos(empleados);
		JTable tabla = new JTable(modelo);
		JScrollPane scrollPane = new JScrollPane(tabla);

		JButton btnCrearEmpleadoAdministrativo = new JButton("Crear empleado administrativo");
		btnCrearEmpleadoAdministrativo.addActionListener((e) -> {
			JDialog dialogCrearEmpleadoAdministrativo = new DialogCrearEmpleado(
					(JFrame) SwingUtilities.getWindowAncestor(this));
			dialogCrearEmpleadoAdministrativo.setVisible(true);
			controlador.mostrarPantallaAdministrativos();
		});

		JPanel botonera = new JPanel(new MigLayout("", "[fill, grow]", ""));
		botonera.add(btnCrearEmpleadoAdministrativo, "wrap");

		add(scrollPane, "cell 0 0, grow");
		add(botonera, "cell 1 0");

	}
}
