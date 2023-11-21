package lab.controlador;

public class ControladorGerente {
	
	 private static ControladorGerente instance;
	 
	 private ControladorGerente() {
		 
	 }
	 
	
	public synchronized ControladorGerente getInstance() {
		if(instance == null)
			instance = new ControladorGerente();
		
		return instance;
	}
	public void visualizarPruebas() {}
	public void cambiarCriterioVencimiento() {}
	public void confimarPruebaParaVenta() {}
}
