package lab.controlador;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.swing.JPanel;

import lab.excepciones.EmpleadoIncompatible;
import lab.excepciones.EmpleadoNoEncontrado;
import lab.excepciones.LaboratorioNoDisponible;
import lab.excepciones.LaboratorioNoEncontrado;
import lab.excepciones.ProductoQuimicoNoEncontrado;
import lab.excepciones.PruebaLoteNoEncontrado;
import lab.excepciones.SedeNoEncontrada;
import lab.modelo.ElementoQuimico;
import lab.modelo.Empresa;
import lab.modelo.EstrategiaVencimiento;
import lab.modelo.FechaTurno;
import lab.modelo.PruebaLote;
import lab.modelo.TipoPeligro;
import lab.modelo.enums.EstadoLote;
import lab.modelo.enums.TipoProducto;
import lab.vista.Menu;
import lab.vista.paneles.ActualizarEstadoPruebaTecnico;
import lab.vista.paneles.BotoneraTecnico;
import lab.vista.paneles.ListadoProductosQuimicos;
import lab.vista.paneles.ReservarLaboratorio;
import lab.vista.view.LaboratorioView;
import lab.vista.view.PeligrosViewCheck;
import lab.vista.view.ProductoQuimicoView;
import lab.vista.view.PruebaLoteView;

public class ControladorTecnico extends Controlador{

	
	private static ControladorTecnico instance;
	
	private ControladorTecnico() {
		
	}
	
	public static synchronized ControladorTecnico getInstance() {
		if(instance == null)
			instance = new ControladorTecnico();
		
		return instance;
	}
	
	
	/**
	 * 
	 * @param idProdQuimico
	 * @param cantidadAuxiliares
	 * @param fechaTurno
	 * @param idLaboratorio
	 * @throws EmpleadoIncompatible 
	 * @throws EmpleadoNoEncontrado 
	 * @throws ProductoQuimicoNoEncontrado 
	 * @throws LaboratorioNoDisponible 
	 * @throws LaboratorioNoEncontrado 
	 */
	public void reservarPrueba(int idProdQuimico,int cantidadAuxiliares, FechaTurno fechaTurno, int idLaboratorio) throws LaboratorioNoEncontrado, LaboratorioNoDisponible, ProductoQuimicoNoEncontrado, EmpleadoNoEncontrado, EmpleadoIncompatible {
		empresaInstance.reservar(idProdQuimico, cantidadAuxiliares, usuario.getId(), fechaTurno, idLaboratorio);
	}
	
	public void incribirseAPrueba(int idLaboratorio, int idPrueba) throws SedeNoEncontrada, EmpleadoNoEncontrado, PruebaLoteNoEncontrado, EmpleadoIncompatible, LaboratorioNoEncontrado {
		empresaInstance.registrarEmpleadoPrueba(usuario.getId(), idPrueba, idLaboratorio);
	}
	
	public void actualizarPrueba(int idLaboratorio, int idLote, EstadoLote estado, EstrategiaVencimiento estrategia ) throws SedeNoEncontrada, PruebaLoteNoEncontrado, LaboratorioNoEncontrado {
		System.out.println(idLaboratorio);
		empresaInstance.finalizarPrueba(usuario.getIdSedePertenece(), idLaboratorio, idLote, estado, estrategia);
		
		
	}
	
	public void crearProductoQuimico(Map<ElementoQuimico, Integer> conjutoQuimico, String nombre, TipoProducto tipoProducto, List<Integer> peligros) {
		empresaInstance.crearProductoQuimico(conjutoQuimico, nombre, tipoProducto, peligros);
	}
	
	public List<PruebaLoteView> listarPruebasEnLaboratorio(int idLaboratorio) throws LaboratorioNoEncontrado, SedeNoEncontrada {
		List<PruebaLoteView> lista = empresaInstance.listarPruebaPorLaboratorio(usuario.getIdSedePertenece(), idLaboratorio)
				.stream()
				.map(x -> new PruebaLoteView(x))
				.collect(Collectors.toList());
		
		System.out.println(lista);
		return lista;
	}
	
	
	public List<LaboratorioView> listarLaboratorios() throws SedeNoEncontrada{
		List<LaboratorioView> lab = empresaInstance.listarLaboratoriosPorSede(usuario.getIdSedePertenece())
				.stream()
				.map(x -> new LaboratorioView(x))
				.collect(Collectors.toList());
		
		return lab;
	}

	@Override
	public void mostrarBienvenida() {
		// TODO Auto-generated method stub
		jfMenu = new Menu(new BotoneraTecnico(), new JPanel());
		
	}
	
	
	public void mostrarReservarPrueba() throws SedeNoEncontrada {
		cambiarPanel(new ReservarLaboratorio());
	}
	
	public void mostrarInscribirseAPrueba() {}
	
	public void mostrarActualizarEstadoPrueba() throws SedeNoEncontrada, LaboratorioNoEncontrado {
		cambiarPanel(new ActualizarEstadoPruebaTecnico());
	}
	public void mostrarPantallaProductosQuimicos() {
		List<ProductoQuimicoView> productos = Empresa.getInstance().getProductosQuimicos().stream().map((pq) -> new ProductoQuimicoView(pq)).collect(Collectors.toList());
		cambiarPanel(new ListadoProductosQuimicos(productos));
	}
	
	public List<ElementoQuimico> listarElementosQuimicos() {
		return null;
	}
	
	public List<ProductoQuimicoView> listarProductosQuimicos(){
		List<ProductoQuimicoView> lista = empresaInstance.getProductosQuimicos()
				.stream()
				.map(x -> new ProductoQuimicoView(x))
				.collect(Collectors.toList());
		return lista;
	}
	public List<PeligrosViewCheck> listarPeligros(){
		List<PeligrosViewCheck> lista = empresaInstance.getTiposPeligro()
				.stream()
				.map(x -> new PeligrosViewCheck(x))
				.collect(Collectors.toList());
		return lista;
	} 
}
