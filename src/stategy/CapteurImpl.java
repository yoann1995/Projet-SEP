package stategy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import application.Canal;
import observer.Capteur;
import observer.ObserverAsync;

// TODO: Auto-generated Javadoc
/**
 * The Class CapteurImpl.
 */
public class CapteurImpl implements Capteur {
	
	private boolean canTick = true;
	
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
		if(canTick){
			this.counter++;
			System.out.println(counter);
			notifierObservateurs();
		}
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
		List<ObserverAsync<Capteur>> ret = new ArrayList<ObserverAsync<Capteur>>();
		Iterator ite = this.listObserver.iterator();
		while(ite.hasNext()){
			ret.add((ObserverAsync<Capteur>) ite.next());
		}
		
		return ret;
	}

	/**
	 * Sets the list observer.
	 *
	 * @param listObserver the new list observer
	 */
	public void setListObserver(List listObserver) {
		this.listObserver = listObserver;
	}
	
	public Integer getValue(Canal canal){
		return this.algo.getValue(canal);
	}
	
	public void setBooleanCanInc(boolean bool){
		canTick = true;
	}

}
