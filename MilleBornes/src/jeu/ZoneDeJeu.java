package jeu;

import java.util.ArrayList;

import java.util.HashSet;
import java.util.Set;

import java.util.List;

import cartes.Attaque;
import cartes.Bataille;
import cartes.Borne;
import cartes.Botte;
import cartes.Carte;
import cartes.Cartes;
import cartes.DebutLimite;
import cartes.FinLimite;
import cartes.Limite;
import cartes.Parade;
import cartes.Type;

public class ZoneDeJeu {
	List<Limite> pileLimites;
	List<Bataille> pileBatailles;
	List<Borne> collectionBornes;
	
	Set<Carte> ensembleBottes;
	
	
	public ZoneDeJeu() {
		this.pileLimites = new ArrayList<>();
		this.pileBatailles = new ArrayList<>();
		this.collectionBornes = new ArrayList<>();
		this.ensembleBottes = new HashSet<>();
	}

	public int donnerLimitationVitesse() {
		if(pileLimites.isEmpty() || getSommet(pileLimites) instanceof FinLimite || estPrioritaire()) {
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
		if(carte instanceof Limite limite) {
			pileLimites.add(limite);
		}
		
		else if(carte instanceof Bataille bataille) {
			pileBatailles.add(bataille);
		}
		
		else if(carte instanceof Borne borne) {
			collectionBornes.add(borne);
		}
		
		else if(carte instanceof Botte botte) {
			ensembleBottes.add(botte);
		}
		
	}
	

	
	
	private <E> E getSommet(List<E> liste) {
		
		if(liste.isEmpty()) {
			return null;
		}
		
		return liste.get(liste.size() - 1);
	}
	
	private boolean estBotteExiste(Bataille bataille) {
		
		Botte botteMemeType = new Botte(bataille.getType());
		
		return ensembleBottes.contains(botteMemeType);
		
	}
	

	public boolean peutAvancer() {
		
		if(pileBatailles.isEmpty() && !estPrioritaire()) {
			return false;
		}
		
		Bataille sommet = getSommet(pileBatailles);
		
		Botte bottePourAttaque = null;
		
		if(sommet != null) {
			bottePourAttaque = new Botte(sommet.getType());
			
		}
		
//		if(!pileBatailles.isEmpty()) {
//			System.out.println("Sommet = " + sommet.toString());
//			
//		}
		
//		System.out.println("prioritaire ???? -> " + estPrioritaire() + pile);
		
		return (pileBatailles.isEmpty() && estPrioritaire()) 
				|| sommet.equals(Cartes.FEU_VERT)
				|| (sommet instanceof Parade && estPrioritaire())
				|| (sommet.equals(Cartes.FEU_ROUGE) && estPrioritaire())
				|| (sommet instanceof Attaque attaque && ensembleBottes.contains(bottePourAttaque) && estPrioritaire());

	}
	
	private boolean estDepotFeuVertAutorise() {
		
		Bataille sommet = getSommet(pileBatailles);
		
		if(estPrioritaire()) {
			return false;
		}
		
		else if(pileBatailles.isEmpty() || sommet.equals(Cartes.FEU_ROUGE) || !sommet.equals(Cartes.FEU_VERT) || (sommet instanceof Attaque attaque && estBotteExiste(attaque))) {
			return true;
		}
		
		return false;
		
//		return pileBatailles.isEmpty() || sommet.equals(Cartes.FEU_ROUGE) || !sommet.equals(Cartes.FEU_VERT);
	}
	
	private boolean estDepotBorneAutorise(Borne borne) {

		return peutAvancer() && borne.getKm() <= donnerLimitationVitesse() && donnerKmParcourus() < 1000;

	}
	
	private boolean estDepotLimiteAutorise(Limite limite) {
		
		if(estPrioritaire()) {
			return false;
		}
		
		if(limite instanceof DebutLimite) {
			return pileLimites.isEmpty() || getSommet(pileLimites) instanceof FinLimite;
		}
		
		else {
			return !pileLimites.isEmpty() && getSommet(pileLimites) instanceof DebutLimite;
		}
	}
	
	private boolean estDepotBatailleAutorise(Bataille bataille) {
		
		if(estBotteExiste(bataille)) {
			return false;
		}
		
		if(bataille instanceof Attaque) {
			return peutAvancer();
		}
		
		else if(bataille instanceof Parade) {
			if(bataille.equals(Cartes.FEU_VERT)) {
				return estDepotFeuVertAutorise();
			}
			
			return !pileBatailles.isEmpty() && getSommet(pileBatailles).getType().equals(bataille.getType()); 

		}
		
		return false;
	}
	
	
	public boolean estDepotAutorise(Carte carte) {
		
		
		if(carte instanceof Borne borne) {
			return estDepotBorneAutorise(borne);
		}
		
		else if(carte instanceof Limite limite) {
			return estDepotLimiteAutorise(limite);
		}
		
		else if (carte instanceof Bataille bataille) {
			return estDepotBatailleAutorise(bataille);
		}
		
		else if(carte instanceof Botte botte) {
			return true;
		}
		
		else {
			return false;
		}
	}
	
	public boolean estPrioritaire() {
		Botte bottePrioritaire = new Botte(Type.FEU);
		return ensembleBottes.contains(bottePrioritaire);
	}
	

	
}
