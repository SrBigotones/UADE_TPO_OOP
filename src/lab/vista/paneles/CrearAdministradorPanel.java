package lab.vista.paneles;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class CrearAdministradorPanel extends JFrame{

	public static void main(String[] args) {
		
		 JFrame frame = new JFrame();
	        frame.setSize(1000, 700);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        JPanel panelIzquierdo = new JPanel();
	        JPanel panelDerecho = new JPanel();
	        panelDerecho.setLayout(new GridBagLayout());
	       
	        panelIzquierdo.setPreferredSize(new Dimension(200, frame.getHeight()));
	        panelIzquierdo.setMaximumSize(new Dimension(200, Integer.MAX_VALUE));
	        
	        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelIzquierdo, panelDerecho);
	        splitPane.setDividerLocation(200);
	        splitPane.setMinimumSize(new Dimension(200, 0));
	        
	        
	        JLabel nombre = new JLabel("Nombre:");
	        JLabel sede = new JLabel("Sede:");
	        JTextField nombreTextField = new JTextField(15); 
	        JTextField sedeTextField = new JTextField(15);
	        
	        JButton altaUsuarioButton = new JButton("Alta de Usuario");
	        
	        GridBagConstraints cuadrilla = new GridBagConstraints();
	        cuadrilla.gridx = 0;
	        cuadrilla.gridy = 0;
	        cuadrilla.insets = new Insets(5, 5, 5, 5);
	        
	        cuadrilla.anchor = GridBagConstraints.WEST;
	        
	        panelDerecho.add(nombre, cuadrilla);
	        cuadrilla.gridy++;
	        panelDerecho.add(nombreTextField, cuadrilla);
	        cuadrilla.gridy++;
	        panelDerecho.add(sede, cuadrilla);
	        cuadrilla.gridy++;
	        panelDerecho.add(sedeTextField, cuadrilla);
	        cuadrilla.gridy++;
	        cuadrilla.fill = GridBagConstraints.HORIZONTAL; 
	        panelDerecho.add(altaUsuarioButton, cuadrilla);
	        
	        frame.add(splitPane);
	        frame.setVisible(true);
	        
	    }
	}