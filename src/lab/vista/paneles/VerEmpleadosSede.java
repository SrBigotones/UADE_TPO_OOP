package lab.vista.paneles;

import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import lab.controlador.ControladorAdministrativo;
import lab.vista.tablas.ModeloEmpleados;
import lab.vista.view.EmpleadoView;
import net.miginfocom.swing.MigLayout;

public class VerEmpleadosSede extends JPanel {

	private ControladorAdministrativo controlador;

	public VerEmpleadosSede(List<EmpleadoView> empleados) {
		controlador = ControladorAdministrativo.getInstance();
		setLayout(new MigLayout("fillx"));

		ModeloEmpleados modelo = new ModeloEmpleados();
		modelo.setDatos(empleados);
		JTable tablaEmpleados = new JTable(modelo);
		JScrollPane scrollPaneEmpleados = new JScrollPane(tablaEmpleados);

		add(scrollPaneEmpleados);
	}

}
