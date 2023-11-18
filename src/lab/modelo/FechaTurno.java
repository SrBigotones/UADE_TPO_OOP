package lab.modelo;

import java.time.LocalDate;

import lab.modelo.enums.Turno;

public class FechaTurno {
	private LocalDate fecha;
	private Turno turno;

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof FechaTurno))
			return false;
		FechaTurno objFechaTurno = (FechaTurno) obj;
		return fecha.equals(objFechaTurno.fecha) && turno.equals(objFechaTurno.turno);
	}
}
