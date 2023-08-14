package NumberGuessingGame;


import java.util.*;

public class NumberGuessingGame 
{
	
		static ArrayList<Integer> scoreBoard = new ArrayList<Integer>();

		public static void main(String[] args) {
			NumberGuessingGame methodChange = new NumberGuessingGame();
			methodChange.menu(scoreBoard);
		}

		public void menu(ArrayList<Integer> scoreBoard) {
			NumberGuessingGame methodChange = new NumberGuessingGame();
			Scanner input = new Scanner(System.in);
			System.out.println("*************");
			System.out.println("Welcome to the Number Game");
			System.out.println("Enter 1 For====> To play the Game");
			System.out.println("Enter 2 For====> To view Score Board");
			System.out.println("Enter 3 For====> To exit the game");
			System.out.println("*************");

			try {
				System.out.print("Chosse Number for what action would you like to do : ");
				int menuOption = input.nextInt();
				switch (menuOption) {
				case 1:
					System.out.print("\n" + "What would you like the range of the numbers : ");
					int numberRange = input.nextInt();
					int randomNumber = methodChange.randomNumber(numberRange);
					methodChange.guessNumber(randomNumber);
					break;
				case 2:
					methodChange.displayScoreBoard();
					break;
				case 3:
					System.out.println("\n" + "Thanks for playing the game!");
					System.exit(1);
					break;
				default:
					throw new InputMismatchException("Invalid number entry.Could you please Try again later");
				}
			}
			catch (InputMismatchException e) {
				System.err.println("\n" + e.getMessage() + "\n");
				menu(scoreBoard);
			}
		}

		public int randomNumber(int numberRange) {
			Random random = new Random();
			int randomNumber = random.nextInt(numberRange) + 1;
			return randomNumber;
		}

		public void guessNumber(int randomNumber) {
			Scanner input = new Scanner(System.in);
			int userGuess;
			int guess = 0;
			do {
				System.out.print("Enter your guess number: ");
				userGuess = input.nextInt();
				guess++;
				if (userGuess > randomNumber) {
					System.out.println("Lower");
				} else if (userGuess < randomNumber) {
					System.out.println("Higher");
				}
			} while (randomNumber != userGuess);

			System.out.println(" ");
			if (guess == 1) {
				System.out.println("You answered number is right in " + guess + " try!");
			} else {
				System.out.println("You answered number is right in " + guess + " tries!");
			}
			scoreBoard.add(guess);
			System.out.println(" ");
			menu(scoreBoard);
		}

		public void displayScoreBoard() {
			int marks = 0;
			System.out.println("--------------------");
			System.out.println("Score Board");
			System.out.println("--------------------");
			System.out.println("Your fastest games today out of all tries is: " + "\n");
			Collections.sort(scoreBoard);
			for (Integer scores : scoreBoard) {
				marks = scores;
				System.out.println("Finished the number game in " + scores + " tries");
			}
			switch (marks) {
			case 1:
				System.out.println("You have Secured 100 Marks");
				break;
			case 2:
				System.out.println("You have Secured 90 Marks");
				break;
			case 3:
				System.out.println("You have Secured 80 Marks");
				break;
			case 4:
				System.out.println("You have Secured 70 Marks");
				break;
			case 5:
				System.out.println("You have Secured 60 Marks");
				break;
			case 6:
				System.out.println("You have Secured 50 Marks");
				break;
			case 7:
				System.out.println("You have Secured 40 Marks");
				break;
			case 8:
				System.out.println("You have Secured 30 Marks");
				break;
			case 9:
				System.out.println("You have Secured 20 Marks");
				break;
			case 10:
				System.err.println("You have Secured less than 10 Marks....Please Try again for better Score");
				break;
			default:
				System.err.println("You are failed the Test....Please Try again..........");
				break;
			}
			System.out.println(" ");
			menu(scoreBoard);
		}
	}