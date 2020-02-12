//THIS CODE IS MY OWN WORK. I DID NOT CONSULT TO ANY  PROGRAM WRITTEN BY OTHER STUDENTS. 
//I READ AND FOLLOWED THE GUIDELINE GIVEN IN THE PROGRAMMING ASSIGNMENT. NAME: Barýþ Fevzi Özcan
package main;
public class Main {	
	private static boolean isInitialized = false;
	private static boolean isAlive = true; 
	private static int highestScore = 0;
	public static void main(String[] args) {
		 Initilization initializer = new Initilization();
		 if(isInitialized) {
			    Game newGame = new Game();
			    newGame.listFiller();			 
		 }
		 
	}
	public static boolean isInitialized() {
		return isInitialized;
	}
	public static void setInitialized(boolean isInitialized) {
		Main.isInitialized = isInitialized;
	}
	public static boolean isAlive() {
		return isAlive;
	}
	public static void setAlive(boolean isAlive) {
		Main.isAlive = isAlive;
	}
	public static int getHighestScore() {
		return highestScore;
	}
	public static void setHighestScore(int highestScore) {
		Main.highestScore = highestScore;
	}	
	
	
}

