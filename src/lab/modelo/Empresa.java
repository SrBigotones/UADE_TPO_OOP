package lab.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import lab.excepciones.EmpleadoIncompatible;
import lab.excepciones.EmpleadoNoEncontrado;
import lab.excepciones.LaboratorioNoDisponible;
import lab.excepciones.LaboratorioNoEncontrado;
import lab.excepciones.PerfilTenicoNoEncontrado;
import lab.excepciones.ProductoQuimicoNoEncontrado;
import lab.excepciones.PruebaLoteNoEncontrado;
import lab.excepciones.SedeNoEncontrada;
import lab.excepciones.TipoPeligroNoEncontrado;
import lab.modelo.empleado.Empleado;
import lab.modelo.empleado.EmpleadoAdministrativo;
import lab.modelo.empleado.EmpleadoGerente;
import lab.modelo.empleado.EmpleadoSoporte;
import lab.modelo.empleado.EmpleadoTecnico;
import lab.modelo.enums.EstadoLote;
import lab.modelo.enums.Provincia;
import lab.modelo.enums.TipoProducto;
//import lab.modelo.enums.TipoProducto;
import lab.util.Utilidades;

public class Empresa {
	private static int CANT_SEDE_PROVINCIA = 1;
	
	private List<Sede> sedes;
	private List<ProductoQuimico> productosQuimicos;
	private List<Empleado> empleados;
	private List<TipoPeligro> tiposPeligro;
	private List<PerfilTecnico> perfiles;
	private List<TipoProducto> tiposProducto;
	
	private static Empresa empresa;
	
	private Empresa() {
		sedes = new ArrayList<>();
		productosQuimicos = new ArrayList<>();
		empleados = new ArrayList<>();
		tiposPeligro = new ArrayList<>();
		perfiles = new ArrayList<>();
	}
	
	public static synchronized Empresa getInstance() {
		if(empresa == null) {
			empresa = new Empresa();
		}
		return empresa;
	}
	
	/*
	 ****************************METODOS DE BUSQUEDA PARA USO INTERNO***************************
	 */
	
	/**
	 * Busca la existencia de un empleado con determinado id
	 * @param idEmpleado
	 * @return Empleado
	 * @throws EmpleadoNoEncontrado 
	 */
	private Empleado buscarEmpleado(int idEmpleado) throws EmpleadoNoEncontrado {
		
		Empleado empleado = Utilidades.buscarEnListaPorId(idEmpleado, empleados);
		if(empleado != null) {
			return empleado;
		}
		
		throw new EmpleadoNoEncontrado();
	}
	
	private Sede buscarSede(int idSede) throws SedeNoEncontrada {
		
		Sede sede = Utilidades.buscarEnListaPorId(idSede, sedes);
		if(sede != null) {
			return sede;
		}
		throw new SedeNoEncontrada();
	}
	
	private ProductoQuimico buscarProductoQuimico(int idProductoQuimico) throws ProductoQuimicoNoEncontrado {
		ProductoQuimico productoQuimico = Utilidades.buscarEnListaPorId(idProductoQuimico, productosQuimicos);
		if(productoQuimico != null)
			return productoQuimico;
	
		throw new ProductoQuimicoNoEncontrado();
	}
	
	private PerfilTecnico buscarPerfilTecnico(int idPerfilTecnico) throws PerfilTenicoNoEncontrado {
		
		
		PerfilTecnico perfil = Utilidades.buscarEnListaPorId(idPerfilTecnico, perfiles);
		if(perfil != null)
			return perfil;
		
		throw new PerfilTenicoNoEncontrado();
	}
	
	
	/**
	 * Busca tipoPeligro y retorna el mismo.
	 * @param idTipoPeligro
	 * @return
	 * @throws TipoPeligroNoEncontrado
	 */
	private TipoPeligro buscarTipoPeligro(int idTipoPeligro) throws TipoPeligroNoEncontrado {
		
		
		TipoPeligro tipoPeligro = Utilidades.buscarEnListaPorId(idTipoPeligro, tiposPeligro);
		if(tipoPeligro != null)
			return tipoPeligro;
		
		throw new TipoPeligroNoEncontrado();
	}
	
