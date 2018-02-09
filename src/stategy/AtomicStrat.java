package stategy;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;

import observer.Capteur;
import observer.ObserverAsync;

/**
 * The Class AtomicStrat.
 * 
 * @author Mehidine et Yoann
 */
public class AtomicStrat extends AlgoDiffusion{
	

	/* (non-Javadoc)
	 * @see stategy.AlgoDiffusion#execute()
	 */
	@Override
	public void execute() {
		this.capteur.setBooleanCanInc(false);
		list = capteur.getListObserver();
		Iterator<ObserverAsync<Capteur>> ite = list.iterator();
		
		while(ite.hasNext()){
			ite.next().update(capteur);
		}
		
	}

	@Override
	public int getValue(ObserverAsync<Capteur> canal) {
		if(list.contains(canal))
			list.remove(canal);

		if(list.isEmpty()){
			//System.out.println("size "+list.size());
			this.capteur.setBooleanCanInc(true);
		}
		return this.capteur.getValue();
	}
	
	

}
