package application;

import java.util.concurrent.Future;

import observer.Capteur;
import observer.CapteurAsync;
import observer.ObserverAsync;

public class Canal implements CapteurAsync, ObserverAsync<Capteur> {
	
	private Capteur catpeur;
	private Afficheur afficheur;

	public Canal(Capteur capteur, Afficheur afficheur) {
		this.catpeur = capteur;
		this.afficheur = afficheur;
	}

	@Override
	public Future<Void> update(Capteur subject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Future<Integer> getValue() {
		// TODO Auto-generated method stub
		return null;
	}

}
