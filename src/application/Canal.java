package application;

import observer.Capteur;

public class Canal {
	
	private Capteur catpeur;
	private Afficheur afficheur;

	public Canal(Capteur capteur, Afficheur afficheur) {
		this.catpeur = capteur;
		this.afficheur = afficheur;
	}

}
