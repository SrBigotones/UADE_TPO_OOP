package inicializacion;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import lab.excepciones.EmpleadoIncompatible;
import lab.excepciones.EmpleadoNoEncontrado;
import lab.excepciones.LaboratorioNoDisponible;
import lab.excepciones.LaboratorioNoEncontrado;
import lab.excepciones.ProductoQuimicoNoEncontrado;
import lab.excepciones.SedeNoEncontrada;
import lab.modelo.ElementoQuimico;
import lab.modelo.Empresa;
import lab.modelo.FechaTurno;
import lab.modelo.enums.Provincia;
import lab.modelo.enums.TipoProducto;
import lab.modelo.enums.Turno;

public class Inicializador {

	public static void ejecutar(Empresa empresa) throws LaboratorioNoEncontrado, LaboratorioNoDisponible, ProductoQuimicoNoEncontrado, EmpleadoNoEncontrado, EmpleadoIncompatible {
		inicializarTiposPeligro(empresa);
		inicializarSedes(empresa);
		inicializarLaboratorios(empresa);
		inicializarPerfilesTecnicos(empresa);
		inicializarEmpleados(empresa);
		inicializarProductosQuimicos(empresa);
		inicializarPrueba(empresa);
	}

	private static void inicializarTiposPeligro(Empresa empresa) {
		empresa.crearTipoPeligro("Inflamable", 0, 20);
		empresa.crearTipoPeligro("Toxico", 0, 10);
		empresa.crearTipoPeligro("Corrosivo", 0, 50);
	}

	private static void inicializarSedes(Empresa empresa) {
		empresa.crearSede(Provincia.BUENOS_AIRES);
		empresa.crearSede(Provincia.CORDOBA);
	}

	private static void inicializarLaboratorios(Empresa empresa) {
		try {
			empresa.crearLaboratorio(10, Arrays.asList(1, 2), 1);
			empresa.crearLaboratorio(15, Arrays.asList(1), 1);
			empresa.crearLaboratorio(8, Arrays.asList(3), 1);
		} catch (SedeNoEncontrada e) {
			e.printStackTrace();
		}
	}

	private static void inicializarPerfilesTecnicos(Empresa empresa) {
		empresa.crearPerfil("Farmaceutico", 100000, 4);
		empresa.crearPerfil("Quimico", 80000, 3);
		empresa.crearPerfil("Asistente", 50000, 0);
	}

	private static void inicializarEmpleados(Empresa empresa) {
		empresa.crearEmpleadoAdministrativo("Gaston", "gaston",1);
		empresa.crearEmpleadoTecnico("Augusto", "augusto", 1,1);
		empresa.crearEmpleadoGerente("Agustin", "agustin",1);
		empresa.crearEmpleadoSoporte("Nicolas", "nicorepo");
		empresa.crearEmpleadoAdministrativo("Pepe", "pepinho",1);
		
//		try {
//			empresa.asignarAdministrativoASede(1, 1);
//			empresa.asignarAdministrativoASede(2, 5);
//		} catch (EmpleadoNoEncontrado | SedeNoEncontrada | EmpleadoIncompatible e) {
//			e.printStackTrace();
//		}
	}

	private static void inicializarProductosQuimicos(Empresa empresa) {
		Map<ElementoQuimico, Integer> elementos = new HashMap<>();
		elementos.put(ElementoQuimico.AZUFRE, 1);
		elementos.put(ElementoQuimico.CALCIO, 2);

		empresa.crearProductoQuimico(elementos, "Producto 1", TipoProducto.LIMPIEZA, Arrays.asList(1));

		elementos = new HashMap<>();
		elementos.put(ElementoQuimico.AZUFRE, 1);
		elementos.put(ElementoQuimico.HIERRO, 3);
		elementos.put(ElementoQuimico.CALCIO, 5);

		empresa.crearProductoQuimico(elementos, "Producto 2", TipoProducto.LIMPIEZA, Arrays.asList(1, 2));

		elementos = new HashMap<>();
		elementos.put(ElementoQuimico.SODIO, 4);

		empresa.crearProductoQuimico(elementos, "Producto 3", TipoProducto.MEDICAMENTO, Arrays.asList(3));

		elementos = new HashMap<>();
		elementos.put(ElementoQuimico.CALCIO, 2);

		empresa.crearProductoQuimico(elementos, "Producto 4", TipoProducto.PERFUMERIA, Arrays.asList(1, 3));
	}
	
	
	private static void inicializarPrueba(Empresa empresa) throws LaboratorioNoEncontrado, LaboratorioNoDisponible, ProductoQuimicoNoEncontrado, EmpleadoNoEncontrado, EmpleadoIncompatible {
		empresa.reservar(1, 5, 2, new FechaTurno(LocalDate.now(), Turno.MAÑANA), 1);
	}
}
