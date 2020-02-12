//THIS CODE IS MY OWN WORK. I DID NOT CONSULT TO ANY  PROGRAM WRITTEN BY OTHER STUDENTS. 
//I READ AND FOLLOWED THE GUIDELINE GIVEN IN THE PROGRAMMING ASSIGNMENT. NAME: Barýþ Fevzi Özcan
package drawable;
import java.awt.Color;
import java.util.Random;

public abstract class Food {
      protected int age;
  	  Random random = new Random();
  	  protected int xCoordinate;
  	  protected int yCoordinate;
  	  protected Color color;
  	  private int row; 
      private int column;
  	  
  	  Food(){
  		  this.age = 1;
  		  this.xCoordinate = random.nextInt(11)*60;
  		  this.yCoordinate = random.nextInt(11)*60;
  		  this.setRowColumn();
  	  }      
  	  
  	public static void consumed() {
  		
  	}
      public void setRowColumn() {
  		row = yCoordinate/60;
  		column = xCoordinate/60;
  	}
      public int getAge() {
  		return age;
  	}

  	public void setAge(int age) {
  		this.age = age;
  	}

  	public Random getRandom() {
  		return random;
  	}

  	public void setRandom(Random random) {
  		this.random = random;
  	}

  	public int getxCoordinate() {
  		return xCoordinate;
  	}

  	public void setxCoordinate(int xCoordinate) {
  		this.xCoordinate = xCoordinate;
  	}

  	public int getyCoordinate() {
  		return yCoordinate;
  	}

  	public void setyCoordinate(int yCoordinate) {
  		this.yCoordinate = yCoordinate;
  	}

  	public Color getColor() {
  		return color;
  	}

  	public void setColor(Color color) {
  		this.color = color;
  	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}
}
