package observer;

public interface Capteur extends SubjectAsync<Capteur> {
		
	public Integer getValue();

}
