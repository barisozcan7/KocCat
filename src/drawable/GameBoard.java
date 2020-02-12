//THIS CODE IS MY OWN WORK. I DID NOT CONSULT TO ANY  PROGRAM WRITTEN BY OTHER STUDENTS. 
//I READ AND FOLLOWED THE GUIDELINE GIVEN IN THE PROGRAMMING ASSIGNMENT. NAME: Barýþ Fevzi Özcan
package drawable;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GameBoard extends JPanel implements Drawable{		
	
	public GameBoard() {
	}
	
	public void draw(Graphics g) {
		 int x = 0;
	   	 int y = 0;
	   
	   	for(int i = 0; i<121;i++) {	
	   	 g.setColor(Color.BLUE);
	      	 g.drawRect(x, y,60,60);
	   	 x = x+60;
	   	 if(x==660) {
	   		 x = 0;
	   		 y = y + 60;
	   	 }
	   	}		
	}

	@Override
	public void doAction(Graphics g) {		
	}
    
    
}
