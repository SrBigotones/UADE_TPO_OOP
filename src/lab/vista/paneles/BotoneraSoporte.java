package lab.vista.paneles;

import java.awt.Font;

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
		JButton botonProductos = new JButton("Productos");
		JButton botonLotes = new JButton("Lotes");
		JButton botonLaboratorio = new JButton("Laboratorio");
		JButton botonAltas = new JButton("Altas");

		Font font = new Font("Arial", Font.PLAIN, 16);
		botonSede.setFont(font);
		botonProductos.setFont(font);
		botonLotes.setFont(font);
		botonLaboratorio.setFont(font);
		botonAltas.setFont(font);

		add(botonSede, "wrap");
		add(botonProductos, "wrap");
		add(botonLotes, "wrap");
		add(botonLaboratorio, "wrap");
		add(botonAltas, "wrap");

		botonSede.addActionListener(e -> {
			controlador.mostrarPantallaSedes();
		});
	}

}
