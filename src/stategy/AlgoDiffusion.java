package stategy;

public abstract class AlgoDiffusion {
	
	CapteurImpl capteur;
	
	public void configure(CapteurImpl capteur) {
		this.capteur = capteur;
	}
	
	public abstract void execute();
	
}
