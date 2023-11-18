package lab.util;

public class GeneradorID {
	private int id;
	
	public GeneradorID() {
		id = 1;
	}
	
	public int nextId() {
		return ++id;
	}
}
