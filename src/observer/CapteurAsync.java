package observer;

import java.util.concurrent.Future;

// TODO: Auto-generated Javadoc
/**
 * The Interface CapteurAsync.
 * 
 * @author Mehidine et Yoann
 */
public interface CapteurAsync {
	
	/**
	 * Gets the value (Async way)
	 *
	 * @return the Future who contains the value of counter of a canal
	 */
	public Future<Integer> getValue();
	
}
