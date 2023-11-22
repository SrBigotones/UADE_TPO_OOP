package lab.vista.paneles;

import java.awt.GridLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import lab.controlador.ControladorAdministrativo;
import lab.vista.tablas.ModeloSedes;
import lab.vista.view.SedeView;

public class CrearEmpleadoGerente extends JPanel{

	private ControladorAdministrativo controlador;
	
	public CrearEmpleadoGerente() {
		controlador = ControladorAdministrativo.getInstance();
		GridLayout layout = new GridLayout();
		setLayout(layout);
		
		List<SedeView> sedes = controlador.listarSedes();
		
		JTextField tfNombre = new JTextField();
		JTextField tfUsername = new JTextField();
		
		
		ModeloSedes modeloSedes = new ModeloSedes();
		modeloSedes.setDatos(sedes);
		JTable tablaSedes = new JTable(modeloSedes);
		JScrollPane scrollPane = new JScrollPane(tablaSedes);
		add(new JLabel("Asignar a sede:"));
		add(scrollPane);
		add(new JLabel("Nombre:"));
		add(tfNombre);
		add(new JLabel("Username:"));
		add(tfUsername);
		
		JButton btnCrearGerente = new JButton("Crear Gerente");
		add(btnCrearGerente);
	}
}
