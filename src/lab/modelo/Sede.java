package lab.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import lab.excepciones.LaboratorioNoDisponible;
import lab.excepciones.LaboratorioNoEncontrado;
import lab.excepciones.PruebaLoteNoEncontrado;
import lab.modelo.empleado.EmpleadoGerente;
import lab.modelo.empleado.EmpleadoTecnico;
import lab.modelo.enums.EstadoLote;
import lab.modelo.enums.Provincia;
import lab.util.GeneradorID;
import lab.util.Utilidades;

public class Sede extends Entidad {
	private static GeneradorID generadorID = new GeneradorID();
	private List<Laboratorio> laboratorios;
	private Provincia provincia;

	public Sede(Provincia provincia) {
		super(generadorID);
		this.provincia = provincia;
		this.laboratorios = new ArrayList<>();
	}

	public Laboratorio agregarLaboratorio(int capacidadPersonas, Set<TipoPeligro> tipoPeligros) {
		Laboratorio laboratorio = new Laboratorio(capacidadPersonas, tipoPeligros);
		laboratorios.add(laboratorio);
		return laboratorio;
	}
	
	/**
	 * 
	 * @param idLaboratorio
	 * @param productoQuimico
	 * @param cantidadAuxiliares
	 * @param empleadoResponsable
	 * @param fechaTurno
	 * @return
	 * @throws LaboratorioNoEncontrado
	 * @throws LaboratorioNoDisponible
	 */
	public PruebaLote reservarPrueba(int idLaboratorio, ProductoQuimico productoQuimico, int cantidadAuxiliares,EmpleadoTecnico empleadoResponsable, FechaTurno fechaTurno ) throws LaboratorioNoEncontrado, LaboratorioNoDisponible {
		Laboratorio laboratorio = this.buscarLaboratorio(idLaboratorio);
		return laboratorio.reservar(productoQuimico, cantidadAuxiliares, empleadoResponsable, fechaTurno);
	}
	

	public Laboratorio buscarLaboratorio(int id) throws LaboratorioNoEncontrado {
		Laboratorio lab =Utilidades.buscarEnListaPorId(id, laboratorios);
		if(lab != null)
			return lab;
		
		throw new LaboratorioNoEncontrado();
	}


	public List<Laboratorio> getLaboratorios() {
		return laboratorios;
	}

	public void setLaboratorios(List<Laboratorio> laboratorios) {
		this.laboratorios = laboratorios;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public boolean laboratorioPuedeProbarProductoQuimico(int idLaboratorio, ProductoQuimico productoQuimico) throws LaboratorioNoEncontrado {
		Laboratorio lab = this.buscarLaboratorio(idLaboratorio);
		return lab.puedeProbarProductoQuimico(productoQuimico);
	}
	
	public void registrarAyudanteAPrueba(EmpleadoTecnico empleado, int idLaboratorio, int idPrueba) throws PruebaLoteNoEncontrado, LaboratorioNoEncontrado {
		Laboratorio lab = this.buscarLaboratorio(idLaboratorio);
		lab.registrarAyudanteAPrueba(empleado, idPrueba);
	}
	

	public void establecerEstrategiaVencimiento(int idLaboratorio, int idPrueba, EstrategiaVencimiento estrategiaVencimiento) throws PruebaLoteNoEncontrado, LaboratorioNoEncontrado {
		Laboratorio lab = this.buscarLaboratorio(idLaboratorio);
		lab.establecerEstrategiaVencimiento(idPrueba, estrategiaVencimiento);
	}

	public void finalizarPrueba(int idLaboratorio, int idLote,EstadoLote estadoLote, EstrategiaVencimiento estrategiaVencimiento) throws PruebaLoteNoEncontrado, LaboratorioNoEncontrado {
		Laboratorio lab = this.buscarLaboratorio(idLaboratorio);
		lab.finalizarPrueba(idLote,estadoLote, estrategiaVencimiento);
		
	}
	
	public List<PruebaLote> obtenerPruebas(){
		List<PruebaLote> lista = new ArrayList();
		for(Laboratorio lab: laboratorios)
			lista.addAll(lab.obtenerPruebas());
		
		return lista;
	}
}
