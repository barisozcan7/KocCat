//THIS CODE IS MY OWN WORK. I DID NOT CONSULT TO ANY  PROGRAM WRITTEN BY OTHER STUDENTS. 
//I READ AND FOLLOWED THE GUIDELINE GIVEN IN THE PROGRAMMING ASSIGNMENT. NAME: Barýþ Fevzi Özcan
package drawable;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.ImageIcon;


public class Ghost implements Drawable{
	private  String direction = "left";
	private  String name = "";
	private static Random random = new Random();
 	private int xCoordinate;
 	private int yCoordinate;
 	private ImageIcon icon = new ImageIcon(name + ".png");
 	private int row;
  	private int column;
  	private int randomDirection = random.nextInt(4); 

	
	public Ghost(String ghostName) {
		super();
		this.name = ghostName;
		this.xCoordinate = random.nextInt(11)*60;
		this.yCoordinate = random.nextInt(11)*60;
		if(name == "Ash"||name == "Casper") this.direction = "left";
		if(name == "Dolly") this.direction = "up";
		this.setRowColumn();

	}
	
	public ImageIcon loadImageIcon(String ghostImage) {
        icon = new ImageIcon(name + ".png");
        return icon;
    }

	@Override
	public void draw(Graphics g) {
		g.drawImage(loadImageIcon(name).getImage(),xCoordinate,yCoordinate,null);
		
	}

	@Override
	public void doAction(Graphics g) {
      if(name == "Ash") {
    	  ashMovement(); 
      }
      if(name == "Dolly") {
    	  dollyMovement();
      }
      if(name == "Casper") {    	  
    	  casperMovement();
      }
      this.setRowColumn();
	}
	public void setRowColumn() {
		row = (yCoordinate+30)/60;
  		column =(xCoordinate+30)/60;
	}
	
	private void ashMovement() {
		if(direction == "left" && xCoordinate >0) {
  			xCoordinate = xCoordinate-6;			
  		}
    	  if(direction == "left" && xCoordinate == 0) {
    		  direction = "right";
    	  }
    	  if(direction == "right" && xCoordinate <600) {
  			xCoordinate = xCoordinate+6;		
  		}
    	  if(direction == "right" && xCoordinate == 600) {
    		  direction = "left";
    	  }
	}
	private void dollyMovement() {
		if(direction == "up" && yCoordinate >0) {
  			yCoordinate = yCoordinate-6;  			
  		}
      	  if(direction == "up" && yCoordinate == 0) {
      		  direction = "down";
      	  }
      	if(direction == "down" && yCoordinate <600) {
			yCoordinate = yCoordinate+6;			
		}
      	  if(direction == "down" && yCoordinate == 600) {
      		  direction = "up";
      	  }
	}
	private void casperMovement() {		
		if(xCoordinate >= 60 && xCoordinate % 60 == 0 && yCoordinate >= 60 && yCoordinate % 60 == 0 ) {
			 randomDirection = random.nextInt(4);
		}
		if(xCoordinate < 10 ) {		
			randomDirection = 1;
		}
		if(yCoordinate < 10 ) {
			randomDirection = 3;
		}		
		 if(randomDirection == 0) {
			 direction = "left";
			 ashMovement();
		 }		
		 else if(randomDirection == 1 ) {
			 direction = "right";
			 ashMovement();
		 }
		 else if(randomDirection == 2) {
			 direction = "up";
			 dollyMovement();
		 }		 
		 else if(randomDirection == 3) {
			 direction = "down";
			 dollyMovement();
		 }
		 	}
   public int getRow() {
	   return this.row;
   }
   public int getColumn() {
	   return this.column;
   }
	
       
	
	
}
