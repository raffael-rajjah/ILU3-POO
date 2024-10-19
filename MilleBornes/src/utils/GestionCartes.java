package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class GestionCartes {
	
	// V1
	public static <E> E extraire(List<E> liste){
		Random random = new Random();
		
		return liste.remove(random.nextInt(liste.size()));
	}
	
	// V2
	public static <E> E extraire2(List<E> liste) {
		
		if (liste == null || liste.isEmpty()) {
            throw new IllegalArgumentException("La liste ne doit pas être nulle ou vide.");
        }

        Random random = new Random();
        int index = random.nextInt(liste.size());

        ListIterator<E> iterator = liste.listIterator();
        E element = null;

        // Avancer l'itérateur jusqu'à l'index désiré
        for (int i = 0; i <= index; i++) {
            element = iterator.next();
        }

        // Supprimer et retourner l'élément à cet index
        iterator.remove();
        return element;
    }
	
	public static <E> List<E> melanger(List<E> liste) {
		List<E> listeMelangee = new ArrayList<>();
		
		while(!liste.isEmpty()) {
			listeMelangee.add(extraire(liste));
		}
		
		return listeMelangee;
	}
	
	public static <E> boolean verifierMelange(List<E> liste1, List<E> liste2) {
        
		// Si les tailles des listes sont différentes, elles ne peuvent pas être égales
        if (liste1.size() != liste2.size()) {
            return false;
        }
        
		for (E e : liste1) {			
			if (Collections.frequency(liste1, e) != Collections.frequency(liste2, e)) {
				return false;
			}
		}
		
		return true;
	}
	
	public static <E> List<E> rassembler(List<E> liste){
		List<E> elementsTraites = new ArrayList<>();
		List<E> listeAssemblee = new ArrayList<>();
		
		for(E element : liste) {
			if(!elementsTraites.contains(element)) {
				for (int i = 0; i < Collections.frequency(liste, element); i++) {
					listeAssemblee.add(element);
				}
				
				elementsTraites.add(element);
			}
		}
		
		return listeAssemblee;
	}
	
	public static <E> boolean verifierRassemblement(List<E> liste) {
		
        ListIterator<E> iterator1 = liste.listIterator();
        ListIterator<E> iterator2;
		
        E elementAvant = liste.getFirst();
        E elementNext;
        
        for (int i = 1; i < liste.size(); i++) {
			if(!liste.get(i).equals(elementAvant)) {
				iterator2 = liste.listIterator(i+1);
				
				while(iterator2.hasNext()) {
					elementNext = iterator2.next();
					if(elementNext.equals(elementAvant)) {
						return false;
					}
				}
				
				elementAvant = liste.get(i);
			}
		}
        
		
		return true;
	}
	
	
	
}
