package observer;

import java.util.concurrent.Future;

// TODO: Auto-generated Javadoc
/**
 * The Interface CapteurAsync.
 */
public interface CapteurAsync {
	
	/**
	 * Gets the value (Async way)
	 *
	 * @return Future<Integer>
	 */
	public Future<Integer> getValue();
	
}
