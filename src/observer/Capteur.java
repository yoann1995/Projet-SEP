package observer;

import application.Canal;

// TODO: Auto-generated Javadoc
/**
 * The Interface Capteur.
 */
public interface Capteur extends SubjectAsync<Capteur> {
		
	/**
	 * Gets the value of the capteur (counter)
	 *
	 * @return the value
	 */
	public Integer getValue();
	
	/**
	 * Get the value of the capteur for a given canal
	 * @param canal
	 * @return
	 */
	public Integer getValue(Canal canal);

	/**
	 * To set the boolean which will allow to increment or not the counter (helps for the atomic algo)
	 * @param bool
	 */
	public void setBooleanCanInc(boolean bool);

}
