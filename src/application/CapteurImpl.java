package application;

import observer.Capteur;
import observer.Observer;

public class CapteurImpl implements Capteur {
	
	private int counter;
	
	public CapteurImpl() {
		this.counter = 0;
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
		// TODO Auto-generated method stub
		return null;
	}

}
