package laboratorio;

import java.util.List;
import java.util.Map;
import java.util.Set;

import laboratorio.empleado.ElementoQuimico;
import laboratorio.empleado.Empleado;
import laboratorio.empleado.EmpleadoTecnico;
import laboratorio.enums.Provincia;
import laboratorio.enums.TipoProducto;

public class Empresa {
	private static int CANT_SEDE_PROVINCIA = 1;
	private static Empresa empresa;
	private List<Sede> sedes;
	private List<ProductoQuimico> productosQuimicos;
	private List<Empleado> empleados;
	private List<TipoPeligro> tipoPeligro;
	private List<PerfilTecnico> perfiles;
	
	private Empresa() {}
	
	public Empresa getInstance() {
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
	 */
	private Empleado buscarEmpleado(int idEmpleado) {
		return null;
	}
	
	private Sede buscarSede(int idSede) {
		return null;
	}
	
	private ProductoQuimico buscarProductoQuimico(int idProductoQuimico) {
		return null;
	}
	
	private PerfilTecnico buscarPerfilTecnico(int idPerfilTecnico) {
		return null;
	}
	
	private TipoPeligro buscarTipoPeligro(int idTipoPeligro) {
		return null;
	}
	
	/**
	 * Busca cuantas sedes existen en una determina provincia
	 * @param provincia
	 * @return el numero de sedes en la provincia
	 */
	private int sedePorProvincia(Provincia provincia) {
		return 0;
	}
	
	/*
	 *************************** METODOS PARA EMPLEADO SOPORTE***************************
	 */
	
	/**
	 * Asociar a un empleado tecnico un perfil tecnico
	 * @param idPerfil
	 * @param idEmpleado
	 */
	public void asociarPerfilEmpleado(int idPerfil, int idEmpleado){}// /'id de perfil, id de empleado'/
	
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
		return null;
	}
	
	
	/**
	 * Modificar perfil tecnico dado un id 
	 * @param idPuesto
	 * @param sueldo
	 * @param maxReservas
	 * @return PerfilTecnico modificado
	 */
	public PerfilTecnico modificarPerfil(int idPuesto, double sueldo, int maxReservas) {// /'idPuesto, sueldo, maxReservas'/
		 return null;
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
	public Object reservar(PruebaLote pruebaLote, FechaTurno fechaTurno, int idSede) {
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
