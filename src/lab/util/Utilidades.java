package lab.util;

import java.util.List;

import lab.modelo.Entidad;

public class Utilidades {
	public static <T extends Entidad> T buscarEnListaPorId(int id, List<T> lista) {
		T ret = null;
		for (T entidad: lista) {
			if (entidad.esPorId(id)) {
				ret = entidad;
			}
		}

		return ret;
	}
}
