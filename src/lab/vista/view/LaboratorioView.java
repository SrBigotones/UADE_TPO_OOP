package lab.vista.view;

import java.util.List;
import java.util.stream.Collectors;

import lab.modelo.Laboratorio;
import lab.modelo.TipoPeligro;

public class LaboratorioView {
	private int idLab;
	private int capacidadPersonas;
	private List<PeligrosViewCheck> tiposPeligro;
	
	public LaboratorioView(Laboratorio lab) {
		this.idLab = lab.getId();
		this.capacidadPersonas = lab.getCapacidadPersonas();
		this.tiposPeligro = lab.getPeligrosPermitidos().stream().map((p) -> new PeligrosViewCheck(p))
				.collect(Collectors.toList());;
	}

	public int getIdLab() {
		return idLab;
	}

	public int getCapacidadPersonas() {
		return capacidadPersonas;
	}
	
	public String getStringPeligros() {
		if (tiposPeligro.size() == 0) return " - ";
		String peligros = tiposPeligro.get(0).getNombre();
		for (int i = 0; i < tiposPeligro.size(); i++) {
			peligros += ", " + tiposPeligro.get(i).getNombre();
		}
		return peligros;
	}

}
