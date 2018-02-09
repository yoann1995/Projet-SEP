package observer;

/**
 * The Interface SubjectAsync.
 *
 * @param <T> the generic type
 * 
 * @author Mehidine et Yoann
 */
public interface SubjectAsync<T> {
	
	/**
	 * Attach a new observer
	 *
	 * @param o the observer to attach
	 */
	public void attach(ObserverAsync<T> o);
	
	/**
	 * Detach a given observer
	 *
	 * @param o the observer to detach
	 */
	public void detach(ObserverAsync<T> o);
	
	/**
	 * Notifier observateurs.
	 */
	public void notifierObservateurs();

}
