package stategy;

import application.CapteurImpl;

public abstract class AlgoDiffusion {
	
	CapteurImpl capteur;
	
	public void configure(CapteurImpl capteur) {
		this.capteur = capteur;
	}
	
	public abstract void execute();
	
}
