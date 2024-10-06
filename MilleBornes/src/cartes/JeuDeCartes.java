package cartes;

public class JeuDeCartes {
	
	private Configuration[] typesDeCartes = {
			new Configuration(new Borne(25), 10),
            new Configuration(new Borne(50), 10),
            new Configuration(new Borne(75), 10),
            new Configuration(new Borne(100), 12),
            new Configuration(new Borne(200), 4),
            new Configuration(new Attaque(Type.FEU), 5),
            new Configuration(new Parade(Type.FEU), 14),
            new Configuration(new Botte(Type.FEU), 1),
            new Configuration(new Attaque(Type.ESSENCE), 3),
            new Configuration(new Parade(Type.ESSENCE), 6),
            new Configuration(new Botte(Type.ESSENCE), 1),
            new Configuration(new Attaque(Type.CREVAISON), 3),
            new Configuration(new Parade(Type.CREVAISON), 6),
            new Configuration(new Botte(Type.CREVAISON), 1),
            new Configuration(new Attaque(Type.ACCIDENT), 3),
            new Configuration(new Parade(Type.ACCIDENT), 6),
            new Configuration(new Botte(Type.ACCIDENT), 1),
            new Configuration(new DebutLimite(), 4),
            new Configuration(new FinLimite(), 6)};
	
	public String affichageJeuDeCartes() {
		StringBuilder sb = new StringBuilder();
		
//		int temp = 0;
		
		sb.append("JEU : \n");
		for (int i = 0; i < typesDeCartes.length; i++) {
			sb.append(typesDeCartes[i].getNbExemplaires());
			sb.append(" " + typesDeCartes[i].getCarte().toString() + "\n");
//			temp += typesDeCartes[i].nbExemplaires;
		}
		
//		System.out.println("total exemplaire : " + temp);
		return sb.toString();
	}
	
	 public Carte[] donnerCartes() {
		 
		 int total = 106;
		 Carte [] toutesLesCartes = new Carte[total];
		 
		 int index = 0;
		 
		 for (Configuration conf : typesDeCartes) {
			for (int i = 0; i < conf.getNbExemplaires(); i++) {
				toutesLesCartes[index] = conf.getCarte();
				index++;
			}
		}
		 
		 return toutesLesCartes;
	 }
	 
	 private class Configuration {
			private int nbExemplaires;
			private Carte carte;

			private Configuration(Carte carte, int nbExemplaires) {
				super();
				this.carte = carte;
				this.nbExemplaires = nbExemplaires;
				
			}

			public int getNbExemplaires() {
				return nbExemplaires;
			}

			public Carte getCarte() {
				return carte;
			}
			
			
			
			
		}
}