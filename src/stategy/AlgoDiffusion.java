package stategy;

import java.util.ArrayList;
import java.util.List;

import observer.Capteur;
import observer.ObserverAsync;

// TODO: Auto-generated Javadoc
/**
 * The Class AlgoDiffusion.
 */
public abstract class AlgoDiffusion {
	
	/** The capteur. */
	CapteurImpl capteur;
	
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
	 * Execute the algorithm to maj each afficheur
	 */
	public abstract void execute();
	
	public abstract int getValue(ObserverAsync<Capteur> canal);
	
}
