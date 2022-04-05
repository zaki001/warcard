package war2;

import java.util.Random;
import java.util.Scanner;

public class war {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random generator = new Random();
		int menu;
		int randomCard;
		int playerOneScore = 0;
		int playerTwoScore = 0;

		// This is our menu
		for (int i = 0; i < 26; i++) {
			System.out.println("It is player one's turn press 1 to pick a card\npress 2 to quit ");
			menu = scan.nextInt();
			if (menu == 2) {

				System.exit(1);
			} else if (menu == 1) {

			}
			randomCard = generator.nextInt(13) + 1;
			switch (randomCard) {
				case 1: {
					System.out.println("YOU HAVE PICKED AN ACE");
					playerOneScore += 1;
					break;
				}
				case 2: {
					System.out.println("YOU HAVE PICKED TWO");
					playerOneScore += 2;
					break;
				}
				case 3: {
					System.out.println("YOU HAVE PICKED THREE");
					playerOneScore += 3;
					break;
				}
				case 4: {
					System.out.println("YOU HAVE PICKED FOUR");
					playerOneScore += 4;
					break;
				}
				case 5: {
					System.out.println("YOU HAVE PICKED FIVE");
					playerOneScore += 5;
					break;
				}
				case 6: {
					System.out.println("YOU HAVE PICKED SIX");
					playerOneScore += 6;
					break;
				}
				case 7: {
					System.out.println("YOU HAVE PICKED SEVEN");
					playerOneScore += 7;
					break;
				}
				case 8: {
					System.out.println("YOU HAVE PICKED EIGTH");
					playerOneScore += 8;
					break;
				}
				case 9: {
					System.out.println("YOU HAVE PICKED NINE");
					playerOneScore += 9;
					break;
				}
				case 10: {
					System.out.println("YOU HAVE PICKED TEN");
					playerOneScore += 10;
					break;
				}
				case 11: {
					System.out.println("YOU HAVE PICKED JACK");
					playerOneScore += 11;
					break;
				}
				case 12: {
					System.out.println("YOU HAVE PICKED QUEEN");
					playerOneScore += 12;
					break;
				}
				case 13: {
					System.out.println("YOU HAVE PICKED KING");
					playerOneScore += 13;
					break;
				}
			}
			System.out.println("It is player two's turn press 1 to pick a card\npress 2 to quit ");
			menu = scan.nextInt();
			if (menu == 2) {
				System.out.println("PLAYER ONE: " + playerOneScore);
				System.out.println("PLAYER TWO: " + playerTwoScore);
				System.exit(1);
			}
			randomCard = generator.nextInt(13) + 1;
			switch (randomCard) {
				case 1: {
					System.out.println("YOU HAVE PICKED AN ACE");
					playerTwoScore += 1;
					break;
				}
				case 2: {
					System.out.println("YOU HAVE PICKED TWO");
					playerTwoScore += 2;
					break;
				}
				case 3: {
					System.out.println("YOU HAVE PICKED THREE");
					playerTwoScore += 3;
					break;
				}
				case 4: {
					System.out.println("YOU HAVE PICKED FOUR");
					playerTwoScore += 4;
					break;
				}
				case 5: {
					System.out.println("YOU HAVE PICKED FIVE");
					playerTwoScore += 5;
					break;
				}
				case 6: {
					System.out.println("YOU HAVE PICKED SIX");
					playerTwoScore += 6;
					break;
				}
				case 7: {
					System.out.println("YOU HAVE PICKED SEVEN");
					playerTwoScore += 7;
					break;
				}
				case 8: {
					System.out.println("YOU HAVE PICKED EIGTH");
					playerTwoScore += 8;
					break;
				}
				case 9: {
					System.out.println("YOU HAVE PICKED NINE");
					playerTwoScore += 9;
					break;
				}
				case 10: {
					System.out.println("YOU HAVE PICKED TEN");
					playerTwoScore += 10;
					break;
				}
				case 11: {
					System.out.println("YOU HAVE PICKED JACK");
					playerTwoScore += 11;
					break;
				}
				case 12: {
					System.out.println("YOU HAVE PICKED QUEEN");
					playerTwoScore += 12;
					break;
				}
				case 13: {
					System.out.println("YOU HAVE PICKED KING");
					playerTwoScore += 13;
					break;
				}

			}
			System.out.println("PLAYER ONE: " + playerOneScore);
			System.out.println("PLAYER TWO: " + playerTwoScore);

		}
		if (playerOneScore > playerTwoScore) {
			System.out.println("PLAYER ONE WINS");
		} else if (playerOneScore > playerTwoScore) {
			System.out.println("PLAYER ONE WINS");
		} else {
			System.out.println("TIE");
		}

	}
}
