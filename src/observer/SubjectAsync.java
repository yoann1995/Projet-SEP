package observer;

// TODO: Auto-generated Javadoc
/**
 * The Interface SubjectAsync.
 *
 * @param <T> the generic type
 */
public interface SubjectAsync<T> {
	
	/**
	 * Attach.
	 *
	 * @param o the o
	 */
	public void attach(ObserverAsync<T> o);
	
	/**
	 * Detach.
	 *
	 * @param o the o
	 */
	public void detach(ObserverAsync<T> o);
	
	/**
	 * Notifier observateurs.
	 */
	public void notifierObservateurs();

}
