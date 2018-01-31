package observer;

import java.util.concurrent.Callable;

// TODO: Auto-generated Javadoc
/**
 * The Interface Capteur.
 */
public interface Capteur extends SubjectAsync<Capteur> {
		
	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public Integer getValue();

}
