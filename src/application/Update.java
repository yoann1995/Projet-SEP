package application;

import java.util.concurrent.Callable;

import observer.CapteurAsync;
import observer.Observer;

public class Update implements Callable<Void> {

    private Observer<CapteurAsync> afficheur;
    private CapteurAsync canal;

    public Update(Observer<CapteurAsync> afficheur, CapteurAsync canal) {
        this.afficheur = afficheur;
        this.canal = canal;
    }

    @Override
    public Void call() throws Exception {
    	afficheur.update(canal);
        return null;
    }
}
