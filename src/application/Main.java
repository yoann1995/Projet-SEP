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
import stategy.CapteurImpl;
import stategy.EpoqueStrat;
import stategy.SequentialStrat;

// TODO: Auto-generated Javadoc
/**
 * The Class Main.
 * We implement the view, the listener of this view and the scheudler which will generate a tick every seconds to the capteur
 */
public class Main implements ActionListener,Runnable{

	/** The fenetre. */
	JFrame fenetre;
	
	/** The atomic button. */
	JButton atomicButton;
	
	/** The causual button. */
	JButton epoqueButton;
	
	/** The sequential button. */
	JButton sequentialButton;
	
	/** The run. */
	JButton run;
	
	/** The stop. */
	JButton stop;
	
	/** The counter 1. */
	JTextArea counter1;
	
	/** The counter 2. */
	JTextArea counter2;
	
	/** The counter 3. */
	JTextArea counter3;
	
	/** The counter 4. */
	JTextArea counter4;
	
	/** The given algorithm. */
	private AlgoDiffusion algorithm;
	
	/** The capteur of the application. */
	private CapteurImpl capteur;
	
	/** Boolean to stop or not the scheduler. */
	private boolean loop = false;
	
	/** The scheduler of the app. */
	private ScheduledExecutorService scheduler;
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		new Main();
	}

	/**
	 * Instantiates a new main.
	 * Instantiate the frame, the scheduler and buttons.
	 */
	public Main(){
	    this.scheduler = Executors.newScheduledThreadPool(20);
	    capteur = new CapteurImpl(this.algorithm);

		fenetre = new JFrame();
	    fenetre.setVisible(true);
	    GridLayout layout = new GridLayout(2,5);
	    fenetre.setLayout(layout);
	    addButton();
	    addDisplay();
	    
	    scheduler.scheduleAtFixedRate(this, 1000, 1000, TimeUnit.MILLISECONDS);
	}

	/**
	 * Adds the displays.
	 * They are link to the afficheur with the canal
	 */
	private void addDisplay() {
		counter1 = new JTextArea("0");
		fenetre.add(counter1);
		capteur.attach(new Canal(capteur,counter1,1000,scheduler));
		
		counter2 = new JTextArea("0");
		fenetre.add(counter2);
		capteur.attach(new Canal(capteur,counter2,2000,scheduler));
		
		counter3 = new JTextArea("0");
		fenetre.add(counter3);
		capteur.attach(new Canal(capteur,counter3,3000,scheduler));

		counter4 = new JTextArea("0");
		fenetre.add(counter4);
		capteur.attach(new Canal(capteur,counter4,4000,scheduler));
		
	}

	/**
	 * Adds the button of the app with their listener.
	 */
	private void addButton() {
		atomicButton = new JButton("Atomic");
		fenetre.add(atomicButton);
		atomicButton.addActionListener(this);
		
		epoqueButton = new JButton("Epoque");
		fenetre.add(epoqueButton);
		epoqueButton.addActionListener(this);
		
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

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if(source==atomicButton){
			algorithm = new AtomicStrat();
			algorithm.configure(capteur);
			capteur.setAlgo(algorithm);
		}else if(source==epoqueButton){
			algorithm = new EpoqueStrat();
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

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		if(loop){
			capteur.incCounter();
		}
	}

}
