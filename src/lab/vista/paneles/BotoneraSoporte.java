package lab.vista.paneles;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import lab.controlador.ControladorSoporte;

public class BotoneraSoporte extends JPanel{
	
	private ControladorSoporte controlador;
	
	public BotoneraSoporte() {
		this.controlador = ControladorSoporte.getInstance();
		setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JButton botonSede = new JButton("Sedes");
		JButton botonProductos = new JButton("Productos");
		JButton botonLotes = new JButton("Lotes");
		JButton botonLaboratorio = new JButton("Laboratorio");
		JButton botonAltas = new JButton("Altas");
		
		botonSede.setBorder(new EmptyBorder(10,10,10,10));
		botonProductos.setBorder(new EmptyBorder(10,10,10,10));
		botonLotes.setBorder(new EmptyBorder(10,10,10,10));
		botonLaboratorio.setBorder(new EmptyBorder(10,10,10,10));
		botonAltas.setBorder(new EmptyBorder(10,10,10,10));
		
		Dimension dimension = new Dimension(150,50);
		botonSede.setPreferredSize(dimension);
		botonProductos.setPreferredSize(dimension);
		botonLotes.setPreferredSize(dimension);
		botonLaboratorio.setPreferredSize(dimension);
		botonAltas.setPreferredSize(dimension);
		
		Font font = new Font("Arial", Font.PLAIN, 16);
		botonSede.setFont(font);
		botonProductos.setFont(font);
		botonLotes.setFont(font);
		botonLaboratorio.setFont(font);
		botonAltas.setFont(font);
		
		add(botonSede);
		add(botonProductos);
		add(botonLotes);
		add(botonLaboratorio);
		add(botonAltas);
		
		botonSede.addActionListener(e -> {
			controlador.verSedes();
		});
	}
	
}
