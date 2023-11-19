package inicializacion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import lab.excepciones.SedeNoEncontrada;
import lab.modelo.ElementoQuimico;
import lab.modelo.Empresa;
import lab.modelo.enums.Provincia;
import lab.modelo.enums.TipoProducto;

public class Inicializador {

	public static void ejecutar(Empresa empresa) {
		inicializarTiposPeligro(empresa);
		inicializarSedes(empresa);
		inicializarLaboratorios(empresa);
		inicializarPerfilesTecnicos(empresa);
		inicializarEmpleados(empresa);
		inicializarProductosQuimicos(empresa);
	}

	private static void inicializarTiposPeligro(Empresa empresa) {
		empresa.crearTipoPeligro("Inflamable", 0);
		empresa.crearTipoPeligro("Toxico", 0);
		empresa.crearTipoPeligro("Corrosivo", 0);
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
		empresa.crearEmpleado("Gaston");
		empresa.crearEmpleado("Augusto");
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
}
