package lab.vista.paneles;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import lab.controlador.ControladorGerente;

public class BotoneraGerente extends JPanel{
	private ControladorGerente controlador;
	
	public BotoneraGerente() {
		controlador = ControladorGerente.getInstance();
		GridLayout layout = new GridLayout(10, 1);
		setLayout(layout);
		
		JButton btnCambiarCriterioVencimiento = new JButton("Cambiar criterio y confirmar");

		
		add(btnCambiarCriterioVencimiento);
		
		btnCambiarCriterioVencimiento.addActionListener(e -> {
			controlador.mostrarCambiarCriterioVencimiento();
		});
		
	}
}
