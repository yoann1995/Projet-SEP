package observer;

import java.util.concurrent.Future;

// TODO: Auto-generated Javadoc
/**
 * The Interface ObserverAsync.
 *
 * @param <T> the generic type
 */
public interface ObserverAsync<T> {

	/**
	 * Update.
	 *
	 * @param subject the subject
	 * @return the future
	 */
	Future<Void> update(T subject);
}
