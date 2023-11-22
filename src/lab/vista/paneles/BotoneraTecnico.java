package lab.vista.paneles;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import lab.controlador.ControladorTecnico;
import lab.excepciones.LaboratorioNoEncontrado;
import lab.excepciones.SedeNoEncontrada;
import net.miginfocom.swing.MigLayout;

public class BotoneraTecnico extends JPanel {
	private ControladorTecnico controlador;

	public BotoneraTecnico() {
		controlador = ControladorTecnico.getInstance();
		setLayout(new MigLayout("fillx"));

		JButton btnReservarLaboratorio = new JButton("Reservar Laboratorio");
		JButton btnActualizarEstadoPrueba = new JButton("Pruebas");
		JButton btnCrearProductoQuimico = new JButton("Crear Producto Quimico");

		add(btnActualizarEstadoPrueba, "wrap,grow");
		add(btnCrearProductoQuimico, "wrap,grow");
		add(btnReservarLaboratorio, "wrap,grow");

		btnActualizarEstadoPrueba.addActionListener(e -> {
			try {
				controlador.mostrarActualizarEstadoPrueba();
			} catch (SedeNoEncontrada | LaboratorioNoEncontrado e1) {
				e1.printStackTrace();
			}
		});

		btnCrearProductoQuimico.addActionListener(e -> {
			controlador.mostrarPantallaProductosQuimicos();
		});

		btnReservarLaboratorio.addActionListener(e -> {
			try {
				controlador.mostrarReservarPrueba();
			} catch (SedeNoEncontrada e1) {
				e1.printStackTrace();
			}
		});
	}
}
