package lab.vista.dialog;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import lab.controlador.ControladorTecnico;
import lab.modelo.ElementoQuimico;
import lab.modelo.enums.TipoProducto;
import lab.vista.tablas.ModeloPeligrosSeleccion;
import net.miginfocom.swing.MigLayout;

public class DialogCrearProductoQuimico extends JDialog {
	ControladorTecnico controlador;

	public DialogCrearProductoQuimico(JFrame padre) {

		super(padre, JDialog.DEFAULT_MODALITY_TYPE);
		setLayout(new MigLayout("fill", "[fill, grow][fill, grow]", ""));
		setSize(400, 500);
		setLocationRelativeTo(padre);
		controlador = ControladorTecnico.getInstance();

		ModeloPeligrosSeleccion modeloPeligros = new ModeloPeligrosSeleccion(controlador.listarPeligros());

		JTextField tfNombre = new JTextField();
		Map<ElementoQuimico, JTextField> mapElemTf = createTfElems();
		JComboBox<TipoProducto> cbTipoProducto = new JComboBox<TipoProducto>(TipoProducto.values());
		JButton btnCrearPerfil = new JButton("Confirmar");
		JButton btnCancelar = new JButton("Cancelar");
		JScrollPane scrollPanePeligros = new JScrollPane(new JTable(modeloPeligros));

		add(new JLabel("Nombre comercial:"));
		add(tfNombre, "wrap");

		add(new JLabel("Elementos químicos", SwingConstants.CENTER), "wrap, grow, span 2");
		// Se agregan tf de elementos quimicos dinamicamente
		for (Map.Entry<ElementoQuimico, JTextField> entry : mapElemTf.entrySet()) {
			add(new JLabel(entry.getKey().getNombre() + " (" + entry.getKey().getSimbolo() + "): "));
			add(entry.getValue(), "wrap");
		}

		add(new JLabel("Tipo de producto:"));
		add(cbTipoProducto, "wrap");
		add(new JLabel("Tipos de peligro:"));
		add(scrollPanePeligros, "wrap");
		add(btnCrearPerfil, "wrap, span 2");
		add(btnCancelar, "wrap, span 2");

		btnCrearPerfil.addActionListener(e -> {
			Map<ElementoQuimico, Integer> mapElemCant = extraerElementosYCantidades(mapElemTf);

			List<Integer> listaIdsPeligros = extraerIdsPeligros(modeloPeligros);

			controlador.crearProductoQuimico(mapElemCant, tfNombre.getText(),
					(TipoProducto) cbTipoProducto.getSelectedItem(), listaIdsPeligros);
			JOptionPane.showMessageDialog(null, "¡Producto químico creado con exito!");
			dispose();
		});

		btnCancelar.addActionListener((e) -> {
			dispose();
		});
	}

	private List<Integer> extraerIdsPeligros(ModeloPeligrosSeleccion modeloPeligros) {
		return modeloPeligros.getDatos().stream().filter((p) -> p.isCheck()).map((p) -> p.getIdPeligro())
				.collect(Collectors.toList());
	}

	private Map<ElementoQuimico, Integer> extraerElementosYCantidades(Map<ElementoQuimico, JTextField> mapElemTf) {
		Map<ElementoQuimico, Integer> mapElemCant = new HashMap<>();
		for (Map.Entry<ElementoQuimico, JTextField> entry : mapElemTf.entrySet()) {
			mapElemCant.put(entry.getKey(), Integer.valueOf(entry.getValue().getText()));
		}

		return mapElemCant;
	}

	private Map<ElementoQuimico, JTextField> createTfElems() {
		Map<ElementoQuimico, JTextField> tfElemMap = new HashMap<>();
		for (ElementoQuimico elem : ElementoQuimico.values()) {
			JTextField tfElem = new JTextField();
			tfElem.setText("0");
			tfElemMap.put(elem, tfElem);
		}
		return tfElemMap;
	}
}
