package lab.modelo;

import java.util.List;
import java.util.Map;
import java.util.Set;

import inicializacion.Inicializador;
import lab.excepciones.EmpleadoNoEncontrado;
import lab.excepciones.PerfilTenicoNoEncontrado;
import lab.excepciones.SedeNoEncontrada;
import lab.excepciones.TipoPeligroNoEncontrado;
import lab.modelo.empleado.Empleado;
import lab.modelo.empleado.EmpleadoTecnico;
import lab.modelo.enums.Provincia;
import lab.modelo.enums.TipoProducto;

public class Empresa {
	private static int CANT_SEDE_PROVINCIA = 1;
	
	private List<Sede> sedes;
	private List<ProductoQuimico> productosQuimicos;
	private List<Empleado> empleados;
	private List<TipoPeligro> tipoPeligros;
	private List<PerfilTecnico> perfiles;
	
	private static Empresa empresa;
	
	private Empresa() {}
	
	public static synchronized Empresa getInstance() {
		if(empresa == null) {
			empresa = new Empresa();
			empresa.sedes = Inicializador.inicializarSedes();
			empresa.tipoPeligros = Inicializador.inicializarTiposPeligro();
			empresa.perfiles = Inicializador.inicializarPerfilesTecnicos();
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
		
		for(Empleado empleado: empleados) {
			if(empleado.esPorId(idEmpleado))
				return empleado;
		}
		throw new EmpleadoNoEncontrado();
	}
	
	private Sede buscarSede(int idSede) throws SedeNoEncontrada {
		
		for(Sede sede: sedes) {
			if(sede.esPorId(idSede))
				return sede;
		}
		throw new SedeNoEncontrada();
	}
	
	private ProductoQuimico buscarProductoQuimico(int idProductoQuimico) {
		return null;
	}
	
	private PerfilTecnico buscarPerfilTecnico(int idPerfilTecnico) throws PerfilTenicoNoEncontrado {
		
		for(PerfilTecnico perfil: perfiles) {
			if(perfil.esPorId(idPerfilTecnico))
				return perfil;
		}
		
		
		throw new PerfilTenicoNoEncontrado();
	}
	
	
	/**
	 * Busca tipoPeligro y retorna el mismo.
	 * @param idTipoPeligro
	 * @return
	 * @throws TipoPeligroNoEncontrado
	 */
	private TipoPeligro buscarTipoPeligro(int idTipoPeligro) throws TipoPeligroNoEncontrado {
		
		for(TipoPeligro tipoPeligro: tipoPeligros) {
			if(tipoPeligro.esPorId(idTipoPeligro))
				return tipoPeligro;
		}
		
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
	public Empleado crearEmpleado(String nombre) {
		
		
		return null;
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
	 * @param idPuesto
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
	public TipoPeligro crearTipoPeligro(String nombre, double costo) {
		return null;
	}
	 
	/**
	 * Modifica peligro quimico existente
	 * @param idPeligro
	 * @param costo
	 * @return TipoPeligro modificado
	 */
	public TipoPeligro modificarTipoPeligro(int idPeligro, double costo) {
		return null;
	}
	
	/**
	 * Crear un nuevo laboratorio en una sede
	 * @param capacidadPersonas
	 * @param tipoPeligros
	 * @return Laboratorio creado
	 */
	public Laboratorio crearLaboratorio(int capacidadPersonas, Set<TipoPeligro> tipoPeligros, int idSede) { ///'capacidadPersonas'/
		return null;
	}
	/**
	 * Modificar un laboratorio
	 * @param capacidadPersonas
	 * @param tipoPeligros
	 * @return Laboratorio modificado
	 */
	public Laboratorio modificarLaboratorio(int idLaboratorio, int idSede, int capacidadPersonas, Set<TipoPeligro> tipoPeligros){// /'capacidadPersonas'/
		return null;
	}
	
	/**
	 * Crea una sede en la provincia determinada
	 * @param provincia
	 * @return Sede creada
	 */
	public Sede crearSede(Provincia provincia) {
		return null;
	}
	 
	 /*
	  * ***************************METODOS EMPLEADO TECNICO***************************
	  */
	/**
	 * Reservar un laboratorio para realizar una prueba
	 * @param pruebaLote
	 * @param fechaTurno
	 * @param sede
	 * @return Reserva?????
	 */
	public Object reservar(int idPruebaLote, FechaTurno fechaTurno, int idSede) {
		return null;
	}
	
	
	/**
	 * Diagnosticar resultado de prueba
	 * @param idLote
	 * @param aprobacion
	 */
	public void diagnosticarPrueba(int idLote, boolean aprobacion) { //'idLote, aprobacion'/
		 
	}
	 
	/**
	 * Crear nuevo producto quimico
	 * @param conjuntoQuimico
	 * @param nombre
	 * @param tipoProducto
	 * @param peligro
	 * @return ProductoQuimico creado
	 */
	public ProductoQuimico crearProductoQuimico(Map<ElementoQuimico, Integer> conjuntoQuimico, String nombre, TipoProducto tipoProducto, Set<TipoPeligro> peligro) {
		return null;
	}
	  
	/**
	 * Registar un empleado tecnico a una prueba
	 * @param idEmpleado
	 * @param idPrueba
	 * @param idSede
	 * @return exito de la operacion
	 */
	public boolean registrarEmpleadoPrueba(int idEmpleado, int idPrueba, int idSede) { //'id de prueba'/
		return false;
	}
	 
	public void agregarSede(Provincia provincia) {
		Sede sede = new Sede(provincia);
		sedes.add(sede);
	}
	
	 
	/**
	 * Asigna un empleado administrativo a una sede
	 * @param idSede
	 * @param idEmpleado
	 */
	public void asignarEmpleadoAdministrivoASede(int idSede, int idEmpleado){//'idSede, idEmpleado'/
		  
	}
	
	/*
	 ***************************METODOS PARA EMPLEADO ADMINISTRATIVO***************************
	 */
	
	/**
	 * Modifica la estrategia de vencimiento de una prueba  
	 * @param idPrueba
	 * @param estrategiaVencimiento
	 * @return La prueba modificada
	 */
	public PruebaLote establecerEstrategiaVencimiento(int idPrueba, EstrategiaVencimiento estrategiaVencimiento){
		  //'id de prueba'/
		return null;
	}
	  
	  //' Gerente '/
	/**
	 * Esto parece estar repetido de establecerEstrategiaVencimiento
	 * @param idLote
	 * @param estrategiaVencimiento
	 * @return
	 */
	public PruebaLote cambiarCriterioVencimiento(int idLote, EstrategiaVencimiento estrategiaVencimiento){
		//'idLote'/
		return null;
	}
	  
	public void confirmarLote(int idLote) {//'idLote'/	  
	}
}
