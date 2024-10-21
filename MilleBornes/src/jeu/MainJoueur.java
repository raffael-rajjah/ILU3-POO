package jeu;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import cartes.Carte;

public class MainJoueur extends Carte implements Iterable<Carte>{

	List<Carte> cartesEnMain;
	
	public void prendre(Carte carte) {
		cartesEnMain.add(carte);
	}
	
	public void jouer(Carte carte) {
		assert cartesEnMain.contains(carte);
		
		cartesEnMain.remove(carte);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		ListIterator<Carte> iterator = cartesEnMain.listIterator();
		
		while(iterator.hasNext()) {
			sb.append("- " + iterator.next().toString() + "\n");
		}
		
		return sb.toString();
	}

	@Override
	public Iterator<Carte> iterator() {
		return cartesEnMain.iterator() ;
	}
	
	
	
	
	
	
}
