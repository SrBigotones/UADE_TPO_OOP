package lab.vista.paneles;

import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTable;

import lab.controlador.ControladorTecnico;
import lab.excepciones.SedeNoEncontrada;
import lab.modelo.enums.Turno;
import lab.vista.tablas.ModeloLaboratorio;

public class ReservarLaboratorio extends JPanel{
	
	private ControladorTecnico controlador;
	
	public ReservarLaboratorio() throws SedeNoEncontrada {
		controlador = ControladorTecnico.getInstance();
		
		GridLayout layout = new GridLayout();
		setLayout(layout);
		ModeloLaboratorio modeloLab = new ModeloLaboratorio(controlador.listarLaboratorios());
		JTable tablaLabs = new JTable(modeloLab);
		JComboBox tablaProdQ;
		JComboBox<Turno> comboTurno;
		
		
		
	}
	

}
