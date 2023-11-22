package lab.vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import lab.controlador.ControladorLogin;
import net.miginfocom.swing.MigLayout;

public class Menu extends JFrame {
	private JPanel panelCentral;

	public Menu(JPanel panelIzq, JPanel panelCentral) {
		this.panelCentral = panelCentral;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 500);
		setLocationRelativeTo(null);
		setLayout(new MigLayout("", "10[20%]5[75%]5[5%]10", "[100%]20"));
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener((e) -> {
			ControladorLogin.getInstance().inicializarLogin();
			dispose();
		});
		
		panelCentral.setBorder(new EtchedBorder());
		panelIzq.setBorder(new EtchedBorder());
		
		add(panelIzq, "cell 0 0, top");
		add(panelCentral, "cell 1 0, grow, center");
		add(btnLogout, "cell 2 0, top");
		setVisible(true);
	}

	public void updateView(JPanel panelNuevo) {
 		remove(panelCentral);
 		this.panelCentral = panelNuevo;
 		add(panelCentral, "cell 1 0, grow, center");
 		panelCentral.setBorder(new EtchedBorder());
 		revalidate();
		repaint();
	}

}
