package testsFonctionnels;

import java.util.Iterator;

import cartes.Carte;
import cartes.JeuDeCartes;

public class TestJeuDeCartes {
	
	public static void main(String[] args) {
		JeuDeCartes jdc;
		jdc = new JeuDeCartes();
		String a = jdc.affichageJeuDeCartes();
		System.out.println(a);
		
//		Carte[] b = jdc.donnerCartes();
//		
//		for (Carte carte : b) {
//			System.out.println(carte.toString());
//		}

	}
}


