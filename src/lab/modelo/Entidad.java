package lab.modelo;

import lab.util.GeneradorID;

public abstract class Entidad {
	private int id;
	
	public Entidad(GeneradorID generadorID) {
		this.id = generadorID.nextId();
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
