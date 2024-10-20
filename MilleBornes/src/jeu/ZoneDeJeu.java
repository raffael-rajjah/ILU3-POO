package jeu;

import java.util.ArrayList;
import java.util.List;

import cartes.Bataille;
import cartes.Borne;
import cartes.Carte;
import cartes.FinLimite;
import cartes.Limite;

public class ZoneDeJeu {
	List<Carte> pileLimites;
	List<Carte> pileBatailles;
	List<Borne> collectionBornes;
	
	
	
	public ZoneDeJeu() {
		this.pileLimites = new ArrayList<>();
		this.pileBatailles = new ArrayList<>();
		this.collectionBornes = new ArrayList<>();
	}

	public int donnerLimitationVitesse() {
		if(pileLimites.isEmpty() || pileLimites.get(pileLimites.size() - 1) instanceof FinLimite) {
			return 200;
		}
		
		else {
			return 50;
		}
	}
	
	public int donnerKmParcourus() {
		int totalKm = 0;
		for (Borne borne : collectionBornes) {
			totalKm += borne.getKm();
		}
		
		return totalKm;
	}
	
	public void deposer(Carte carte) {
		if(carte instanceof Limite) {
			pileLimites.add(carte);
		}
		
		else if(carte instanceof Bataille) {
			pileBatailles.add(carte);
		}
		
		else if(carte instanceof Borne borne) {
			collectionBornes.add(borne);
		}
	}
	
}
