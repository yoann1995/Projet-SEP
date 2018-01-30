package application;


import java.util.concurrent.ExecutionException;

import javax.swing.JTextArea;

import observer.CapteurAsync;
import observer.Observer;

public class Afficheur implements Observer<CapteurAsync>{
	
	private JTextArea txtCounter;
	
	
	public Afficheur(JTextArea counter) {
		txtCounter = counter;
	}

	@Override
	public void update(CapteurAsync subject) {
		// TODO Auto-generated method stub
		try {
			txtCounter.setText(subject.getValue().get().toString());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