	/**
	 * Busca cuantas sedes existen en una determina provincia
	 * @param provincia
	 * @return el numero de sedes en la provincia
	 */
	private int sedePorProvincia(Provincia provincia) {
		int count = 0;
		for(Sede sede: sedes) {
			if(sede.getProvincia() == provincia) {
				count++;
			}
		}
		return count;
	}
	
	/*
	 *************************** METODOS PARA EMPLEADO SOPORTE***************************
	 */
	
	/**
	 * Asociar a un empleado tecnico un perfil tecnico
	 * @param idPerfil
	 * @param idEmpleado
	 * @throws Exception 
	 */
	public void asociarPerfilEmpleado(int idPerfil, int idEmpleado) throws Exception{
		Empleado empleado = this.buscarEmpleado(idEmpleado);
		if(empleado.soyTecnico()) {
			PerfilTecnico perfilTecnio = this.buscarPerfilTecnico(idPerfil);
			EmpleadoTecnico empleadoTecnico = (EmpleadoTecnico) empleado;
			empleadoTecnico.setPerfil(perfilTecnio);
		}else {
			throw new Exception("Empleado no cumple condicion");
		}
		
		
		
		
	}// /'id de perfil, id de empleado'/
	
	/**
	 * Crea un nuevo empleado
	 * @param nombre del empleado
	 * @return Empleado creado
	 */
	public EmpleadoTecnico crearEmpleadoTecnico(String nombre, String username, int idPerfil, int idSedePertenece) {
		PerfilTecnico perfil = Utilidades.buscarEnListaPorId(idPerfil, perfiles);
		EmpleadoTecnico empleado = new EmpleadoTecnico(nombre, username, perfil, idSedePertenece);
		empleados.add(empleado);
		return empleado;
	}
	
	public EmpleadoAdministrativo crearEmpleadoAdministrativo(String nombre, String username, int idSedePertenece) {
		EmpleadoAdministrativo empleado = new EmpleadoAdministrativo(nombre, username, idSedePertenece);
		empleados.add(empleado);
		return empleado;
	}
	
	public EmpleadoSoporte crearEmpleadoSoporte(String nombre, String username) {
		EmpleadoSoporte empleado = new EmpleadoSoporte(nombre, username);
		empleados.add(empleado);
		return empleado;
	}
	
	public EmpleadoGerente crearEmpleadoGerente(String nombre, String username, int idSedePertence) {
		EmpleadoGerente empleado = new EmpleadoGerente(nombre, username, idSedePertence);
		empleados.add(empleado);
		return empleado;
	}
	 
	/**
	 * Crear un nuevo perfil tecnico
	 * @param nombre
	 * @param sueldo
	 * @param maxReservas
	 * @return PerfilTecnico creado
	 */
	public PerfilTecnico crearPerfil(String nombre, double sueldo, int maxReservas) { ///'nombrePuesto, sueldo, maxReservas'/
		if(sueldo >= 0) {
			if(maxReservas >= 0) {
				PerfilTecnico perfilTecnico = new PerfilTecnico(nombre, sueldo, maxReservas);
				perfiles.add(perfilTecnico);
				return perfilTecnico;
			}
		}
		
		return null;
	}
	
	
	/**
	 * Modificar perfil tecnico dado un id 
	 * @param idPuesto1
	 * @param sueldo
	 * @param maxReservas
	 * @return PerfilTecnico modificado
	 * @throws PerfilTenicoNoEncontrado 
	 */
	public PerfilTecnico modificarPerfil(int idPerfil, double sueldo, int maxReservas) throws PerfilTenicoNoEncontrado {// /'idPuesto, sueldo, maxReservas'/
		PerfilTecnico perfil = this.buscarPerfilTecnico(idPerfil);
		perfil.setSueldo(sueldo);
		perfil.setMaxReservas(maxReservas);
		return perfil;
	}
	 
