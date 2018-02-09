package application;


import observer.Capteur;

import observer.ObserverAsync;

/**
 * Get the value of the capteur with a callable
 * @author Yoann
 *
 */
public class GetValue implements MethodInvocation{

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
	
    /**
     * Method executed by scheduler
     */
	@Override
	public Integer call() throws Exception {
    	return capteur.getValue((Canal) canal);
	}

}
