package inicializacion;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lab.modelo.Laboratorio;
import lab.modelo.PerfilTecnico;
import lab.modelo.Sede;
import lab.modelo.TipoPeligro;
import lab.modelo.enums.Provincia;

public class Inicializador {

	public static List<TipoPeligro> inicializarTiposPeligro() {
		TipoPeligro tipo1 = new TipoPeligro("Inflamable", 0);
		TipoPeligro tipo2 = new TipoPeligro("Toxico", 0);
		TipoPeligro tipo3 = new TipoPeligro("Corrosivo", 0);
		
		return Arrays.asList(tipo1, tipo2, tipo3);
	}
	
	public static List<Sede> inicializarSedes() {
		return Arrays.asList(crearSedeBuenosAires(), crearSedeCordoba());
	}
	
	private static Sede crearSedeBuenosAires() {
		Sede sede = new Sede(Provincia.BUENOS_AIRES);
		
		Set<Integer> peligros1 = new HashSet<>();
		peligros1.add(1);
		peligros1.add(2);
		Laboratorio lab1 = new Laboratorio(10, peligros1);
		sede.agregarLaboratorio(lab1);
		
		Set<Integer> peligros2 = new HashSet<>();
		peligros2.add(2);
		peligros2.add(3);
		Laboratorio lab2 = new Laboratorio(15, peligros2);
		sede.agregarLaboratorio(lab2);
		
		return sede;
	}
	
	private static Sede crearSedeCordoba() {
		Sede sede = new Sede(Provincia.CORDOBA);
		
		return sede;
	}
	
	public static List<PerfilTecnico> inicializarPerfilesTecnicos() {
		PerfilTecnico p1 = new PerfilTecnico("Farmaceutico", 100000, 4);
		PerfilTecnico p2 = new PerfilTecnico("Quimico", 80000, 3);
		PerfilTecnico p3 = new PerfilTecnico("Asistente", 50000, 0);
		
		return Arrays.asList(p1, p2, p3);
	} 
}
