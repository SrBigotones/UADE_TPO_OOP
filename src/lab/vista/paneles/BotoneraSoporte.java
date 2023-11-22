package lab.vista.paneles;

import javax.swing.JButton;
import javax.swing.JPanel;

import lab.controlador.ControladorSoporte;
import net.miginfocom.swing.MigLayout;

public class BotoneraSoporte extends JPanel {

	private ControladorSoporte controlador;

	public BotoneraSoporte() {
		this.controlador = ControladorSoporte.getInstance();
		setLayout(new MigLayout("", "[fill, grow]", "[]"));

		JButton botonSede = new JButton("Sedes");
		JButton botonAdministrativos = new JButton("Empleados administrativos");
		JButton botonPerfilesTecnicos = new JButton("Perfiles técnicos");

		add(botonSede, "wrap");
		add(botonAdministrativos, "wrap");
		add(botonPerfilesTecnicos, "wrap");

		botonSede.addActionListener(e -> {
			controlador.mostrarPantallaSedes();
		});
		
		botonAdministrativos.addActionListener((e) -> {
			controlador.mostrarPantallaAdministrativos();
		});
		
		botonPerfilesTecnicos.addActionListener((e) -> {
			controlador.mostrarPantallaPerfilesTecnicos();
		});
	}

}