	/**
	 * Crea un nuevo tipo de peligro
	 * @param nombre
	 * @param costo
	 * @return 
	 */
	public TipoPeligro crearTipoPeligro(String nombre, double costo, int diasVencimiento) {
		TipoPeligro tipoPeligro = new TipoPeligro(nombre, costo, diasVencimiento);
		this.tiposPeligro.add(tipoPeligro);
		return tipoPeligro;
	}
	
	
	 
	/**
	 * Modifica peligro quimico existente
	 * @param idPeligro
	 * @param costo
	 * @return TipoPeligro modificado
	 */
	public TipoPeligro modificarTipoPeligro(int idPeligro, double costo){
		TipoPeligro tipoPeligro = Utilidades.buscarEnListaPorId(idPeligro, tiposPeligro);
		tipoPeligro.setCosto(costo);
		return tipoPeligro;
	}
	
	/**
	 * Crear un nuevo laboratorio en una sede
	 * 
	 * @param capacidadPersonas
	 * @param hashSet
	 * @return Laboratorio creado
	 * @throws SedeNoEncontrada
	 */
	public Laboratorio crearLaboratorio(int capacidadPersonas, List<Integer> idPeligros, int idSede)
			throws SedeNoEncontrada {
		Sede sede = this.buscarSede(idSede);
		
		Laboratorio lab = sede.agregarLaboratorio(capacidadPersonas, mapIdsToTipoPeligro(idPeligros));
		return lab;
	}

	/**
	 * Modificar un laboratorio
	 * @param capacidadPersonas
	 * @param tipoPeligros
	 * @return Laboratorio modificado
	 * @throws SedeNoEncontrada 
	 * @throws LaboratorioNoEncontrado 
	 */
	public Laboratorio modificarLaboratorio(int idLaboratorio, int idSede, int capacidadPersonas, Set<TipoPeligro> tipoPeligros) throws SedeNoEncontrada, LaboratorioNoEncontrado{// /'capacidadPersonas'/
		Sede sede = this.buscarSede(idSede);
		Laboratorio lab = sede.buscarLaboratorio(idLaboratorio);
		
		lab.establecerPeligrosPermitidos(tipoPeligros);
		lab.setCapacidadPersonas(capacidadPersonas);
		
		return lab;
	}
	
