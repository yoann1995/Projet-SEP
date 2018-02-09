package observer;

import application.Canal;

// TODO: Auto-generated Javadoc
/**
 * The Interface Capteur.
 * @author Mehidine et Yoann
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
	 * @param canal the canal
	 * @return the value of the canal
	 */
	public Integer getValue(Canal canal);

	/**
	 * To set the boolean which will allow to increment or not the counter (helps for the atomic algo)
	 * @param bool the boolean to know if we can increment or not the counter
	 */
	public void setBooleanCanInc(boolean bool);

}
