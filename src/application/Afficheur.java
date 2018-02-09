package application;


import java.util.concurrent.ExecutionException;

import javax.swing.JTextArea;

import observer.CapteurAsync;
import observer.Observer;

/**
 * Obsever of capteurAsync.
 *
 * @author yoann et Mehidine
 */
public class Afficheur implements Observer<CapteurAsync>{
	
	/** Graphic text which will be modifiate. */
	private JTextArea txtCounter;
	
	/**
	 * Constructor of Afficheur
	 *
	 * @param counter the counter
	 */
	public Afficheur(JTextArea counter) {
		txtCounter = counter;
	}

	/* (non-Javadoc)
	 * @see observer.Observer#update(java.lang.Object)
	 */
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
