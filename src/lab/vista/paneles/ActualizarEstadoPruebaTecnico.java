package lab.vista.paneles;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import lab.controlador.Controlador;
import lab.controlador.ControladorTecnico;
import lab.excepciones.LaboratorioNoEncontrado;
import lab.excepciones.PruebaLoteNoEncontrado;
import lab.excepciones.SedeNoEncontrada;
import lab.modelo.CriterioMolecular;
import lab.modelo.enums.EstadoLote;
import lab.vista.tablas.ModeloLaboratorio;
import lab.vista.tablas.ModeloPruebaLote;
import lab.vista.view.LaboratorioView;
import lab.vista.view.PruebaLoteView;
import net.miginfocom.swing.MigLayout;

public class ActualizarEstadoPruebaTecnico extends JPanel {
	private ControladorTecnico controlador;

	public ActualizarEstadoPruebaTecnico() throws SedeNoEncontrada, LaboratorioNoEncontrado {
		controlador = ControladorTecnico.getInstance();
		MigLayout layout = new MigLayout("fill", "", "");
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

		JButton btnInscribirse = new JButton("Inscribirse");
		btnInscribirse.setEnabled(false);

		JButton btnActualizarEstado = new JButton("Actualizar Estado Prueba");
		btnActualizarEstado.setEnabled(false);

		add(new JLabel("Laboratorios"), "top");
		add(scrollPaneLabs, "wrap, grow");
		add(new JLabel("Pruebas"), "top");
		add(scrollPane, "wrap, grow");
		add(new JLabel("Estados"));
		add(comboEstados, "wrap, grow");
		add(btnInscribirse, "skip,wrap");
		add(btnActualizarEstado, "skip");

		tablaLabs.getSelectionModel().addListSelectionListener((e) -> {
			int value = (int) tablaLabs.getValueAt(tablaLabs.getSelectedRow(), 0);
			try {
				modeloPruebas.setDatos(controlador.listarPruebasEnLaboratorio(value));
				modeloPruebas.fireTableDataChanged();
				btnActualizarEstado.setEnabled(false);
				btnInscribirse.setEnabled(false);
			} catch (LaboratorioNoEncontrado | SedeNoEncontrada e1) {
				e1.printStackTrace();
			}
		});

		tablaPruebas.getSelectionModel().addListSelectionListener((e) -> {
			if (tablaPruebas.getSelectedRow() < 0)
				return;
			PruebaLoteView pruebaSeleccionada = modeloPruebas.getDatos().get(tablaPruebas.getSelectedRow());
			btnActualizarEstado.setEnabled(EstadoLote.PENDIENTE.equals(pruebaSeleccionada.getEstadoLote()));
			if (pruebaSeleccionada.getAuxiliares().stream()
					.anyMatch((a) -> a.getIdEmpleado() == Controlador.getUsuario().getIdEmpleado())
					|| pruebaSeleccionada.getMaxAuxiliares() == pruebaSeleccionada.getAuxiliares().size()
					|| !EstadoLote.PENDIENTE.equals(pruebaSeleccionada.getEstadoLote()) || pruebaSeleccionada
							.getResponsable().getIdEmpleado() == Controlador.getUsuario().getIdEmpleado()) {
				btnInscribirse.setEnabled(false);

			} else {
				btnInscribirse.setEnabled(true);
			}
		});

		btnActualizarEstado.addActionListener(e -> {
			int idLab = (int) tablaLabs.getValueAt(tablaLabs.getSelectedRow(), 0);
			int idLote = (int) tablaPruebas.getValueAt(tablaPruebas.getSelectedRow(), 0);
			EstadoLote estado = comboEstados.getItemAt(comboEstados.getSelectedIndex());
			try {
				controlador.actualizarPrueba(idLab, idLote, estado, new CriterioMolecular(""));
				JOptionPane.showMessageDialog(null, "Creado con exito!");
				controlador.mostrarActualizarEstadoPrueba();
			} catch (SedeNoEncontrada | PruebaLoteNoEncontrado | LaboratorioNoEncontrado e1) {
				JOptionPane.showMessageDialog(null, "Algo no salio como se esperaba...");
				e1.printStackTrace();
			}
		});

		btnInscribirse.addActionListener((e) -> {
			PruebaLoteView prueba = modeloPruebas.getDatos().get(tablaPruebas.getSelectedRow());
			LaboratorioView lab = modeloLab.getDatos().get(tablaLabs.getSelectedRow());
			controlador.inscribirseAPrueba(Controlador.getUsuario().getIdEmpleado(), prueba.getIdPruebaLote(),
					lab.getIdLab());
			JOptionPane.showMessageDialog(null, "Inscripción realizada con éxito!");
			try {
				controlador.mostrarActualizarEstadoPrueba();
			} catch (SedeNoEncontrada | LaboratorioNoEncontrado e1) {
				e1.printStackTrace();
			}
		});
	}
}
