package jeu;

import cartes.Attaque;
import cartes.Carte;
import cartes.Limite;

public class Coup {
	Joueur joueurCourant;
	Carte carteJouee;
	Joueur joueurCible;
	
	public Coup(Joueur joueurCourant, Carte carteJouee, Joueur joueurCible) {
		this.joueurCourant = joueurCourant;
		this.carteJouee = carteJouee;
		this.joueurCible = joueurCible;
	}
	
	public boolean estValide() {
		if((carteJouee instanceof Attaque || carteJouee instanceof Limite) && !joueurCible.equals((joueurCourant))){
			return true;
		}
		
		else if(joueurCible.equals(joueurCourant)) {
			return true;
		}
		
		return false;
	}
	
}
