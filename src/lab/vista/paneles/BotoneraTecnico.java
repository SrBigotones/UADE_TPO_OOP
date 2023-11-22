package lab.vista.paneles;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import lab.controlador.ControladorTecnico;
import lab.excepciones.LaboratorioNoEncontrado;
import lab.excepciones.SedeNoEncontrada;

public class BotoneraTecnico extends JPanel{
	private ControladorTecnico controlador;
	
	public BotoneraTecnico() {
		controlador = ControladorTecnico.getInstance();
		GridLayout layout = new GridLayout(4, 1);
		setLayout(layout);
		
		
		JButton btnReservarLaboratorio = new JButton("Reservar Laboratorio");
		JButton btnActualizarEstadoPrueba = new JButton("Actualizar Estado Prueba");
		JButton btnIncribirseAPrueba = new JButton("Inscribirse a prueba");
		JButton btnCrearElementoQuimico = new JButton("Crear Elemento Quimico");
		
		
		add(btnActualizarEstadoPrueba);
		add(btnCrearElementoQuimico);
		add(btnIncribirseAPrueba);
		add(btnReservarLaboratorio);
		
		
		btnActualizarEstadoPrueba.addActionListener(e -> {
			try {
				controlador.mostrarActualizarEstadoPrueba();
			} catch (SedeNoEncontrada e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (LaboratorioNoEncontrado e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		btnCrearElementoQuimico.addActionListener(e -> {
			controlador.mostrarCrearElementoQuimico();
		});
		
		btnIncribirseAPrueba.addActionListener(e -> {
			controlador.mostrarInscribirseAPrueba();
		});
		
		btnReservarLaboratorio.addActionListener(e -> {
			controlador.mostrarReservarPrueba();
		});
	}
}
