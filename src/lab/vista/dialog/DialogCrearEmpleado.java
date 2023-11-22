package lab.vista.dialog;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import lab.controlador.ControladorSoporte;
import lab.vista.view.SedeView;
import net.miginfocom.swing.MigLayout;

public class DialogCrearEmpleado extends JDialog {

	private ControladorSoporte controlador;

	public DialogCrearEmpleado(JFrame padre) {
		super(padre, JDialog.DEFAULT_MODALITY_TYPE);
		setLayout(new MigLayout("", "[fill, grow][fill, grow]", ""));
		setSize(300, 250);
		setLocationRelativeTo(padre);
		controlador = ControladorSoporte.getInstance();

		JTextField txtNombre = new JTextField();
		JTextField txtUsername = new JTextField();
		JComboBox<SedeView> cbSede = new JComboBox<>(controlador.listarSedes().stream().toArray(SedeView[]::new));
		JButton btnConfirmar = new JButton("Confirmar");
		JButton btnCancelar = new JButton("Cancelar");
		JLabel lblError = new JLabel("");
		lblError.setForeground(Color.RED);

		add(new JLabel("Nombre:"));
		add(txtNombre, "wrap");
		add(new JLabel("Sede/Provincia:"));
		add(cbSede, "wrap");
		add(new JLabel("Username:"));
		add(txtUsername, "wrap");
		add(btnConfirmar, "wrap, span 2");
		add(btnCancelar, "wrap, span 2");
		add(lblError, "span 2");

		btnCancelar.addActionListener((e) -> {
			dispose();
		});

		btnConfirmar.addActionListener((e) -> {
			int idSede = ((SedeView) cbSede.getSelectedItem()).getId();
			String msgError = controlador.crearEmpleadoAdministrativo(txtNombre.getText(), txtUsername.getText(),
					idSede);
			if (msgError == null) {
				JOptionPane.showMessageDialog(null, "¡Administrativo creado con exito!");
				dispose();
			} else {
				lblError.setText(msgError);
			}
		});
	}
}
