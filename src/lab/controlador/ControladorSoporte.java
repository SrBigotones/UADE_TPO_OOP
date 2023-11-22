package lab.controlador;

import java.awt.BorderLayout;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import lab.modelo.Empresa;
import lab.modelo.Sede;
import lab.modelo.enums.Provincia;
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

	public String crearSede(Provincia prov) {
		boolean provinciaYaUsada = Empresa.getInstance().getSedes().stream().anyMatch((s) -> s.getProvincia().equals(prov));
		if (provinciaYaUsada) {
			return "Ya existe una sede en esa provincia"; 
		}
		Empresa.getInstance().crearSede(prov);
		return null;
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
		panelBienvenida.add(new JLabel("¡Bienvenido a Soporte!", SwingConstants.CENTER));
		jfMenu = new Menu(new BotoneraSoporte(), panelBienvenida);
	}
}
