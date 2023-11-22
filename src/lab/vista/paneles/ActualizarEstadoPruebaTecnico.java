package lab.vista.paneles;

import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import lab.controlador.ControladorTecnico;
import lab.excepciones.LaboratorioNoEncontrado;
import lab.excepciones.PruebaLoteNoEncontrado;
import lab.excepciones.SedeNoEncontrada;
import lab.modelo.CriterioMolecular;
import lab.modelo.enums.EstadoLote;
import lab.vista.tablas.ModeloLaboratorio;
import lab.vista.tablas.ModeloPruebaLote;
import lab.vista.view.PruebaLoteView;

public class ActualizarEstadoPruebaTecnico extends JPanel{
	private ControladorTecnico controlador;
	public ActualizarEstadoPruebaTecnico() throws SedeNoEncontrada, LaboratorioNoEncontrado {
		controlador = ControladorTecnico.getInstance();
		GridLayout layout = new GridLayout(4, 2);
		setLayout(layout);
		
		ModeloLaboratorio modeloLab = new ModeloLaboratorio(controlador.listarLaboratorios());
		JTable tablaLabs = new JTable(modeloLab);
		JScrollPane scrollPaneLabs = new JScrollPane(tablaLabs);
		
		
		ModeloPruebaLote modeloPruebas = new ModeloPruebaLote(new ArrayList<PruebaLoteView>());
		JTable tablaPruebas = new JTable(modeloPruebas);
		JScrollPane scrollPane = new JScrollPane(tablaPruebas);
		
		JComboBox<EstadoLote> comboEstados = new JComboBox<>();
		comboEstados.addItem(EstadoLote.RECHAZADO);
		comboEstados.addItem(EstadoLote.ACEPTADO);
	
		JButton btnActualizarEstado = new JButton("Actualizar Estado Prueba");
		add(new JLabel("Laboratorios:"));
		add(scrollPaneLabs);
		add(new JLabel("Pruebas:"));
		add(scrollPane);
		add(new JLabel("Estados:"));
		add(comboEstados);
		add(new JLabel(""));
		add(btnActualizarEstado);
		
		tablaLabs.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int value = (int)tablaLabs.getValueAt(tablaLabs.getSelectedRow(), 0);
				try {
					modeloPruebas.setDatos(controlador.listarPruebasEnLaboratorio(value));
					modeloPruebas.fireTableDataChanged();
				} catch (LaboratorioNoEncontrado | SedeNoEncontrada e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnActualizarEstado.addActionListener(e -> {
			int idLab = (int)tablaLabs.getValueAt(tablaLabs.getSelectedRow(), 0);
			int idLote = (int) tablaPruebas.getValueAt(tablaPruebas.getSelectedRow(), 0);
			EstadoLote estado = comboEstados.getItemAt(comboEstados.getSelectedIndex());
			try {
				controlador.actualizarPrueba(idLab, idLote,estado, new CriterioMolecular(""));
				JOptionPane.showMessageDialog(null, "Creado con exito!");
			} catch (SedeNoEncontrada | PruebaLoteNoEncontrado | LaboratorioNoEncontrado e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Algo no salio como se esperaba...");
				e1.printStackTrace();
			}
		});
		
		
		
		
	}
}