	/**
	 * Crea una sede en la provincia determinada
	 * @param provincia
	 * @return Sede creada
	 */
	public Sede crearSede(Provincia provincia) {
		Sede sede = new Sede(provincia);
		this.sedes.add(sede);
		return sede;
	}
	
//	public void asignarAdministrativoASede(int idSede, int idEmpleadoAdministrativo) throws EmpleadoNoEncontrado, SedeNoEncontrada, EmpleadoIncompatible {
//		Sede sede = buscarSede(idSede);
//		Empleado empleado = buscarEmpleado(idEmpleadoAdministrativo);
//		if(empleado.soyGerente()) {
//			sede.asignarEmpleadoGerente((EmpleadoGerente)empleado);
//		}else {
//			throw new EmpleadoIncompatible(empleado);
//		}	
//		
//	}
	//ESTO NO VA!!!!!!!!!
//	/**
//	 * Crea un nuevo tipo de producto
//	 * @param nombre
//	 * @param diasVencimiento
//	 * @return 
//	 */
//	public TipoProducto crearTiposProducto(String nombre, int diasVencimiento) {
//		TipoProducto tipoProducto = new TipoProducto(nombre, diasVencimiento);
//		this.tiposProducto.add(tipoProducto);
//		return tipoProducto;
//	}
	
//	/**
//	 * Modifica tipo de producto existente
//	 * @param idProducto
//	 * @param diasVencimiento
//	 * @return TipoProducto modificado
//	 */
//	public TipoProducto modificarTiposProducto(int idProducto, int diasVencimiento){
//		TipoProducto tipoProducto = Utilidades.buscarEnListaPorId(idProducto, tiposProducto);
//		tipoProducto.setDiasVencimiento(diasVencimiento);
//		return tipoProducto;
//	}
	
	 
	 /*
	  * ***************************METODOS EMPLEADO TECNICO***************************
	  */
/**
 * 
 * @param idProdQuimico
 * @param cantidadAuxiliares
 * @param idEmpleadoResponsable
 * @param fechaTurno
 * @param idLaboratorio
 * @return
 * @throws LaboratorioNoEncontrado
 * @throws LaboratorioNoDisponible
 * @throws ProductoQuimicoNoEncontrado
 * @throws EmpleadoNoEncontrado
 * @throws EmpleadoIncompatible
 */
	public PruebaLote reservar(int idProdQuimico,int cantidadAuxiliares,int idEmpleadoResponsable, FechaTurno fechaTurno, int idLaboratorio) throws LaboratorioNoEncontrado, LaboratorioNoDisponible, ProductoQuimicoNoEncontrado, EmpleadoNoEncontrado, EmpleadoIncompatible {
		Empleado emp = this.buscarEmpleado(idEmpleadoResponsable);
		Sede sede = Utilidades.buscarEnListaPorId(emp.getIdSedePertenece(), sedes);
		ProductoQuimico prodQuimico = this.buscarProductoQuimico(idProdQuimico);
		if(emp.soyTecnico()) {
			return sede.reservarPrueba(idLaboratorio, prodQuimico,cantidadAuxiliares, (EmpleadoTecnico) emp, fechaTurno);		
		}else {
			throw new EmpleadoIncompatible(emp);
		}
	}
	
	
	/**
	 * Diagnosticar resultado de prueba
	 * @param idLote
	 * @param aprobacion
	 * @throws SedeNoEncontrada 
	 * @throws LaboratorioNoEncontrado 
	 * @throws PruebaLoteNoEncontrado 
	 */
	public void finalizarPrueba(int idSede, int idLaboratorio,int idLote, EstadoLote estado, EstrategiaVencimiento estrategiaVencimiento) throws SedeNoEncontrada, PruebaLoteNoEncontrado, LaboratorioNoEncontrado { //'idLote, aprobacion'/
		 Sede sede = this.buscarSede(idSede);
		 sede.finalizarPrueba(idLaboratorio, idLote, estado, estrategiaVencimiento);
	}
	 
	/**
	 * Crear nuevo producto quimico
	 * @param conjuntoQuimico
	 * @param nombre
	 * @param tipoProducto
	 * @param peligro
	 * @return ProductoQuimico creado
	 */
	public ProductoQuimico crearProductoQuimico(Map<ElementoQuimico, Integer> conjuntoQuimico, String nombre, TipoProducto tipoProducto, List<Integer> peligro) {
		ProductoQuimico prod = new ProductoQuimico(conjuntoQuimico, nombre, tipoProducto, mapIdsToTipoPeligro(peligro));
		productosQuimicos.add(prod);
		return prod;
	}
	  
	/**
	 * Registar un empleado tecnico a una prueba
	 * @param idEmpleado
	 * @param idPrueba
	 * @param idSede
	 * @return exito de la operacion
	 * @throws SedeNoEncontrada 
	 * @throws EmpleadoNoEncontrado 
	 * @throws PruebaLoteNoEncontrado 
	 * @throws EmpleadoIncompatible 
	 * @throws LaboratorioNoEncontrado 
	 */
	public boolean registrarEmpleadoPrueba(int idEmpleado, int idPrueba, int idLaboratorio) throws SedeNoEncontrada, EmpleadoNoEncontrado, PruebaLoteNoEncontrado, EmpleadoIncompatible, LaboratorioNoEncontrado { //'id de prueba'/
		
		Empleado empleado = this.buscarEmpleado(idEmpleado);
		Sede sede = this.buscarSede(empleado.getIdSedePertenece());
		
		if(empleado.soyTecnico())
			sede.registrarAyudanteAPrueba((EmpleadoTecnico)empleado, idLaboratorio, idPrueba);
		else
			throw new EmpleadoIncompatible(empleado);
		
		return false;
	}
	 
//	/**
//	 * Asigna un empleado administrativo a una sede
//	 * @param idSede
//	 * @param idEmpleado
//	 * @throws SedeNoEncontrada 
//	 * @throws EmpleadoNoEncontrado 
//	 * @throws EmpleadoIncompatible 
//	 */
//	public void asignarEmpleadoGerenteASede(int idSede, int idEmpleado) throws SedeNoEncontrada, EmpleadoNoEncontrado, EmpleadoIncompatible{//'idSede, idEmpleado'/
//		  Sede sede = this.buscarSede(idSede);
//		  Empleado empleado = this.buscarEmpleado(idEmpleado);
//		  if(empleado.soyGerente())
//			  sede.asignarEmpleadoGerente((EmpleadoGerente)empleado);
//		  else
//			  throw new EmpleadoIncompatible(empleado);
//	}
	
