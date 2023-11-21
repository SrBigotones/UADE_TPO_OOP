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
	private JPanel panelIzquierdo ;
	private JPanel panelDerecho ;
	private JSplitPane splitPane;
	JFrame frame = new JFrame("Menu");
	
	
	public Menu(JPanel panelIzq, JPanel panelDer) {
		this.panelIzquierdo = panelIzq;
		this.panelDerecho = panelDer;
		frame.setSize(1000, 700); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.setLayout(new GridLayout(1, 2));
		this.splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelIzquierdo, panelDerecho);
        splitPane.setDividerLocation(200);
        frame.add(splitPane);
		frame.setVisible(true);
	}


	public JPanel getPanelIzquierdo() {
		return panelIzquierdo;
	}


	public void setPanelIzquierdo(JPanel panelIzquierdo) {
		this.panelIzquierdo = panelIzquierdo;
	}


	public JPanel getPanelDerecho() {
		return panelDerecho;
	}


	public void setPanelDerecho(JPanel panelDerecho) {
		this.panelDerecho = panelDerecho;
	}
	
	public void updateView(JPanel panelNuevo) {
        splitPane.remove(panelDerecho);
        splitPane.add(panelNuevo);
        this.setPanelDerecho(panelNuevo);
        
	}
	
	
	
}
