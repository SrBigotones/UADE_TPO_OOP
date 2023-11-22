package lab.controlador;

import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import lab.excepciones.AccesoRestringido;
import lab.excepciones.EmpleadoNoEncontrado;
import lab.excepciones.LaboratorioNoEncontrado;
import lab.excepciones.PruebaLoteNoEncontrado;
import lab.excepciones.SedeNoEncontrada;
import lab.modelo.EstrategiaVencimiento;
import lab.modelo.enums.EstadoLote;
import lab.vista.Menu;
import lab.vista.paneles.BotoneraGerente;
import lab.vista.paneles.CambiarCriterioVencimiento;
import lab.vista.view.CriterioVencimientoView;
import lab.vista.view.LaboratorioView;
import lab.vista.view.PruebaLoteView;
import lab.vista.view.SedeView;
import net.miginfocom.swing.MigLayout;

public class ControladorGerente extends Controlador{
	
	 private static ControladorGerente instance;
	 
	 private ControladorGerente() {
		 
	 }
	 
	
	public static synchronized ControladorGerente getInstance() {
		if(instance == null)
			instance = new ControladorGerente();
		
		return instance;
	}
	public void visualizarPruebas() {}
	
	public void cambiarCriterioVencimiento(int idSede, int idLab, int idLote, int idEstrategia) throws SedeNoEncontrada, PruebaLoteNoEncontrado, LaboratorioNoEncontrado, AccesoRestringido, EmpleadoNoEncontrado {
		empresaInstance.finalizarPrueba(idSede,usuario.getId(), idLab, idLote, idEstrategia);
	}
	public void confimarPruebaParaVenta() {}
	
	public void mostrarBienvenida() {
		JPanel panelBienvenida = new JPanel(new MigLayout("fill", "[100%]", ""));
		panelBienvenida.setSize(200, 300);
		panelBienvenida.add(new JLabel("¡Bienvenido Gerente!", SwingConstants.CENTER), "grow, center");
		jfMenu = new Menu(new BotoneraGerente(), panelBienvenida);
		
	}


	public void mostrarCambiarCriterioVencimiento() {
		// TODO Auto-generated method stub
		cambiarPanel(new CambiarCriterioVencimiento());
		
	}


	public void mostrarConfimarPruebaParaVenta() {
		// TODO Auto-generated method stub
		
	}
	
	public List<SedeView> listarSedes() {
		return empresaInstance.getSedes().stream().map((s) -> new SedeView(s)).collect(Collectors.toList());
	}
	
	public List<LaboratorioView> listarLaboratorios(int idSede) throws SedeNoEncontrada{
		List<LaboratorioView> lab = empresaInstance.listarLaboratoriosPorSede(idSede)
				.stream()
				.map(x -> new LaboratorioView(x))
				.collect(Collectors.toList());
		
		return lab;
	}
	
	public List<PruebaLoteView> listarPruebasEnLaboratorio(int idSede,int idLaboratorio) throws LaboratorioNoEncontrado, SedeNoEncontrada {
		List<PruebaLoteView> lista = empresaInstance.listarPruebaPorLaboratorio(idSede, idLaboratorio)
				.stream()
				.map(x -> new PruebaLoteView(x))
				.collect(Collectors.toList());
		
		return lista;
	}
	
	public List<CriterioVencimientoView> listarCriterioVencimiento(){
		List<CriterioVencimientoView> lista = empresaInstance.listarCriterioVencimiento()
				.stream()
				.map(x -> new CriterioVencimientoView(x))
				.collect(Collectors.toList());
		
		return lista;
	}
}
