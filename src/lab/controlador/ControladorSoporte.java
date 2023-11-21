package lab.controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JPanel;

import lab.modelo.Empresa;
import lab.vista.Menu;
import lab.vista.paneles.BotoneraSoporte;
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
	
	
	public void darAltaAdministrativo() {}
	
	public void crearSede() {}
	
	public void crearPerfilTecnico() {}
	
	public void modificarPerfilTecnico() {}

	
	//Esto pertenece en otro controlador -- TESTING
	public void verSedes() {
		List<SedeView> sedesView = empresaInstance.getSedes().stream().map((s) -> new SedeView(s))
		.collect(Collectors.toList());
		cambiarPanel(new ListadoSedes(sedesView));
//		cambiarPanel(new BotoneraSoporte());
//		cambiarPanel(new ListadoSedes(new ArrayList<SedeView>()));
	}
	
	@Override
	public void mostrarBienvenida() {
		// TODO Auto-generated method stub

		jfMenu = new Menu(new BotoneraSoporte(), new JPanel());
	}
}
