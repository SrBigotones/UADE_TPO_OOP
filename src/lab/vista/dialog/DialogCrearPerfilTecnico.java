package lab.vista.dialog;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import lab.controlador.ControladorSoporte;
import net.miginfocom.swing.MigLayout;

public class DialogCrearPerfilTecnico extends JDialog {
	ControladorSoporte controlador;

	public DialogCrearPerfilTecnico(JFrame padre) {
		super(padre, JDialog.DEFAULT_MODALITY_TYPE);
		setLayout(new MigLayout("", "[fill, grow][fill, grow]", ""));
		setSize(300, 300);
		setLocationRelativeTo(padre);
		controlador = ControladorSoporte.getInstance();

		controlador = ControladorSoporte.getInstance();
		setLayout(new MigLayout("", "[fill, grow][fill, grow]", ""));

		JTextField tfNombre = new JTextField();
		JTextField tfSueldo = new JTextField();
		JTextField tfReservas = new JTextField();
		JButton btnCrearPerfil = new JButton("Confirmar");
		JButton btnCancelar = new JButton("Cancelar");

		add(new JLabel("Nombre"));
		add(tfNombre, "wrap");
		add(new JLabel("Sueldo"));
		add(tfSueldo, "wrap");
		add(new JLabel("Max Reservas"));
		add(tfReservas, "wrap");
		add(btnCrearPerfil, "wrap, span 2");
		add(btnCancelar, "wrap, span 2");

		btnCrearPerfil.addActionListener(e -> {
			controlador.crearPerfilTecnico(tfNombre.getText(), Double.parseDouble(tfSueldo.getText()),
					Integer.parseInt(tfReservas.getText()));
			JOptionPane.showMessageDialog(null, "¡Perfil creado con exito!");
			dispose();
		});

		btnCancelar.addActionListener((e) -> {
			dispose();
		});

	}

}
