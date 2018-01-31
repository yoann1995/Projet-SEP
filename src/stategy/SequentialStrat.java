package stategy;

import java.util.List;

import observer.Capteur;
import observer.ObserverAsync;

// TODO: Auto-generated Javadoc
/**
 * The Class SequentialStrat.
 */
public class SequentialStrat extends AlgoDiffusion{

	/* (non-Javadoc)
	 * @see stategy.AlgoDiffusion#execute()
	 */
	@Override
	public void execute() {
		List<ObserverAsync<Capteur>> list = this.capteur.getListObserver();
		
	}

}
