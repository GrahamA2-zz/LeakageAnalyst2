package uk.co.hydodev.analysis.components;

import java.util.Random;

import javax.swing.JOptionPane;

/**
 * @author Allang
 *
 */
public class App {

	
	
	private static final int MAX_GUESSES = 10;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = JOptionPane.showInputDialog("What is your Name?");
		if (!"".equalsIgnoreCase(name)){
			JOptionPane.showMessageDialog(null, "Hello " + name);
		}
		int i = JOptionPane.showConfirmDialog(null,"Would you like to play a game?");
		if (i == 0)
			playGame(name);
		else
			JOptionPane.showMessageDialog(null, "Bye " + name);
	}

	private static void playGame(String name) {
		Random random = new Random();
		boolean win = false;
		int myNumber = random.nextInt(9) + 1;
		String[] guesses = new String[MAX_GUESSES];
		System.out.println(myNumber);
		for (int guess = 0 ; guess < MAX_GUESSES ; guess++){
			String s = JOptionPane.showInputDialog("What is your Guess?" + prettyPrint(guesses) +"\nYou have " + (MAX_GUESSES - guess) + " guesses left" );
			try {
				int yourGuess = Integer.parseInt(s);
				guesses[guess] = s;
				if (yourGuess == myNumber){
					win = true;
					break;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, s + " is not a number!, try again");
			}			
		}
		if (win){
			JOptionPane.showMessageDialog(null, String.format("Well done %s,  %s was correct", name,myNumber ));
		} else {
			JOptionPane.showMessageDialog(null, String.format("Sorry %s the answer was %s", name,myNumber ));
		}
	}

	private static String prettyPrint(String[] guesses) {
		String s = "\nYou have tried: ";
		for (String g : guesses){
			if (g != null){
				s += g + ",";
			}
		}
		return s.substring(0, s.length()-1);
	}

}
