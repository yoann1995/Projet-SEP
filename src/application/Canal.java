package application;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JTextArea;

import observer.Capteur;
import observer.CapteurAsync;
import observer.ObserverAsync;

// TODO: Auto-generated Javadoc
/**
 * Pattern proxy
 * Link between afficheur and capteur
 *
 * @author yoann
 */
public class Canal implements CapteurAsync, ObserverAsync<Capteur> {
	
	/** Capteur of the application. */
	private Capteur capteur;
	
	/** Afficheur associated to the canal. */
	private Afficheur afficheur;
	
	/** Uniq delay for the canal. */
	private int delay;
	
	/** Uniq scheduler of the application */
	private ScheduledExecutorService scheduler;

	/**
	 * Instantiates a new canal.
	 *
	 * @param capteur the capteur
	 * @param text the text
	 * @param delay the delay
	 * @param scheduler the scheduler
	 */
	public Canal(Capteur capteur,JTextArea text, int delay, ScheduledExecutorService scheduler) {
		this.capteur = capteur;
		this.afficheur = new Afficheur(text);
		this.delay = delay;
		this.scheduler = scheduler;
	}

	/* (non-Javadoc)
	 * @see observer.ObserverAsync#update(java.lang.Object)
	 */
	@Override
	public Future<Void> update(Capteur subject) {
		return scheduler.schedule(new Update(afficheur, this), 10, TimeUnit.MILLISECONDS);
	}

	/* (non-Javadoc)
	 * @see observer.CapteurAsync#getValue()
	 */
	@Override
	public Future<Integer> getValue() {
		return scheduler.schedule(new GetValue(capteur, this), delay, TimeUnit.MILLISECONDS);
	}

}
