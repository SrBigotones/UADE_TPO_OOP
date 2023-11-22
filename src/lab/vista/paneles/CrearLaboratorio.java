package lab.vista.paneles;

import java.awt.GridLayout;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import lab.controlador.ControladorAdministrativo;
import lab.excepciones.SedeNoEncontrada;
import lab.vista.tablas.ModeloPeligrosSeleccion;
import net.miginfocom.swing.MigLayout;

public class CrearLaboratorio extends JPanel{
	private ControladorAdministrativo controlador;
	
	public CrearLaboratorio() {
		controlador = ControladorAdministrativo.getInstance();
		
		MigLayout layout = new MigLayout("fillx");
		setLayout(layout);
		ModeloPeligrosSeleccion modelo = new ModeloPeligrosSeleccion(controlador.listarPeligros());
		JTable peligros = new JTable(modelo);
		JScrollPane scrollPane = new JScrollPane(peligros);
		
		JTextField tfCapacidad = new JTextField();
		JButton btnCrearLaboratorio = new JButton("Crear Laboratorio");
		add(new JLabel("Peligros permitidos"), "top");
		add(scrollPane, "wrap,grow");
		add(new JLabel("Capacidad personas"));
		add(tfCapacidad, "wrap,grow");
		add(btnCrearLaboratorio, "skip, right");
		
		btnCrearLaboratorio.addActionListener(e -> {
			List<Integer> checkedPeligros = modelo.getDatos()
					.stream()
					.filter(x -> x.isCheck())
					.map(x -> x.getIdPeligro())
					.collect(Collectors.toList());
			
			try {
				controlador.darAltaLaboratorio(Integer.parseInt(tfCapacidad.getText()), checkedPeligros);
				JOptionPane.showMessageDialog(null, "Creado con exito!");
			} catch (NumberFormatException | SedeNoEncontrada e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error al crear");
			}
		});
		
	}
	
}
