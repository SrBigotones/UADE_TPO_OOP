package lab.vista.paneles;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import lab.controlador.ControladorAdministrativo;

public class CrearEmpleadoGerente extends JPanel{

	private ControladorAdministrativo controlador;
	
	public CrearEmpleadoGerente() {
		controlador = ControladorAdministrativo.getInstance();
		GridLayout layout = new GridLayout(3,2);
		setLayout(layout);
		
		JTextField tfNombre = new JTextField();
		JTextField tfUsername = new JTextField();
		JLabel lblNombre = new JLabel("Nombre:");
		JLabel lblUsername = new JLabel("Username:");
		JButton btnCrearGerente = new JButton("Crear Gerente");
		
		add(lblNombre);
		add(tfNombre);
		add(lblUsername);
		add(tfUsername);
		add(new JLabel());
		add(btnCrearGerente);
		
		
		btnCrearGerente.addActionListener(e -> {
			controlador.darAltaGerente(tfNombre.getText(), tfUsername.getText());
			JOptionPane.showMessageDialog(null, "Creado con exito!");
		});
	}
}
