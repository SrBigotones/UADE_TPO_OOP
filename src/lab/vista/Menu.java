package lab.vista;

import javax.swing.JFrame;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class Menu extends JFrame {
	private JPanel panelDerecho;

	public Menu(JPanel panelIzq, JPanel panelDer) {
		this.panelDerecho = panelDer;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 500);
		setLocationRelativeTo(null);
		setLayout(new MigLayout("", "10[20%]5[80%]10", "[100%]20"));
		add(panelIzq, "cell 0 0, top");
		add(panelDer, "cell 1 0, grow, center");
		setVisible(true);
	}

	public void updateView(JPanel panelNuevo) {
 		remove(panelDerecho);
		add(panelNuevo, "cell 1 0, grow, center");
		this.panelDerecho = panelNuevo;
		revalidate();
		repaint();
	}

}
