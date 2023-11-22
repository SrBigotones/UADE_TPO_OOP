package lab.vista.dialog;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import lab.controlador.ControladorSoporte;
import lab.modelo.enums.Provincia;
import net.miginfocom.swing.MigLayout;

public class DialogCrearSede extends JDialog {

	public DialogCrearSede(JFrame padre, ControladorSoporte controlador) {
		super(padre, JDialog.DEFAULT_MODALITY_TYPE);
		setLayout(new MigLayout("", "[fill, grow]", ""));
		setSize(300, 400);
		setLocationRelativeTo(padre);

		JComboBox<Provincia> cbProvincia = new JComboBox<>(Provincia.crearListaProvincias());
		JButton btnConfirmar = new JButton("Confirmar");
		JButton btnCancelar = new JButton("Cancelar");
		JLabel lblError = new JLabel("");
		lblError.setForeground(Color.RED);
		
		add(cbProvincia, "wrap");
		add(btnConfirmar, "wrap");
		add(btnCancelar, "wrap");
		add(lblError);

		btnCancelar.addActionListener((e) -> {
			dispose();
		});

		btnConfirmar.addActionListener((e) -> {
			String msgError = controlador.crearSede((Provincia) cbProvincia.getSelectedItem());
			if (msgError == null) {
				dispose();	
			}
			else {
				lblError.setText(msgError);
			}
			
		});

	}

}
