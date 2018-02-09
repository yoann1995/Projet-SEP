package stategy;

import java.util.ArrayList;
import java.util.List;

import observer.Capteur;
import observer.ObserverAsync;

/**
 * The Class AlgoDiffusion.
 * 
 * @author Mehidine et Yoann
 */
public abstract class AlgoDiffusion {
	
	/** The capteur. */
	CapteurImpl capteur;
	
	/**
	 * List of all canals
	 */
	protected List<ObserverAsync<Capteur>> list;

	
	/**
	 * Configure.
	 *
	 * @param capteur the capteur
	 */
	public void configure(CapteurImpl capteur) {
		this.capteur = capteur;
		list = new ArrayList<ObserverAsync<Capteur>>();
	}
	
	/**
	 * Execute the algorithm to update each afficheur
	 */
	public abstract void execute();
	
	/**
	 * Warn the algorithm that a given canal get the value
	 * @param canal the canal wich provide the value
	 * @return the value of the counter in the capteur
	 */
	public abstract int getValue(ObserverAsync<Capteur> canal);
	
}
