package stategy;

import java.util.List;

import observer.Capteur;
import observer.ObserverAsync;

// TODO: Auto-generated Javadoc
/**
 * The Class CausualStrat.
 */
public class EpoqueStrat extends AlgoDiffusion{

	/* (non-Javadoc)
	 * @see stategy.AlgoDiffusion#execute()
	 */
	@Override
	public void execute() {
		List<ObserverAsync<Capteur>> list = this.capteur.getListObserver();
		for(ObserverAsync<Capteur> c : list){
			c.update(capteur);
		}
	}

	@Override
	public int getValue(ObserverAsync<Capteur> canal) {
		// TODO Auto-generated method stub
		return capteur.getValue();
	}

}
