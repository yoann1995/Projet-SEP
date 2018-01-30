package application;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JTextArea;

import observer.Capteur;
import observer.CapteurAsync;
import observer.ObserverAsync;

public class Canal implements CapteurAsync, ObserverAsync<Capteur> {
	
	private Capteur capteur;
	private Afficheur afficheur;
	private int delay;

	public Canal(Capteur capteur,JTextArea text, int delay) {
		this.capteur = capteur;
		this.afficheur = new Afficheur(text);
		this.delay = delay;
	}

	@Override
	public Future<Void> update(Capteur subject) {
	    ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
		return scheduler.schedule(new Callable<Void>() {

			@Override
			public Void call() throws Exception {
			  	afficheur.update(subject);
		        return null;
			}
		}, delay, TimeUnit.MILLISECONDS);
	}

	@Override
	public Future<Integer> getValue() {
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
		return scheduler.schedule(new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				return capteur.getValue();
			}
		}, delay, TimeUnit.MILLISECONDS);
	}

}
