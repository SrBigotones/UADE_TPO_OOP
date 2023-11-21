package lab.controlador;

import java.awt.BorderLayout;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JLabel;
import javax.swing.JPanel;

import lab.vista.Menu;
import lab.vista.paneles.BotoneraSoporte;
import lab.vista.paneles.ListadoSedes;
import lab.vista.view.SedeView;
import net.miginfocom.swing.MigLayout;

public class ControladorSoporte extends Controlador {
	private static ControladorSoporte instance;

	ControladorSoporte() {
	}

	public static synchronized ControladorSoporte getInstance() {
		if (instance == null) {
			instance = new ControladorSoporte();
		}
		return instance;
	}

	public void darAltaAdministrativo() {
	}

	public void crearSede() {
	}

	public void crearPerfilTecnico(String nombre, double sueldo, int maxReservas) {
		empresaInstance.crearPerfil(nombre, sueldo, maxReservas);
	}

	public void modificarPerfilTecnico() {
	}

	// Esto pertenece en otro controlador -- TESTING
	public void mostrarPantallaSedes() {
		List<SedeView> sedesView = empresaInstance.getSedes().stream().map((s) -> new SedeView(s))
				.collect(Collectors.toList());
		cambiarPanel(new ListadoSedes(sedesView));
	}

	@Override
	public void mostrarBienvenida() {
		JPanel panelBienvenida = new JPanel(new MigLayout("", "[]", ""));
		panelBienvenida.setLayout(new BorderLayout());
		panelBienvenida.add(new JLabel("¡Bienvenido a Soporte!"));
		jfMenu = new Menu(new BotoneraSoporte(), panelBienvenida);
	}
}
