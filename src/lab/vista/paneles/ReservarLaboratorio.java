package lab.vista.paneles;

import java.awt.GridLayout;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import lab.controlador.ControladorTecnico;
import lab.excepciones.EmpleadoIncompatible;
import lab.excepciones.EmpleadoNoEncontrado;
import lab.excepciones.LaboratorioNoDisponible;
import lab.excepciones.LaboratorioNoEncontrado;
import lab.excepciones.ProductoQuimicoNoEncontrado;
import lab.excepciones.SedeNoEncontrada;
import lab.modelo.FechaTurno;
import lab.modelo.enums.Turno;
import lab.vista.tablas.ModeloLaboratorio;
import lab.vista.view.ProductoQuimicoView;

public class ReservarLaboratorio extends JPanel{
	
	private ControladorTecnico controlador;
	
	public ReservarLaboratorio() throws SedeNoEncontrada {
		controlador = ControladorTecnico.getInstance();
		
		GridLayout layout = new GridLayout(10,2);
		setLayout(layout);
		ModeloLaboratorio modeloLab = new ModeloLaboratorio(controlador.listarLaboratorios());
		JTable tablaLabs = new JTable(modeloLab);
		JScrollPane scrollPane = new JScrollPane(tablaLabs);
		JComboBox<ProductoQuimicoView> comboProdQ = new JComboBox<ProductoQuimicoView>();
		
		JComboBox<Turno> comboTurno = new JComboBox<Turno>();
		comboTurno.addItem(Turno.MADRUGADA);
		comboTurno.addItem(Turno.MAÑANA);
		comboTurno.addItem(Turno.TARDE);
		
		JTextField tfDate = new JTextField("12/01/24");
		JTextField tfNAyudantes = new JTextField();
		JButton btnReservar = new JButton("Reservar");
		for(ProductoQuimicoView prod: controlador.listarProductosQuimicos()) {
			comboProdQ.addItem(prod);
		}
		
		add(new JLabel("Laboratorios:"));
		add(scrollPane);
		add(new JLabel("Producto Quimico:"));
		add(comboProdQ);
		add(new JLabel("Turno:"));
		add(comboTurno);
		add(new JLabel("Fecha(DD/MM/YY)"));
		add(tfDate);
		add(new JLabel("N. Ayudantes:"));
		add(tfNAyudantes);
		
		
		add(btnReservar);
		
		
		btnReservar.addActionListener(e -> {
			int idLab = (int) tablaLabs.getValueAt(tablaLabs.getSelectedRow(), 0);
			int idProdQ = ((ProductoQuimicoView)comboProdQ.getSelectedItem()).getIdProductoQuimico();
			int cantAuxiliares = Integer.parseInt(tfNAyudantes.getText());
			LocalDate date = LocalDate.parse(tfDate.getText(), DateTimeFormatter.ofPattern("dd/MM/yy")); 			
			FechaTurno fecha = new FechaTurno(date, comboTurno.getItemAt(comboTurno.getSelectedIndex()));
			System.out.println(date);
			try {
				controlador.reservarPrueba(idProdQ, cantAuxiliares, fecha, idLab);
				JOptionPane.showMessageDialog(null, "Operacion realizada con exito!");
			} catch (LaboratorioNoEncontrado | LaboratorioNoDisponible | ProductoQuimicoNoEncontrado
					| EmpleadoNoEncontrado | EmpleadoIncompatible e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Algo salio mal...");
				e1.printStackTrace();
			}
		});
		
		
		
	}
	

}
