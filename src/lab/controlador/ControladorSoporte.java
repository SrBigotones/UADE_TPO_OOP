package lab.controlador;

import java.util.List;
import java.util.stream.Collectors;

import lab.modelo.Empresa;
import lab.vista.paneles.ListadoSedes;
import lab.vista.view.SedeView;

public class ControladorSoporte extends Controlador {
	private static ControladorSoporte instance;

	ControladorSoporte() {
	}

	public static synchronized ControladorSoporte getInstance() {
		if (instance == null) {
			instance = new ControladorSoporte();
		}
		return instance;
	}

	public void mostrarPantallaSedes() {
		List<SedeView> sedesView = Empresa.getInstance().getSedes().stream().map((s) -> new SedeView(s))
				.collect(Collectors.toList());
		cambiarPanel(new ListadoSedes(sedesView));
	}
}
