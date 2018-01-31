package application;

import java.util.concurrent.Callable;

import observer.Capteur;
import observer.CapteurAsync;
import observer.Observer;
import observer.ObserverAsync;

/**
 * Get the value of the capteur with a calable
 * @author Yoann
 *
 */
public class GetValue implements Callable<Integer>{

	/** The capteur. */
    private Capteur capteur;
    
    /** The canal. */
    private ObserverAsync<Capteur> canal;

    /**
     * Instantiates a new getValue.
     *
     * @param capteur the afficheur
     * @param canal the canal
     */
    public GetValue(Capteur capteur, ObserverAsync<Capteur> canal) {
        this.capteur = capteur;
        this.canal = canal;
    }
	
	@Override
	public Integer call() throws Exception {
    	return capteur.getValue((Canal) canal);
	}

}
