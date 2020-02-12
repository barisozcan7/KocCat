//THIS CODE IS MY OWN WORK. I DID NOT CONSULT TO ANY  PROGRAM WRITTEN BY OTHER STUDENTS. 
//I READ AND FOLLOWED THE GUIDELINE GIVEN IN THE PROGRAMMING ASSIGNMENT. NAME: Barýþ Fevzi Özcan
package drawable;
import java.awt.Color;
import java.awt.Graphics;

import main.Game;
import main.Main;

public class Poison extends Food implements Drawable{
   public Poison() {
		super();
		color = Color.YELLOW;
	}

	@Override
	public void draw(Graphics g) {		
		g.setColor(color);
		if(this.age <= 10)
		g.fillRect(xCoordinate+(60-age*6)/2, yCoordinate+(60-age*6)/2, age*6, age*6);
		else
		g.fillRect(xCoordinate+(60-10*6)/2, yCoordinate+(60-10*6)/2, 10*6, 10*6);	
	}

	@Override 
	public void doAction(Graphics g) {
		if(age==10) color = Color.RED;
	}
	public static void consumed() {
		for (int j = 0; j<Game.getPoisonList().size(); j++) {
			Poison currentPoison = Game.getPoisonList().get(j);
			if(KocCat.getRow() == currentPoison.getRow() && KocCat.getColumn() == currentPoison.getColumn()) {
				KocCat.setScore(KocCat.getScore() - currentPoison.getAge()*10);
				
				if(KocCat.getScore() > Main.getHighestScore()) {
					Main.setHighestScore(KocCat.getScore());					
				}
				if(!Main.isAlive()) {
					Game.gameOver();
 				}				
				Game.getPoisonList().set(j, new Poison());				
			}
		}
	}
	

}
