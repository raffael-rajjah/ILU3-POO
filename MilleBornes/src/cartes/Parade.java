package cartes;

public class Parade extends Bataille {

	public Parade(Type type) {
		super(type);

	}
	
	@Override
	public String toString() {
		return super.getType().getParade();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
}
