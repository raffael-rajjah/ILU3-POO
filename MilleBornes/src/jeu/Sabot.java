package jeu;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import cartes.Carte;
import cartes.JeuDeCartes;

public class Sabot implements Iterable<Carte>{
	Carte[] cartes;
	int nbCartes;
	int nbCartesMax;
	private int nombreOperations = 0;
	
	public Sabot(Carte[] cartes) {
		super();

		this.cartes = cartes;
		this.nbCartes = cartes.length;
		this.nbCartesMax = cartes.length;
	}
	
	public boolean estVide() {
		return nbCartes <= 0;
	}
	
	public void ajouterCarte(Carte carte) {
		if(nbCartes >= nbCartesMax) {
			throw new ArrayIndexOutOfBoundsException();
		}
		
		else {
			cartes[nbCartes] = carte;
			nbCartes++;
		}
		
		nombreOperations++;
	}
	
	public Carte piocher() {
		Iterator<Carte> it = iterator();
		
		Carte carte = it.next();
		it.remove();
		
		return carte;
		
	}

	
	@Override
	public Iterator<Carte> iterator() {
		return new Iterateur();
	}
	
//	 --------------------------------------------------------------------------------------------------------------------
	
	private class Iterateur implements Iterator<Carte>{
		private int indiceIterateur = 0;
		private int nombreOperationsReference = nombreOperations;
		private boolean nextEffectue = false;

		public boolean hasNext(){
			verificationConcurrence();

			return indiceIterateur < nbCartes;
		}
		
		public Carte next(){
			
			verificationConcurrence();
			
			if(hasNext()) {
				Carte carte = cartes[indiceIterateur];
				indiceIterateur++;
				nextEffectue = true;
				return carte;
				
			}
			
			else {
				throw new NoSuchElementException();
			}
		
		}

		@Override
		public void remove(){
			verificationConcurrence();
			
			if(nbCartes < 1 || !nextEffectue) {
				throw new IllegalStateException();
			}
			
			for(int i = indiceIterateur - 1; i < nbCartes - 1; i++) {
				cartes[i] = cartes[i+1];
			}
			
			nextEffectue = false;
			indiceIterateur--;
			nbCartes--;

			nombreOperationsReference++; 
			nombreOperations++;
		}

		private void verificationConcurrence(){
			if(nombreOperations != nombreOperationsReference){
				throw new ConcurrentModificationException();
			}
		}
	}

	
}
