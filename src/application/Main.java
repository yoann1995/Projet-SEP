package application;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import stategy.AlgoDiffusion;
import stategy.AtomicStrat;
import stategy.CausualStrat;
import stategy.SequentialStrat;

public class Main implements ActionListener{

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
	JTextArea[] counters;
	
	private AlgoDiffusion algorithm;
	
	private CapteurImpl capteur;
	private boolean loop = false;
	
	public static void main(String[] args) {
		new Main();
	}

	public Main(){
		fenetre = new JFrame();
	    fenetre.setVisible(true);
	    GridLayout layout = new GridLayout(3,3);
	    fenetre.setLayout(layout);
	    addButton();
	    addDisplay();
	    
	    capteur = new CapteurImpl();
	}
	
	private void startLoop() {
		new Thread(){
	          public void run() {
	              try{
	            	  while(loop) {
		                  Thread.sleep(1000);
		                  capteur.incCounter();
	            	  }
	              } catch(InterruptedException v){System.out.println(v);}
	          }
	      };
	}

	private void addDisplay() {
		counter1 = new JTextArea("0");
		fenetre.add(counter1);
		counter2 = new JTextArea("0");
		fenetre.add(counter2);
		counter3 = new JTextArea("0");
		fenetre.add(counter3);
		counter4 = new JTextArea("0");
		fenetre.add(counter4);
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
		}else if(source==causualButton){
			algorithm = new CausualStrat();
		}else if(source==sequentialButton){
			algorithm = new SequentialStrat();
		}else if(source==run){
			loop=true;
			startLoop();
		}else if(source==stop){
			loop=false;
		}
		
	}

}