	/*
	 ***************************METODOS PARA EMPLEADO ADMINISTRATIVO***************************
	 */
	
	/**
	 * Modifica la estrategia de vencimiento de una prueba  
	 * @param idPrueba
	 * @param estrategiaVencimiento
	 * @return La prueba modificada
	 * @throws SedeNoEncontrada 
	 * @throws PruebaLoteNoEncontrado 
	 * @throws LaboratorioNoEncontrado 
	 */
	public void establecerEstrategiaVencimiento(int idSede, int idLaboratorio, int idPrueba, EstrategiaVencimiento estrategiaVencimiento) throws SedeNoEncontrada, PruebaLoteNoEncontrado, LaboratorioNoEncontrado{
		  //'id de prueba'/
		Sede sede = this.buscarSede(idSede);
		sede.establecerEstrategiaVencimiento(idLaboratorio, idPrueba, estrategiaVencimiento);
		
	}
	  
	
	  
	
	public boolean laboratorioPuedeProbarProductoQuimico(int idSede, int idLaboratorio, int idProdQuimico) throws SedeNoEncontrada, ProductoQuimicoNoEncontrado, LaboratorioNoEncontrado {
		Sede sede = this.buscarSede(idSede);
		ProductoQuimico productoQuimico = this.buscarProductoQuimico(idProdQuimico);
		return sede.laboratorioPuedeProbarProductoQuimico(idLaboratorio, productoQuimico);
	}
	
	
	public List<PruebaLote> listarPruebas(){
		List<PruebaLote> listaLotes = new ArrayList<>();
		
		for(Sede sede: sedes) {
			listaLotes.addAll(sede.obtenerPruebas());
		}
		
		return listaLotes;
	}
	
	public List<PruebaLote> listarPruebaPorEmpleadoResponsable(int idEmpleado){
		List<PruebaLote> lista = this.listarPruebas().stream()
				.filter(x -> x.getResponsable().esPorId(idEmpleado))
				.collect(Collectors.toList());
		return lista;
	}
	
	
	public List<PruebaLote> listarPruebaPorSede(int idSede){
		List<PruebaLote> lista = new ArrayList();
		
		for(Sede sede: sedes) {
			if(sede.esPorId(idSede))
				lista.addAll(sede.obtenerPruebas());
		}
		return lista;
	}
	
	public List<PruebaLote> listarPruebaPorLaboratorio(int idSede, int idLaboratorio) throws LaboratorioNoEncontrado, SedeNoEncontrada{
		Sede sede = buscarSede(idSede);
		Laboratorio lab = sede.buscarLaboratorio(idLaboratorio);
		
		List<PruebaLote> lista = lab.obtenerPruebas();
		
		return lista;
	}
	
	public List<Laboratorio> listarLaboratoriosPorSede(int idSede) throws SedeNoEncontrada{
		Sede sede = this.buscarSede(idSede);
		
		return sede.getLaboratorios();
	}

	public List<Sede> getSedes() {
		return sedes;
	}

	public List<ProductoQuimico> getProductosQuimicos() {
		return productosQuimicos;
	}

	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public List<TipoPeligro> getTiposPeligro() {
		return tiposPeligro;
	}

	public List<PerfilTecnico> getPerfiles() {
		return perfiles;
	}
	
	private Set<TipoPeligro> mapIdsToTipoPeligro(List<Integer> ids) {
		return tiposPeligro.stream().filter((tp) -> ids.contains(tp.getId()))
				.collect(Collectors.toSet());
	}
}
