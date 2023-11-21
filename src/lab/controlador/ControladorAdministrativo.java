package lab.controlador;

import java.util.List;

import lab.excepciones.SedeNoEncontrada;

public class ControladorAdministrativo extends Controlador{
	private static ControladorAdministrativo instance;
	
	private ControladorAdministrativo() {}
	
	public static synchronized ControladorAdministrativo getInstance() {
		if(instance  == null)
			instance = new ControladorAdministrativo();
		
		return instance;
	}
	
	
	public void darAltaTecnico(String nombre, String username, int idPerfilTecnico) {
		empresaInstance.crearEmpleadoTecnico(nombre, username, idPerfilTecnico);
	}
	public void darAltaGerente(String nombre, String username) {
		empresaInstance.crearEmpleadoGerente(nombre, username);
	}
	
	public void darAltaLaboratorio(int capacidadPersonas, int idSede, List<Integer> idPeligros) throws SedeNoEncontrada {
		empresaInstance.crearLaboratorio(capacidadPersonas, idPeligros, idSede);
	}
	
	public void asginarPerfilTecnico(int idPerfilTecnico, int idEmpleadoTecnico) throws Exception {
		empresaInstance.asociarPerfilEmpleado(idPerfilTecnico, idEmpleadoTecnico);
	}
}
