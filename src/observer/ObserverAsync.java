package observer;

import java.util.concurrent.Future;
/**
 * The Interface ObserverAsync.
 *
 * @param <T> the generic type
 * 
 * @author Mehidine et Yoann
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
