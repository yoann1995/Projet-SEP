package application;


import javax.swing.JTextArea;

import observer.Capteur;
import observer.ObserverDeCapteur;

public class Afficheur implements ObserverDeCapteur{
	
	private JTextArea txtCounter;
	
	
	public Afficheur(JTextArea counter1) {
		txtCounter = counter1;
	}

	@Override
	public void update(Capteur subject) {
		txtCounter.setText(subject.getValue().toString());
	}

}
