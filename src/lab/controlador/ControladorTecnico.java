package lab.controlador;

import java.util.List;

import lab.excepciones.EmpleadoIncompatible;
import lab.excepciones.EmpleadoNoEncontrado;
import lab.excepciones.LaboratorioNoEncontrado;
import lab.excepciones.PruebaLoteNoEncontrado;
import lab.excepciones.SedeNoEncontrada;
import lab.modelo.EstrategiaVencimiento;
import lab.modelo.FechaTurno;
import lab.modelo.PruebaLote;
import lab.modelo.enums.EstadoLote;

public class ControladorTecnico extends Controlador{

	
	private static ControladorTecnico instance;
	
	private ControladorTecnico() {
		
	}
	
	public static synchronized ControladorTecnico getInstance() {
		if(instance == null)
			instance = new ControladorTecnico();
		
		return instance;
	}
	
	
	public void reservarPrueba(int idProdQuimico,int cantidadAuxiliares,int idEmpleadoResponsable, FechaTurno fechaTurno, int idSede, int idLaboratorio) {
		
	}
	
	public void incribirseAPrueba(int idLaboratorio, int idPrueba) throws SedeNoEncontrada, EmpleadoNoEncontrado, PruebaLoteNoEncontrado, EmpleadoIncompatible, LaboratorioNoEncontrado {
		empresaInstance.registrarEmpleadoPrueba(usuario.getId(), idPrueba, idLaboratorio);
	}
	
	public void finalizarPrueba(int idSede, int idLaboratorio, int idLote, EstadoLote estado, EstrategiaVencimiento estrategia ) throws SedeNoEncontrada, PruebaLoteNoEncontrado, LaboratorioNoEncontrado {
		empresaInstance.finalizarPrueba(idSede, idLaboratorio, idLote, estado, estrategia);
		
	}
	
	public void listarMisPruebas() {
		List<PruebaLote> lista = empresaInstance.listarPruebaPorEmpleadoResponsable(usuario.getId());
	}

	@Override
	public void mostrarBienvenida() {
		// TODO Auto-generated method stub
		
	}
}
