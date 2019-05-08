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

	public static void main(String[] arg) {
		play();
	}

	public static int hand() {
		Random rndm = new Random();
		int randomHand = rndm.nextInt(10);
		return deck[randomHand];
	}

	public static void playGame(int p1, int p2) {
		if (p1 > p2) {
			System.out.println("player 1 wins");
		} else {
			System.out.println("player 2 wins");
		}
	}

/// this returns a user input
	public static String userInput() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Would you like to hit, stay or fold");
		String input = scanner.next();
		return input;
	}

	// this is the logic for user input
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

	// this code starts the game with 2 hands and allows you to choose hit
	public static void play() {
		while (p1Hand.size() < 2) {
			p1Hand.add(hand());
			int counter = 0;
			System.out.println("Player 1 card is: " + p1Hand.get(counter));
			counter++;
		}
		while (userInput().equals("hit")) {
			p1Hand.add(hand());
			totalSumOfHand(p1Hand);
			System.out.println("the total of your hand is " + totalSumOfHand(p1Hand));
		}
	}

	// takes all the cards out of p1Hand and returns the sum
	public static int totalSumOfHand(Vector val) {
		int sum = 0;
		for (int i = 0; i < val.size(); i++) {
			sum += (int) val.get(i);
		}
		return sum;
	}

}
