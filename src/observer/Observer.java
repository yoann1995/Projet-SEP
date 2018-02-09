package observer;

/**
 * The Interface Observer.
 *
 * @param <T> the generic type
 * 
 * @author Mehidine et Yoann
 */
public interface Observer<T> {
	
	/**
	 * Update.
	 *
	 * @param subject the subject
	 */
	public void update(T subject);
}
