package cartes;

public class Botte extends Probleme {

	public Botte(Type type) {
		super(type);
	}
	
	@Override
	public String toString() {
		return super.getType().getBotte();
	}
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}


}
