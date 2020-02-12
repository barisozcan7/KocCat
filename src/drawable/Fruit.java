//THIS CODE IS MY OWN WORK. I DID NOT CONSULT TO ANY  PROGRAM WRITTEN BY OTHER STUDENTS. 
//I READ AND FOLLOWED THE GUIDELINE GIVEN IN THE PROGRAMMING ASSIGNMENT. NAME: Barýþ Fevzi Özcan
package drawable;
import java.awt.Color;
import java.awt.Graphics;

import main.Game;
import main.Main;

public class Fruit extends Food implements Drawable{
	
	public Fruit() {
		super();
		this.color = Color.BLUE;
	}
	
	@Override
	public void doAction(Graphics g) {
		if(age>=5) this.color = Color.GREEN;		
	}
	
	@Override
	public void draw(Graphics g) {		
		g.setColor(this.color);
		g.fillOval(this.xCoordinate+(60-age*6)/2, this.yCoordinate+(60-age*6)/2, age*6, age*6);		
	}
	
	public static void consumed() {
		for (int i = 0; i<Game.getFruitList().size();i++) {
			Fruit currentFruit = Game.getFruitList().get(i);	                 
			if(KocCat.getRow() == currentFruit.getRow() && KocCat.getColumn() == currentFruit.getColumn()) {
				KocCat.setScore(KocCat.getScore() + currentFruit.getAge()*5);
				if(KocCat.getScore() > Main.getHighestScore()) {
					Main.setHighestScore(KocCat.getScore());
				}
				Game.getFruitList().set(i, new Fruit());
			}
	}
	}
}
