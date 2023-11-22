package lab.vista.paneles;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import lab.controlador.ControladorAdministrativo;

public class BotoneraAdministrativo extends JPanel{
	
	private ControladorAdministrativo controlador;

	
	public BotoneraAdministrativo() {
		controlador = ControladorAdministrativo.getInstance();
		JButton btnAltaTecnico = new JButton("Alta Tecnico");
		JButton btnAltaGerente = new JButton("Alta Gerente");
		JButton btnAltaLaboratorio = new JButton("Alta Laboratorio");
		
		GridLayout layout = new GridLayout(10, 1);
		setLayout(layout);
		
		add(btnAltaTecnico);
		add(btnAltaGerente);
		add(btnAltaLaboratorio);
		
		
		btnAltaTecnico.addActionListener(x -> {controlador.mostrarAltaTecnico();});
		btnAltaGerente.addActionListener(x -> {controlador.mostrarAltaGerente();});
		btnAltaLaboratorio.addActionListener(x -> {controlador.mostrarAltaLaboratorio();});
		
		
	}
}
