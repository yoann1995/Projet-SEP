package application;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import stategy.AlgoDiffusion;
import stategy.AtomicStrat;
import stategy.CausualStrat;
import stategy.SequentialStrat;

public class Main implements ActionListener,Runnable{

	JFrame fenetre;
	JButton atomicButton;
	JButton causualButton;
	JButton sequentialButton;
	JButton run;
	JButton stop;
	
	JTextArea counter1;
	JTextArea counter2;
	JTextArea counter3;
	JTextArea counter4;
	
	private AlgoDiffusion algorithm;
	
	private CapteurImpl capteur;
	private boolean loop = false;
	
	public static void main(String[] args) {
		new Main();
	}

	public Main(){
	    capteur = new CapteurImpl(this.algorithm);

		fenetre = new JFrame();
	    fenetre.setVisible(true);
	    GridLayout layout = new GridLayout(3,3);
	    fenetre.setLayout(layout);
	    addButton();
	    addDisplay();
	    
	    ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
	    scheduler.scheduleAtFixedRate(this, 1000, 1000, TimeUnit.MILLISECONDS);
	}

	private void addDisplay() {
		counter1 = new JTextArea("0");
		fenetre.add(counter1);
		capteur.attach(new Canal(capteur,counter1,100));
		
		counter2 = new JTextArea("0");
		fenetre.add(counter2);
		capteur.attach(new Canal(capteur,counter2,200));
		
		counter3 = new JTextArea("0");
		fenetre.add(counter3);
		capteur.attach(new Canal(capteur,counter3,300));

		counter4 = new JTextArea("0");
		fenetre.add(counter4);
		capteur.attach(new Canal(capteur,counter4,400));
		
	}

	private void addButton() {
		atomicButton = new JButton("Atomic");
		fenetre.add(atomicButton);
		atomicButton.addActionListener(this);
		
		causualButton = new JButton("Causual");
		fenetre.add(causualButton);
		causualButton.addActionListener(this);
		
		sequentialButton = new JButton("Sequential");
		fenetre.add(sequentialButton);
		sequentialButton.addActionListener(this);
		
		run = new JButton("Run");
		fenetre.add(run);
		run.addActionListener(this);
	
		stop = new JButton("Stop");
		fenetre.add(stop);
		stop.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if(source==atomicButton){
			algorithm = new AtomicStrat();
			algorithm.configure(capteur);
			capteur.setAlgo(algorithm);
		}else if(source==causualButton){
			algorithm = new CausualStrat();
			algorithm.configure(capteur);
			capteur.setAlgo(algorithm);
		}else if(source==sequentialButton){
			algorithm = new SequentialStrat();
			algorithm.configure(capteur);
			capteur.setAlgo(algorithm);
		}else if(source==run){
			loop=true;
		}else if(source==stop){
			loop=false;
		}
		
	}

	@Override
	public void run() {
		if(loop){
			capteur.incCounter();
		}
	}

}
