package lab.vista.paneles;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import lab.controlador.ControladorAdministrativo;
import lab.vista.tablas.ModeloPerfilTecnico;
import net.miginfocom.swing.MigLayout;

public class CrearEmpleadoTecnico extends JPanel{

	
	private ControladorAdministrativo controlador;
	
	public CrearEmpleadoTecnico() {
		controlador = ControladorAdministrativo.getInstance();
		
		MigLayout layout = new MigLayout("fillx");
		setLayout(layout);
		
		JLabel lblNombre = new JLabel("Nombre");
		JLabel lblUsername = new JLabel("Username");
		JLabel lblPerfilTecnico = new JLabel("Perfil técnico");
		
		JTextField tfNombre = new JTextField();
		JTextField tfUsername = new JTextField();
		
		JButton btnDarAlta = new JButton("Alta Tecnico");
		
		ModeloPerfilTecnico modelo = new ModeloPerfilTecnico(controlador.listarPerfilesTecnicos());
		JTable tblPerfilesTecnicos = new JTable(modelo);
		JScrollPane scrollPane = new JScrollPane(tblPerfilesTecnicos);
		add(lblNombre);
		add(tfNombre, "wrap, grow");
		add(lblUsername);
		add(tfUsername, "wrap, grow");
		add(lblPerfilTecnico, "top");
		add(scrollPane, "wrap, grow");
		add(btnDarAlta, "skip, right");
		
		
		btnDarAlta.addActionListener(x -> {
			String nombre = tfNombre.getText();
			String username = tfUsername.getText();
			int idPerfil = (int) tblPerfilesTecnicos.getValueAt(tblPerfilesTecnicos.getSelectedRow(), 0);
			controlador.darAltaTecnico(nombre, username, idPerfil);
			JOptionPane.showMessageDialog(null, "Creado con exito!");
		});
		
		
	}
}
