//THIS CODE IS MY OWN WORK. I DID NOT CONSULT TO ANY  PROGRAM WRITTEN BY OTHER STUDENTS. 
//I READ AND FOLLOWED THE GUIDELINE GIVEN IN THE PROGRAMMING ASSIGNMENT. NAME: Barýþ Fevzi Özcan
package main;
import javax.swing.JOptionPane;

public class Initilization {
	private static int fruitNumber;
	private static int poisonNumber;
	private static int ghostNumber;
     
	public Initilization() {
		try {
			initialize();
			Main.setInitialized(true); 
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,e.getMessage() + " Game won't start!", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
	
private static void initialize() throws Exception {
	String fruits = 
	         JOptionPane.showInputDialog("Enter the number of fruits which will appear on the game screen: ");
	isValid(fruits);
	String poisons = 
	         JOptionPane.showInputDialog("Enter the number of poisons which will appear on the game screen: ");
	isValid(poisons);
	String ghosts = 
	         JOptionPane.showInputDialog("Enter the number of ghosts which will appear on the game screen: ");
	isValid(ghosts);
	fruitNumber = Integer.parseInt(fruits);
	poisonNumber = Integer.parseInt(poisons);
	ghostNumber = Integer.parseInt(ghosts);	
}

public static boolean isInteger(String s) {
    try { 
        Integer.parseInt(s); 
    } catch(NumberFormatException e) { 
        return false; 
    } catch(NullPointerException e) {
        return false;
    }
    return true;
}

public static void isValid(String s) throws Exception {
	if(!isInteger(s)) throw new Exception("Invalid numbers!");
	if(Integer.parseInt(s) <=0) throw new Exception("Numbers should be larger than 0!");	
}

public static int getFruitNumber() {
	return fruitNumber;
}

public static int getPoisonNumber() {
	return poisonNumber;
}

public static int getGhostNumber() {
	return ghostNumber;
}


}