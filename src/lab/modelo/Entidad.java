package lab.modelo;

import java.util.List;

import lab.util.GeneradorID;

public abstract class Entidad {
	private static GeneradorID generadorID = new GeneradorID();
	private int id;
	
	public Entidad() {
		id = generadorID.nextId();
	}
	
	public int getId() {
		return id;
	}
	
	public boolean esPorId(int id) {
		return this.id == id;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj.getClass().isInstance(this.getClass())));
		Entidad entidad = (Entidad) obj;
		return entidad.esPorId(id);
	}
}
