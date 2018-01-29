package observer;

public interface Capteur extends Subject<Capteur> {
		
	public Integer getValue();

}
