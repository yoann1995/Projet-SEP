package observer;

// TODO: Auto-generated Javadoc
/**
 * The Interface SubjectAsync.
 *
 * @param <T> the generic type
 */
public interface SubjectAsync<T> {
	
	/**
	 * Attach a new observer
	 *
	 * @param o
	 */
	public void attach(ObserverAsync<T> o);
	
	/**
	 * Detach a given observer
	 *
	 * @param o
	 */
	public void detach(ObserverAsync<T> o);
	
	/**
	 * Notifier observateurs.
	 */
	public void notifierObservateurs();

}
