package lab.vista.paneles;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import lab.controlador.ControladorAdministrativo;
import net.miginfocom.swing.MigLayout;

public class CrearEmpleadoGerente extends JPanel{

	private ControladorAdministrativo controlador;
	
	public CrearEmpleadoGerente() {
		controlador = ControladorAdministrativo.getInstance();
		MigLayout layout = new MigLayout("fillx");
		setLayout(layout);
		
		JTextField tfNombre = new JTextField();
		JTextField tfUsername = new JTextField();
		JLabel lblNombre = new JLabel("Nombre");
		JLabel lblUsername = new JLabel("Username");
		JButton btnCrearGerente = new JButton("Crear Gerente");
		
		add(lblNombre);
		add(tfNombre, "wrap,grow");
		add(lblUsername);
		add(tfUsername, "wrap,grow");
		add(btnCrearGerente, "skip, right");
		
		
		btnCrearGerente.addActionListener(e -> {
			controlador.darAltaGerente(tfNombre.getText(), tfUsername.getText());
			JOptionPane.showMessageDialog(null, "Creado con exito!");
		});
	}
}
