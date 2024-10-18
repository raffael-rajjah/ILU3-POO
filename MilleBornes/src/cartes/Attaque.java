package cartes;

public class Attaque extends Bataille {

	public Attaque(Type type) {
		super(type);

	}
	
	
	@Override
	public String toString() {
		return super.getType().getAttaque();
	}
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}


}
