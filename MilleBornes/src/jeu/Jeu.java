package jeu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cartes.Carte;
import cartes.JeuDeCartes;
import utils.GestionCartes;

public class Jeu {

	private Sabot sabot;
	
	public Jeu() {
		JeuDeCartes jdc = new JeuDeCartes();
		
		Carte[] tableauCartes = jdc.donnerCartes();
		List<Carte> listeCartes  = new ArrayList<>();
		
		
		Collections.addAll(listeCartes, tableauCartes);
		
		listeCartes = GestionCartes.melanger(listeCartes);
		
		Carte[] tableauCartesMelangee = listeCartes.toArray(new Carte[0]);
		
		this.sabot = new Sabot(tableauCartesMelangee);
		
	}
}
