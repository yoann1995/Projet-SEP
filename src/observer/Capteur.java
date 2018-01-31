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
	public Integer getValue(Canal canal);

	
	public void setBooleanCanInc(boolean bool);

}
