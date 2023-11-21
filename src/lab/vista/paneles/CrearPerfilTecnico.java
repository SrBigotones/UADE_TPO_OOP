package lab.vista.paneles;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import lab.controlador.ControladorSoporte;

public class CrearPerfilTecnico extends JPanel{
	ControladorSoporte controlador;
	
	public CrearPerfilTecnico() {
		controlador = ControladorSoporte.getInstance();
		
		JTextField tfNombre = new JTextField();
		JTextField tfSueldo = new JTextField();
		JTextField tfReservas = new JTextField();
		
		
		GridLayout layout = new GridLayout(4,2);
		setLayout(layout);
		
		add(new JLabel("Nombre:"));
		add(tfNombre);
		add(new JLabel("Sueldo:"));
		add(tfSueldo);
		add(new JLabel("Max Reservas:"));
		add(tfReservas);
		
		
		JButton btnCrearPerfil = new JButton("Crear Perfil Tecnico");		
		add(btnCrearPerfil);
		
		
		btnCrearPerfil.addActionListener(e -> {
			controlador.crearPerfilTecnico(tfNombre.getText(), Double.parseDouble(tfSueldo.getText()), Integer.parseInt(tfReservas.getText()));
			JOptionPane.showMessageDialog(null, "Creado con exito!");
		});
		
		
	}
	
}
