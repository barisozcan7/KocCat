//THIS CODE IS MY OWN WORK. I DID NOT CONSULT TO ANY  PROGRAM WRITTEN BY OTHER STUDENTS. 
//I READ AND FOLLOWED THE GUIDELINE GIVEN IN THE PROGRAMMING ASSIGNMENT. NAME: Barýþ Fevzi Özcan
package drawable;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import main.Main;

public class KocCat implements Drawable {
	private static int numberOfFruits;
	private static int numberOfPoisons;
	private static int numberOfGhosts;
	private static int score = 0;
	private static int xCoordinate = 300;
	private static int yCoordinate = 300;
	private static String direction = "right";
    ImageIcon icon = new ImageIcon(direction + ".png");
    private static int row;
    private static int column;

	
	public KocCat(int currentScore,int x,int y,boolean isAlive,int fruits,int poisons, int ghosts) {
		super();		
		numberOfFruits = fruits;
		numberOfPoisons = poisons;
		numberOfGhosts = ghosts;	
		setScore(currentScore);
		this.setxCoordinate(x);
        this.setyCoordinate(y);	
        this.setRowColumn();
	}
	
	public static void setScore(int currentScore) {
		score = currentScore;
		if(currentScore < 0) {
			Main.setAlive(false);
		}
	}
	
	public static int getScore() {
		return score;
	}
	public void setRowColumn() {
		row = (yCoordinate+30)/60;
  		column =(xCoordinate+30)/60;
	}
	
	 public ImageIcon loadImageIcon(String direction) {
         icon = new ImageIcon(direction + ".png");
         return icon;
     }
	
	
	public void draw(Graphics g) {	
		g.drawImage(loadImageIcon(direction).getImage(),xCoordinate,yCoordinate,null);
		
	}
	
	public void doAction(Graphics g) {
		if(direction == "right" && xCoordinate <=600) {
			xCoordinate = xCoordinate+6;		
		}
		if(direction == "up" && yCoordinate >=0) {
			yCoordinate = yCoordinate-6;			
		}
		if(direction == "down" && yCoordinate <=600) {
			yCoordinate = yCoordinate+6;			
		}
		if(direction == "left" && xCoordinate >=0) {
			xCoordinate = xCoordinate-6;			
		}
		setRowColumn();
				
	}
	
	public static void setDirection(String currentDirection) {
		direction = currentDirection;
	}
	public static int getxCoordinate() {
		return xCoordinate;
	}

	public void setxCoordinate(int currentxCoordinate) {
		xCoordinate = currentxCoordinate;
	}

	public static int getyCoordinate() {
		return yCoordinate;
	}

	public void setyCoordinate(int currentyCoordinate) {
		yCoordinate = currentyCoordinate;
	}
	
	public static String getDirection() {
		return direction;
	}

	public static int getNumberOfFruits() {
		return numberOfFruits;
	}

	public static int getNumberOfPoisons() {
		return numberOfPoisons;
	}

	public static int getNumberOfGhosts() {
		return numberOfGhosts;
	}
	public static int getRow() {
		return row;
	}
	public static int getColumn() {
		return column;
	}

	
	

	
}
