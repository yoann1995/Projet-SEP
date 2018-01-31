package stategy;

// TODO: Auto-generated Javadoc
/**
 * The Class AlgoDiffusion.
 */
public abstract class AlgoDiffusion {
	
	/** The capteur. */
	CapteurImpl capteur;
	
	/**
	 * Configure.
	 *
	 * @param capteur the capteur
	 */
	public void configure(CapteurImpl capteur) {
		this.capteur = capteur;
	}
	
	/**
	 * Execute.
	 */
	public abstract void execute();
	
}
