package lab.vista.paneles;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import lab.controlador.ControladorGerente;
import lab.excepciones.AccesoRestringido;
import lab.excepciones.EmpleadoNoEncontrado;
import lab.excepciones.LaboratorioNoEncontrado;
import lab.excepciones.PruebaLoteNoEncontrado;
import lab.excepciones.SedeNoEncontrada;
import lab.modelo.enums.EstadoLote;
import lab.vista.tablas.ModeloLaboratorio;
import lab.vista.tablas.ModeloPruebaLote;
import lab.vista.tablas.ModeloSedes;
import lab.vista.view.CriterioVencimientoView;
import lab.vista.view.LaboratorioView;
import lab.vista.view.PruebaLoteView;

public class CambiarCriterioVencimiento extends JPanel{
	private ControladorGerente controlador;
	
	public CambiarCriterioVencimiento() {
		controlador = ControladorGerente.getInstance();
		
		GridLayout layout = new GridLayout(7,2);
		setLayout(layout);
		
		ModeloSedes modeloSedes = new ModeloSedes();
		modeloSedes.setDatos(controlador.listarSedes());
		JTable tablaSedes = new JTable(modeloSedes);
		JScrollPane scrollSedes = new JScrollPane(tablaSedes);
		
		
		
		ModeloLaboratorio modeloLab = new ModeloLaboratorio(new ArrayList<LaboratorioView>());
		JTable tablaLab = new JTable(modeloLab);
		JScrollPane scrollLab = new JScrollPane(tablaLab);
		
		ModeloPruebaLote modeloPrueba = new ModeloPruebaLote(new ArrayList<PruebaLoteView>());
		JTable tablaPrueba = new JTable(modeloPrueba);
		JScrollPane scrollPrueba = new JScrollPane(tablaPrueba);
		
		
		JComboBox<CriterioVencimientoView> comboCriterio = new JComboBox<>();
		
		for(CriterioVencimientoView crit: controlador.listarCriterioVencimiento()) {
			comboCriterio.addItem(crit);
		}
		
		
		JButton btnCambiarCriterio = new JButton("Cambiar Criterio");
		
		
		add(new JLabel("Sedes:"));
		add(scrollSedes);
		add(new JLabel("Laboratorios:"));
		add(scrollLab);
		add(new JLabel("Pruebas:"));
		add(scrollPrueba);
		add(new JLabel("Criterio:"));
		add(comboCriterio);
		add(new JLabel(""));
		add(btnCambiarCriterio);
		
		
		tablaSedes.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent e) {
					tablaLab.clearSelection();
					modeloLab.setDatos(new ArrayList<>());
					modeloLab.fireTableDataChanged();
					
					int idSede = (int)tablaSedes.getValueAt(tablaSedes.getSelectedRow(), 0);
					try {
						modeloLab.setDatos(controlador.listarLaboratorios(idSede));
						modeloLab.fireTableDataChanged();
					} catch (SedeNoEncontrada e1) {
						// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		tablaLab.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int idSede = (int)tablaSedes.getValueAt(tablaSedes.getSelectedRow(), 0);
				int idLab = (int)tablaLab.getValueAt(tablaLab.getSelectedRow(), 0);
				try {
					modeloPrueba.setDatos(controlador.listarPruebasEnLaboratorio(idSede, idLab));
					modeloPrueba.fireTableDataChanged();
				} catch (LaboratorioNoEncontrado | SedeNoEncontrada e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		btnCambiarCriterio.addActionListener(e -> {
			int idSede = (int)tablaSedes.getValueAt(tablaSedes.getSelectedRow(), 0);
			int idLab = (int)tablaLab.getValueAt(tablaLab.getSelectedRow(), 0);
			int idPrueba = (int)tablaPrueba.getValueAt(tablaPrueba.getSelectedRow(), 0);
			try {
				controlador.cambiarCriterioVencimiento(idSede, idLab,idPrueba, comboCriterio.getItemAt(comboCriterio.getSelectedIndex()).getIdEstrategia());
				JOptionPane.showMessageDialog(null, "Creado con exito!");
			} catch (SedeNoEncontrada | PruebaLoteNoEncontrado | LaboratorioNoEncontrado | AccesoRestringido | EmpleadoNoEncontrado e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e1.getMessage());
				e1.printStackTrace();
			}
		});
		
		
		
	}
	
	
}
