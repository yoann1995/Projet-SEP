package application;

import observer.CapteurAsync;
import observer.Observer;

// TODO: Auto-generated Javadoc
/**
 * The Class Update.
 * Update each afficheur in asynchrone way
 * @author Mehidine et Yoann
 */
public class Update implements MethodInvocation {

    /** The afficheur. */
    private Observer<CapteurAsync> afficheur;
    
    /** The canal. */
    private CapteurAsync canal;

    /**
     * Instantiates a new update.
     *
     * @param afficheur the afficheur
     * @param canal the canal
     */
    public Update(Observer<CapteurAsync> afficheur, CapteurAsync canal) {
        this.afficheur = afficheur;
        this.canal = canal;
    }

    /* (non-Javadoc)
     * @see java.util.concurrent.Callable#call()
     */
    /**
     * Method executed by scheduler
     */
    @Override
    public Void call() throws Exception {
    	afficheur.update(canal);
        return null;
    }
}
