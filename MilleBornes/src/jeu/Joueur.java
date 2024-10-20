package jeu;

import cartes.Carte;

public class Joueur {
	
	private String nom;
	private ZoneDeJeu zoneDeJeu;
	private MainJoueur main;
	
	public Joueur(String nom, ZoneDeJeu zoneDeJeu, MainJoueur main) {
		this.nom = nom;
		this.zoneDeJeu = zoneDeJeu;
		this.main = main;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		
		if(obj == null || obj.getClass() != getClass()) {
			return false;
		}
		
		
		return obj.toString() == this.nom;
	}
	
	@Override
	public String toString() {
		return nom;
	}
	
	public void donner(Carte carte) {
		main.prendre(carte);
	}
	
	public Carte prendreCarte(Sabot sabot) {
		if(sabot.estVide()) {
			return null;
		}
		
		return sabot.piocher();
	}
	
	public int donnerKmParcourus() {
		return zoneDeJeu.donnerKmParcourus();
	}
	
}
