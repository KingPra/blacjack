package blackjack;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

/**
 * Create a basic Blackjack game that gets as close to 21 as possible without
 * going over. User receives 2 cards
 * 
 * @author King Pra;
 * @version 1.0;
 */

/* Create an array to simulate the deck */
public class Blackjack {
	static int deck[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
	static Vector compHand = new Vector();
	static Vector p1Hand = new Vector();
//	ArrayList<Integer> p1Hand = new ArrayList<Integer>();

	
	// all methods that need to be called should be put into main method
	public static void main(String[] arg) {
		//compHand(); // uncomment this function to test computer hand.
		play();  // this method needs to be called to start the game.
	}
	
	
// this method returns a random hand
	public static int hand() {
		Random rndm = new Random();
		int randomHand = rndm.nextInt(10);
		return deck[randomHand];
	}

	
	// this method compares 2 hands and prints out the player
	// we need to pass in the total of player hand and the total of computer hand as arguments.
	public static void playGame(int p1, int p2) {
		if (p1 > p2) {
			System.out.println("player 1 wins");
		} else {
			System.out.println("player 2 wins");
		}
	}

/// this returns a user input
	// this should be passed into userLogic as an argument.
	public static String userInput() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Would you like to hit, stay or fold");
		String input = scanner.next();
		return input;
	}

	// this is the logic for user input
	// the userInput method should be used as an argument.
	public static String userLogic(String value) {
		if (value.equalsIgnoreCase("hit")) {
			p1Hand.add(hand());
			totalSumOfHand(p1Hand);
			return "hit";
		} else {
			System.out.println("you chose something else");
			return "you chose a different path";
		}
	}

	// this code starts the game with 2 hands for the player and allows you to choose hit
	public static void play() {
		// this line makes sure the player starts the game with 2 cards.
		while (p1Hand.size() < 2) {
			p1Hand.add(hand()); // this pushes a card to the p1Hand vector.
		}
		System.out.println("Player 1 cards : " + p1Hand);
		while (userInput().equals("hit")) {
			p1Hand.add(hand());
			totalSumOfHand(p1Hand);
			System.out.println("the total of your hand is " + totalSumOfHand(p1Hand));
		}
		// logic for "stay" should trigger computer's full hand to display and should compare player's hand to computers' hand
		// and print out a winner. - the playGame() method will compare 2 hands.
		//
		// logic for "fold" should end the game and should print out the computer as the winner.
	}

	// takes all the cards out of p1Hand and returns the sum
	public static int totalSumOfHand(Vector val) {
		int sum = 0;
		for (int i = 0; i < val.size(); i++) {
			sum += (int) val.get(i);
		}
		return sum;
	}
	
	
	// gives the dealer cards until the sum is at least 17;
	public static void compHand() {
		// this pushes a single card to the dealer hand, starts the dealer with one card
		compHand.add(hand());
		// as long as the total sum of the dealer hand is less than 17, the dealer should 
		// get another card pushed into the compHand vector.
		while(totalSumOfHand(compHand) < 18) {
			
			compHand.add(hand()); // this pushes a card to the compHand vector.
			
			System.out.println("comphand is " + compHand); // this print out is mainly for testing.
		}  
		
			System.out.println("end of dealer hand statement");// this comment is here for testing only.
	}

}
