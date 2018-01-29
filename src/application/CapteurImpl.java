package application;

import observer.Capteur;
import observer.Observer;
import stategy.AlgoDiffusion;

public class CapteurImpl implements Capteur {
	
	private int counter;
	private AlgoDiffusion algo;
	
	public CapteurImpl(AlgoDiffusion algo) {
		this.counter = 0;
		this.algo = algo;
	}
	
	public void setAlgo(AlgoDiffusion algo) {
		this.algo = algo;
	}
	
	public void incCounter() {
		this.counter++;
	}

	@Override
	public void attach(Observer<Capteur> o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void detach(Observer<Capteur> o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifierObservateurs() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer getValue() {
		return counter;
	}

}
