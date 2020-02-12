//THIS CODE IS MY OWN WORK. I DID NOT CONSULT TO ANY  PROGRAM WRITTEN BY OTHER STUDENTS. 
//I READ AND FOLLOWED THE GUIDELINE GIVEN IN THE PROGRAMMING ASSIGNMENT. NAME: Barýþ Fevzi Özcan
package main;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import drawable.Fruit;
import drawable.GameBoard;
import drawable.Ghost;
import drawable.KocCat;
import drawable.Poison;

@SuppressWarnings("serial")
public class Game extends JPanel implements KeyListener, ActionListener {
	public static JFrame gameWindow = new JFrame();
	private KocCat cat = new KocCat(0, KocCat.getxCoordinate(), KocCat.getyCoordinate(), true,
			Initilization.getFruitNumber(), Initilization.getPoisonNumber(), Initilization.getGhostNumber());
	private GameBoard board = new GameBoard();
	private static ArrayList<Fruit> fruitList = new ArrayList<Fruit>();
	private static ArrayList<Poison> poisonList = new ArrayList<Poison>();
	private static ArrayList<Ghost> ghostList = new ArrayList<Ghost>();
	private JLabel scoreLabel = new JLabel("Score: " + KocCat.getScore()); 
	public static int timer_ticks;    
	static Timer timer;

	public Game() {		
		 gameInitializer();
		 timerInitializer();
	}
	
	public void gameInitializer() {
		gameWindow.add(this);
		gameWindow.setSize(680, 710);
		gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameWindow.setVisible(true);
		gameWindow.setResizable(false);
		gameWindow.setTitle("KocCat");
		gameWindow.setLocationRelativeTo(null);
		gameWindow.add(scoreLabel, BorderLayout.SOUTH);
		this.addKeyListener(this);
		this.setFocusable(true);
	}
	public void timerInitializer() {
		 timer = new Timer(100, new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					timer_ticks++;						
					for (int i = 0; i < fruitList.size(); i++) {
						if (fruitList.get(i).getAge() < 10 && timer_ticks%10 == 0)
							
							fruitList.get(i).setAge(fruitList.get(i).getAge()+1);
					}
					for (int i = 0; i < poisonList.size(); i++) {	
						if(timer_ticks%10 == 0)						
						    poisonList.get(i).setAge(poisonList.get(i).getAge()+1);
					}
					collision();
					foodDies();
					scoreLabel.setText("Score: " + KocCat.getScore());					
					repaint();
				}
			});

			timer.start();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		board.draw(g);
		for (int i = 0; i < fruitList.size(); i++) {
			fruitList.get(i).draw(g);
			fruitList.get(i).doAction(g);

		}
		for (int i = 0; i < poisonList.size(); i++) {
			poisonList.get(i).draw(g);
			poisonList.get(i).doAction(g);

		}
		for (int i = 0; i < ghostList.size(); i++) {
			ghostList.get(i).draw(g);
			ghostList.get(i).doAction(g);
		}
		cat.draw(g);
		cat.doAction(g);        
	}

	@Override
	public void keyPressed(KeyEvent key) {
		if (key.getKeyCode() == KeyEvent.VK_RIGHT && KocCat.getDirection() != "right") {
			KocCat.setDirection("right");
			repaint();
		}
		if (key.getKeyCode() == KeyEvent.VK_UP && KocCat.getDirection() != "up") {
			KocCat.setDirection("up");
			repaint();
		}
		if (key.getKeyCode() == KeyEvent.VK_LEFT && KocCat.getDirection() != "left") {
			KocCat.setDirection("left");
			repaint();
		}
		if (key.getKeyCode() == KeyEvent.VK_DOWN && KocCat.getDirection() != "down") {
			KocCat.setDirection("down");
			repaint();
		}
	}

	public void listFiller() {
		int ghostCounter = 0;
		for (int i = 0; i < KocCat.getNumberOfFruits(); i++) {
			fruitList.add(new Fruit());
		}
		for (int i = 0; i < KocCat.getNumberOfPoisons(); i++) {
			poisonList.add(new Poison());
		}
		for(int i = 0; i< KocCat.getNumberOfGhosts(); i++) {
			if(ghostCounter%3 == 0) ghostList.add(new Ghost("Ash"));
			if(ghostCounter%3 == 1) ghostList.add(new Ghost("Dolly"));
			if(ghostCounter%3 == 2) ghostList.add(new Ghost("Casper"));
			ghostCounter++;
		}
	}

	public void collision() {
		Fruit.consumed();
		Poison.consumed();
			for (int k = 0; k<ghostList.size(); k++) {
				Ghost currentGhost = ghostList.get(k);
				if(KocCat.getRow() == currentGhost.getRow() && KocCat.getColumn() == currentGhost.getColumn()) {
					gameOver();
				}
			}				
	}
	
	public void foodDies() {
		for (int i = 0; i<fruitList.size();i++) {
			Fruit currentFruit = fruitList.get(i);
			if(currentFruit.getAge() == 10) {
				fruitList.set(i, new Fruit());
			}
		}
	}
	public static void gameOver() {
		gameWindow.setFocusable(false);
		JOptionPane.showMessageDialog(gameWindow, "Game over. Your highest score during the game:" + Main.getHighestScore());
		gameWindow.dispose();
		timer.stop();
		}	

	public static ArrayList<Fruit> getFruitList() {
		return fruitList;
	}

	public static ArrayList<Poison> getPoisonList() {
		return poisonList;
	}

	public static ArrayList<Ghost> getGhostList() {
		return ghostList;
	}	

	@Override
	public void actionPerformed(ActionEvent arg0) {
}

	@Override
	public void keyReleased(KeyEvent arg0) {
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}

}
