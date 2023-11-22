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
import lab.vista.tablas.ModeloLaboratorio;
import lab.vista.tablas.ModeloPruebaLote;
import lab.vista.tablas.ModeloSedes;
import lab.vista.view.CriterioVencimientoView;
import lab.vista.view.LaboratorioView;
import lab.vista.view.PruebaLoteView;
import net.miginfocom.swing.MigLayout;

public class CambiarCriterioVencimiento extends JPanel {
	private ControladorGerente controlador;

	public CambiarCriterioVencimiento() {
		controlador = ControladorGerente.getInstance();

		MigLayout layout = new MigLayout("fillx");
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

		for (CriterioVencimientoView crit : controlador.listarCriterioVencimiento()) {
			comboCriterio.addItem(crit);
		}

		JButton btnCambiarCriterio = new JButton("Cambiar Criterio");

		add(new JLabel("Sedes"), "top");
		add(scrollSedes, "wrap, grow");
		add(new JLabel("Laboratorios"), "top");
		add(scrollLab, "wrap, grow");
		add(new JLabel("Pruebas"), "top");
		add(scrollPrueba, "wrap, grow");
		add(new JLabel("Criterio"));
		add(comboCriterio, "wrap, grow");
		add(btnCambiarCriterio, "skip, right");

		// Tengo un bug aca, al cambiar seleccion de tabla cuando ya habias elegido en
		// las otras tablas
		tablaSedes.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
//					tablaSedes.clearSelection();
				tablaLab.clearSelection();
				tablaPrueba.clearSelection();

				int idSede = (int) tablaSedes.getValueAt(tablaSedes.getSelectedRow(), 0);
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
				if (tablaLab.getSelectedRow() < 0)
					return;

				int idSede = (int) tablaSedes.getValueAt(tablaSedes.getSelectedRow(), 0);
				int idLab = (int) tablaLab.getValueAt(tablaLab.getSelectedRow(), 0);
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
			int idSede = (int) tablaSedes.getValueAt(tablaSedes.getSelectedRow(), 0);
			int idLab = (int) tablaLab.getValueAt(tablaLab.getSelectedRow(), 0);
			int idPrueba = (int) tablaPrueba.getValueAt(tablaPrueba.getSelectedRow(), 0);
			try {
				controlador.cambiarCriterioVencimiento(idSede, idLab, idPrueba,
						comboCriterio.getItemAt(comboCriterio.getSelectedIndex()).getIdEstrategia());
				JOptionPane.showMessageDialog(null, "Creado con exito!");
			} catch (SedeNoEncontrada | PruebaLoteNoEncontrado | LaboratorioNoEncontrado | AccesoRestringido
					| EmpleadoNoEncontrado e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e1.getMessage());
				e1.printStackTrace();
			}
		});

	}

}
