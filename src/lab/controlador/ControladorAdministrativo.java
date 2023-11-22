package lab.controlador;

import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import lab.excepciones.SedeNoEncontrada;
import lab.vista.Menu;
import lab.vista.paneles.BotoneraAdministrativo;
import lab.vista.paneles.BotoneraSoporte;
import lab.vista.paneles.CrearEmpleadoGerente;
import lab.vista.paneles.CrearEmpleadoTecnico;
import lab.vista.tablas.ModeloPerfilTecnico;
import lab.vista.view.PerfilTecnicoView;
import lab.vista.view.SedeView;

public class ControladorAdministrativo extends Controlador{
	private static ControladorAdministrativo instance;
	
	private ControladorAdministrativo() {}
	
	public static synchronized ControladorAdministrativo getInstance() {
		if(instance  == null)
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
	
	public void darAltaLaboratorio(int capacidadPersonas, int idSede, List<Integer> idPeligros) throws SedeNoEncontrada {
		empresaInstance.crearLaboratorio(capacidadPersonas, idPeligros, idSede);
	}
	
	public void asginarPerfilTecnico(int idPerfilTecnico, int idEmpleadoTecnico) throws Exception {
		empresaInstance.asociarPerfilEmpleado(idPerfilTecnico, idEmpleadoTecnico);
	}

	
	
	@Override
	public void mostrarBienvenida() {
		// TODO Auto-generated method stub
		jfMenu = new Menu(new BotoneraAdministrativo(), new JPanel());
	}
	
	public void mostrarAltaTecnico() {
		cambiarPanel(new CrearEmpleadoTecnico());
	}
	public void mostrarAltaGerente() {
		cambiarPanel(new CrearEmpleadoGerente());
	}
	public void mostrarAltaLaboratorio() {}
	public void mostrarAsignarPerfilTecnico() {}
	
	public List<PerfilTecnicoView> listarPerfilesTecnicos() {
		List<PerfilTecnicoView> perfilesTecnicos = empresaInstance.getPerfiles().stream()
				.map(perfil -> new PerfilTecnicoView(perfil))
				.collect(Collectors.toList());
		
		return perfilesTecnicos;
	}
	
	public List<SedeView> listarSedes(){
		List<SedeView> sedes = empresaInstance.getSedes()
				.stream()
				.map(x -> new SedeView(x))
				.collect(Collectors.toList());
		return sedes;
	}
}
