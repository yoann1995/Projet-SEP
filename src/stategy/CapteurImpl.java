package stategy;

import java.util.ArrayList;
import java.util.List;
import observer.Capteur;
import observer.ObserverAsync;

public class CapteurImpl implements Capteur {
	
	private int counter;
	private AlgoDiffusion algo;
	private List<ObserverAsync<Capteur>> listObserver;
	
	public CapteurImpl(AlgoDiffusion algo) {
		this.counter = 0;
		this.algo = algo;
		this.listObserver = new ArrayList<ObserverAsync<Capteur>>();
	}
	
	public void setAlgo(AlgoDiffusion algo) {
		this.algo = algo;
	}
	
	public void incCounter() {
		this.counter++;
		System.out.println(counter);
		notifierObservateurs();
	}

	@Override
	public void attach(ObserverAsync<Capteur> o) {
		this.listObserver.add(o);
	}

	@Override
	public void detach(ObserverAsync<Capteur> o) {
		this.listObserver.remove(o);
	}

	@Override
	public void notifierObservateurs() {
		this.algo.execute();
	}

	@Override
	public Integer getValue() {
		return counter;
	}

	public List<ObserverAsync<Capteur>> getListObserver() {
		return listObserver;
	}

	public void setListObserver(List listObserver) {
		this.listObserver = listObserver;
	}
	
	

}
