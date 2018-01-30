package application;


import javax.swing.JTextArea;

import observer.Capteur;
import observer.CapteurAsync;
import observer.Observer;
import observer.ObserverDeCapteur;

public class Afficheur implements Observer<CapteurAsync>{
	
	private JTextArea txtCounter;
	
	
	public Afficheur(JTextArea counter1) {
		txtCounter = counter1;
	}

//	@Override
//	public void update(Capteur subject) {
//		txtCounter.setText(subject.getValue().toString());
//	}

	@Override
	public void update(CapteurAsync subject) {
		// TODO Auto-generated method stub
		txtCounter.setText(subject.getValue().toString());
	}

}
