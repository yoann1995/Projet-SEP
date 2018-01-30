package stategy;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;

import observer.Capteur;
import observer.ObserverAsync;

public class AtomicStrat extends AlgoDiffusion{

	@Override
	public void execute() {
		List<ObserverAsync<Capteur>> o = capteur.getListObserver();
		Iterator<ObserverAsync<Capteur>> ite = o.iterator();
		
		while(ite.hasNext()){
			try {
				ite.next().update(capteur).get();
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
