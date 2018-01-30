package application;

import java.util.concurrent.Callable;
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
	private ScheduledExecutorService scheduler;

	public Canal(Capteur capteur,JTextArea text, int delay, ScheduledExecutorService scheduler) {
		this.capteur = capteur;
		this.afficheur = new Afficheur(text);
		this.delay = delay;
		this.scheduler = scheduler;
	}

	@Override
	public Future<Void> update(Capteur subject) {
		return scheduler.schedule(new Update(afficheur, this), 10, TimeUnit.MILLISECONDS);
	}

	@Override
	public Future<Integer> getValue() {
		return scheduler.schedule(new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				return capteur.getValue();
			}
		}, delay, TimeUnit.MILLISECONDS);
	}

}
