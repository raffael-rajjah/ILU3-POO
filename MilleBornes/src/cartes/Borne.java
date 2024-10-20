package cartes;

public class Borne extends Carte {

	private int km;
	
	public Borne(int km) {
		super();
		this.km = km;
	}
	
	@Override
	public String toString() {
		return km + "KM";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!super.equals(obj)) {
			return false;
		}
		
		Borne other = (Borne) obj;
		return this.km == other.km;
	}

	public int getKm() {
		return km;
	}
	
	
	
}
