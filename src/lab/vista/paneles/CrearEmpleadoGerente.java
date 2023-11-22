package lab.vista.paneles;

import java.awt.GridLayout;

import javax.swing.JPanel;

import lab.controlador.ControladorAdministrativo;

public class CrearEmpleadoGerente extends JPanel{

	private ControladorAdministrativo controlador;
	
	public CrearEmpleadoGerente() {
		controlador = ControladorAdministrativo.getInstance();
		GridLayout layout = new GridLayout();
		setLayout(layout);
	}
}
