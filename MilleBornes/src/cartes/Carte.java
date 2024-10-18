package cartes;

public abstract class Carte {
	
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		
		else if(obj == null || getClass() != obj.getClass()) {
			return false;
		}
		
		return true;
	}
	
}
