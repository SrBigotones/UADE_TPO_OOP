package lab.vista;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.border.EmptyBorder;

public class Menu extends JFrame {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Menu");
		frame.setSize(1000, 700); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.setLayout(new GridLayout(1, 2));
	
		JPanel panelIzquierdo = new JPanel();
		JPanel panelDerecho = new JPanel();
		
        panelIzquierdo.setLayout(new FlowLayout(FlowLayout.CENTER));
		
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
		
		panelIzquierdo.add(botonSede);
		panelIzquierdo.add(botonProductos);
		panelIzquierdo.add(botonLotes);
		panelIzquierdo.add(botonLaboratorio);
		panelIzquierdo.add(botonAltas);

		
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelIzquierdo, panelDerecho);

        splitPane.setDividerLocation(200);
        frame.add(splitPane);
		frame.setVisible(true);
	}
}
