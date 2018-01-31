package observer;


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

}
