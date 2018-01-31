package stategy;

import java.util.Iterator;
import java.util.List;

import observer.Capteur;
import observer.ObserverAsync;

// TODO: Auto-generated Javadoc
/**
 * The Class SequentialStrat.
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
		System.out.println("SIZE : "+list.size());
		return counter;
	}

}
