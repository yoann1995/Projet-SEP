package stategy;

import java.util.Iterator;
import java.util.List;

import observer.Capteur;
import observer.ObserverAsync;

/**
 * The Class SequentialStrat.
 * 
 * @author Mehidine et Yoann
 */
public class SequentialStrat extends AlgoDiffusion{

	private int counter;
	
	/* (non-Javadoc)
	 * @see stategy.AlgoDiffusion#execute()
	 */
	@Override
	public void execute() {
		if(list.isEmpty()){		
			this.counter = this.capteur.getValue();
			list = this.capteur.getListObserver();
			Iterator<ObserverAsync<Capteur>> ite = list.iterator();
			
			while(ite.hasNext()){
				ite.next().update(capteur);
			}
		}
	}

	@Override
	public int getValue(ObserverAsync<Capteur> canal) {
		if(list.contains(canal))
			list.remove(canal);
		return counter;
	}

}
