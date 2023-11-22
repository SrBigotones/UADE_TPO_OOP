package lab.vista.dialog;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import lab.controlador.ControladorSoporte;
import lab.modelo.enums.Provincia;
import net.miginfocom.swing.MigLayout;

public class DialogCrearSede extends JDialog {

	private ControladorSoporte controlador;
	
	public DialogCrearSede(JFrame padre) {
		super(padre, JDialog.DEFAULT_MODALITY_TYPE);
		setLayout(new MigLayout("", "[fill, grow][fill, grow]", ""));
		setSize(300, 200);
		setLocationRelativeTo(padre);
		controlador = ControladorSoporte.getInstance();
		
		JComboBox<Provincia> cbProvincia = new JComboBox<>(Provincia.crearListaProvincias());
		JButton btnConfirmar = new JButton("Confirmar");
		JButton btnCancelar = new JButton("Cancelar");
		JLabel lblError = new JLabel("");
		lblError.setForeground(Color.RED);
		
		add(new JLabel("Provincia"));
		add(cbProvincia, "wrap");
		add(btnConfirmar, "wrap, span 2");
		add(btnCancelar, "wrap, span 2");
		add(lblError, "span 2");

		btnCancelar.addActionListener((e) -> {
			dispose();
		});

		btnConfirmar.addActionListener((e) -> {
			String msgError = controlador.crearSede((Provincia) cbProvincia.getSelectedItem());
			if (msgError == null) {
				JOptionPane.showMessageDialog(null, "¡Sede creada con exito!");
				dispose();
			}
			else {
				lblError.setText(msgError);
			}
		});

	}

}
