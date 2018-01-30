package stategy;

import java.util.List;

import observer.Capteur;
import observer.ObserverAsync;

public class SequentialStrat extends AlgoDiffusion{

	@Override
	public void execute() {
		List<ObserverAsync<Capteur>> list = this.capteur.getListObserver();
		for(ObserverAsync<Capteur> c : list){
			c.update(capteur);
		}
	}

}
