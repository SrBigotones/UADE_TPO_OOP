package lab.controlador;

import java.awt.BorderLayout;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import lab.modelo.Empresa;
import lab.modelo.enums.Provincia;
import lab.vista.Menu;
import lab.vista.paneles.BotoneraSoporte;
import lab.vista.paneles.ListadoAdministrativos;
import lab.vista.paneles.ListadoPerfilesTecnicos;
import lab.vista.paneles.ListadoSedes;
import lab.vista.view.EmpleadoView;
import lab.vista.view.PerfilTecnicoView;
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

	public List<SedeView> listarSedes() {
		return empresaInstance.getSedes().stream().map((s) -> new SedeView(s)).collect(Collectors.toList());
	}

	public String crearSede(Provincia prov) {
		boolean provinciaYaUsada = Empresa.getInstance().getSedes().stream()
				.anyMatch((s) -> s.getProvincia().equals(prov));
		if (provinciaYaUsada) {
			return "Ya existe una sede en esa provincia";
		}
		Empresa.getInstance().crearSede(prov);
		return null;
	}

	public String crearEmpleadoAdministrativo(String nombre, String username, int idSede) {
		if (username.equals("") || nombre.equals("")) {
			return "Faltan datos";
		}
		if (Empresa.getInstance().getEmpleados().stream().anyMatch((e) -> e.getUsername().equals(username))) {
			return "El username ya está registrado";
		}
		Empresa.getInstance().crearEmpleadoAdministrativo(nombre, username, idSede);
		return null;
	}

	public void crearPerfilTecnico(String nombre, double sueldo, int maxReservas) {
		empresaInstance.crearPerfil(nombre, sueldo, maxReservas);
	}

	public void modificarPerfilTecnico() {
	}

	public void mostrarPantallaSedes() {
		cambiarPanel(new ListadoSedes(listarSedes()));
	}

	public void mostrarPantallaPerfilesTecnicos() {
		List<PerfilTecnicoView> perfiles = empresaInstance.getPerfiles().stream().map((p) -> new PerfilTecnicoView(p))
				.collect(Collectors.toList());
		cambiarPanel(new ListadoPerfilesTecnicos(perfiles));
	}

	public void mostrarPantallaAdministrativos() {
		List<EmpleadoView> administrativos = empresaInstance.getEmpleados().stream()
				.filter((e) -> e.soyAdministrativo()).map(e -> new EmpleadoView(e)).collect(Collectors.toList());
		cambiarPanel(new ListadoAdministrativos(administrativos));
	}

	@Override
	public void mostrarBienvenida() {
		JPanel panelBienvenida = new JPanel(new MigLayout("", "[]", ""));
		panelBienvenida.setLayout(new BorderLayout());
		panelBienvenida.add(new JLabel("¡Bienvenido a Soporte!", SwingConstants.CENTER));
		jfMenu = new Menu(new BotoneraSoporte(), panelBienvenida);
	}
}
