package lab.vista;

import javax.swing.JFrame;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class Menu extends JFrame {
	private JPanel panelDerecho;

	public Menu(JPanel panelIzq, JPanel panelDer) {
		this.panelDerecho = panelDer;
		setSize(1000, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new MigLayout("debug", "10[20%!, fill]5[80%!, fill]10", "[grow]"));
		add(panelIzq, "cell 0 0");
		add(panelDer, "cell 1 0");
		setVisible(true);

	}

	public void updateView(JPanel panelNuevo) {
		remove(panelDerecho);
		add(panelNuevo, "cell 1 0");
		this.panelDerecho = panelNuevo;
		revalidate();
	}

}
