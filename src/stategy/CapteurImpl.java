package stategy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import observer.Capteur;
import observer.ObserverAsync;

// TODO: Auto-generated Javadoc
/**
 * The Class CapteurImpl.
 */
public class CapteurImpl implements Capteur {
	
	/** The counter. */
	private int counter;
	
	/** The algo. */
	private AlgoDiffusion algo;
	
	/** The list observer. */
	private List<ObserverAsync<Capteur>> listObserver;
	
	/**
	 * Instantiates a new capteur impl.
	 *
	 * @param algo the algo
	 */
	public CapteurImpl(AlgoDiffusion algo) {
		this.counter = 0;
		this.algo = algo;
		this.listObserver = new ArrayList<ObserverAsync<Capteur>>();
	}
	
	/**
	 * Sets the algo.
	 *
	 * @param algo the new algo
	 */
	public void setAlgo(AlgoDiffusion algo) {
		this.algo = algo;
	}
	
	/**
	 * Inc counter.
	 */
	public void incCounter() {
		this.counter++;
		System.out.println(counter);
		notifierObservateurs();
	}

	/* (non-Javadoc)
	 * @see observer.SubjectAsync#attach(observer.ObserverAsync)
	 */
	@Override
	public void attach(ObserverAsync<Capteur> o) {
		this.listObserver.add(o);
	}

	/* (non-Javadoc)
	 * @see observer.SubjectAsync#detach(observer.ObserverAsync)
	 */
	@Override
	public void detach(ObserverAsync<Capteur> o) {
		this.listObserver.remove(o);
	}

	/* (non-Javadoc)
	 * @see observer.SubjectAsync#notifierObservateurs()
	 */
	@Override
	public void notifierObservateurs() {
		this.algo.execute();
	}

	/* (non-Javadoc)
	 * @see observer.Capteur#getValue()
	 */
	@Override
	public Integer getValue() {
		return counter;
	}

	/**
	 * Gets the list observer.
	 *
	 * @return the list observer
	 */
	public List<ObserverAsync<Capteur>> getListObserver() {
		return listObserver;
	}

	/**
	 * Sets the list observer.
	 *
	 * @param listObserver the new list observer
	 */
	public void setListObserver(List listObserver) {
		this.listObserver = listObserver;
	}

}
