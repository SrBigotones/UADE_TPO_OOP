package lab.controlador;

import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JPanel;

import lab.excepciones.SedeNoEncontrada;
import lab.vista.Menu;
import lab.vista.paneles.BotoneraAdministrativo;
import lab.vista.paneles.CrearEmpleadoGerente;
import lab.vista.paneles.CrearEmpleadoTecnico;
import lab.vista.paneles.CrearLaboratorio;
import lab.vista.paneles.VerEmpleadosSede;
import lab.vista.view.EmpleadoView;
import lab.vista.view.PeligrosViewCheck;
import lab.vista.view.PerfilTecnicoView;
import lab.vista.view.SedeView;

public class ControladorAdministrativo extends Controlador {
	private static ControladorAdministrativo instance;

	private ControladorAdministrativo() {
	}

	public static synchronized ControladorAdministrativo getInstance() {
		if (instance == null)
			instance = new ControladorAdministrativo();

		return instance;
	}

	public void darAltaTecnico(String nombre, String username, int idPerfilTecnico) {
		empresaInstance.crearEmpleadoTecnico(nombre, username, idPerfilTecnico, usuario.getIdSedePertenece());
		System.out.println(empresaInstance.getEmpleados());
	}

	public void darAltaGerente(String nombre, String username) {
		empresaInstance.crearEmpleadoGerente(nombre, username, usuario.getIdSedePertenece());
	}

	public void darAltaLaboratorio(int capacidadPersonas, List<Integer> idPeligros) throws SedeNoEncontrada {
		empresaInstance.crearLaboratorio(capacidadPersonas, idPeligros, usuario.getIdSedePertenece());
	}

	public void asginarPerfilTecnico(int idPerfilTecnico, int idEmpleadoTecnico) throws Exception {
		empresaInstance.asociarPerfilEmpleado(idPerfilTecnico, idEmpleadoTecnico);
	}

	@Override
	public void mostrarBienvenida() {
		jfMenu = new Menu(new BotoneraAdministrativo(), new JPanel());
	}

	public void mostrarAltaTecnico() {
		cambiarPanel(new CrearEmpleadoTecnico());
	}

	public void mostrarAltaGerente() {
		cambiarPanel(new CrearEmpleadoGerente());
	}

	public void mostrarAltaLaboratorio() {
		cambiarPanel(new CrearLaboratorio());
	}

	public List<PerfilTecnicoView> listarPerfilesTecnicos() {
		List<PerfilTecnicoView> perfilesTecnicos = empresaInstance.getPerfiles().stream()
				.map(perfil -> new PerfilTecnicoView(perfil)).collect(Collectors.toList());

		return perfilesTecnicos;
	}

	public List<SedeView> listarSedes() {
		List<SedeView> sedes = empresaInstance.getSedes().stream().map(x -> new SedeView(x))
				.collect(Collectors.toList());
		return sedes;
	}

	public List<PeligrosViewCheck> listarPeligros() {
		List<PeligrosViewCheck> lista = empresaInstance.getTiposPeligro().stream().map(x -> new PeligrosViewCheck(x))
				.collect(Collectors.toList());
		return lista;
	}

	public void mostrarEmpleados() {
		int idSede = usuario.getIdSedePertenece();
		List<EmpleadoView> empleadosSede = empresaInstance.getEmpleados().stream()
				.filter((e) -> e.getIdSedePertenece() == idSede && (e.soyTecnico() || e.soyGerente()))
				.map(e -> new EmpleadoView(e)).collect(Collectors.toList());
		cambiarPanel(new VerEmpleadosSede(empleadosSede));

	}
}
