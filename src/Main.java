import java.util.Random; // import random and scanner for user inputs and random number generation
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // declare/initialize random functionality for dice
        Random rnd = new Random();

        // declare/initialize scanner for user input to play again
        Scanner userPlaysAgain = new Scanner(System.in);

        // declare variable to determine if user wants to play again
        boolean playAgain = false;
        // declare variable to set "the point"
        int thePoint = 0;
        // declare variable to sum up subsequent rolls
        int subsequentCrapsRoll = 0;

        do {
            // declare and set up the two dice for rolling
            int die1 = rnd.nextInt(6) + 1; // each dice is bounded to a range of 1-6
            int die2 = rnd.nextInt(6) + 1;

            // declare variable to sum up the two dice rolls
            int crapsRoll = die1 + die2; // 2-12 total

            // checks if sum is 2, 3, or 12, which results in loss or crapping out
            if (crapsRoll == 2 || crapsRoll == 3 || crapsRoll == 12) {
                // output the sum and declares loss
                System.out.println("Your dice rolls were: " + die1 + " and " + die2);
                System.out.println("Your sum is: " + crapsRoll);
                System.out.println("You are crapping out!");
                System.out.println("You have lost!");
            } else if (crapsRoll == 7 || crapsRoll == 11) {
                // checks if the sum is 7 or 11, which results in win or natural
                // output the sum and declare win
                System.out.println("Your dice rolls were: " + die1 + " and " + die2);
                System.out.println("Your sum is: " + crapsRoll);
                System.out.println("This is a natural! You have won!");
            } else {
                // set the point at the sum of the dice rolls
                thePoint = crapsRoll;
                // print out the roll and indicate that it is point now
                System.out.println("Your dice rolls were: " + die1 + " and " + die2);
                System.out.println("Total was: " + crapsRoll + " and is now the point.");
                // while loop to keep rolling until win/loss
                while (subsequentCrapsRoll != thePoint) {

                    // output trying for point
                    System.out.println("Trying for point.");
                    // initialize new dice for subsequent rolls
                    int die3 = rnd.nextInt(6) + 1; // each dice is bounded to a range of 1-6
                    int die4 = rnd.nextInt(6) + 1;

                    // add up the sum of the new dice rolls
                    subsequentCrapsRoll = die3 + die4;

                    // output the dice roll and result
                    System.out.println("Your dice rolls were: " + die3 + " and " + die4);
                    System.out.println("Total was: " + subsequentCrapsRoll);

                    if (subsequentCrapsRoll == 7) {
                        // if roll results in 7, display that the user lost and break out of the loop
                        System.out.println("You got a 7 and lost.");
                        break;
                    }

                    if (subsequentCrapsRoll == thePoint) {
                        System.out.println("You made point and won.");
                        // if roll results in the point being made then display that they made point, win, and break out of loop
                        break;
                    }
                }

            }

            // output and ask user if they would want to play again
            boolean validResponse = false;
            do {
                System.out.println("Would you like to play again/continue? [Yes/No]: ");
                String response = userPlaysAgain.nextLine();
                if (response.equalsIgnoreCase("Yes")) {
                    // set flags/variables to true to continue the game
                    validResponse = true;
                    playAgain = true;
                } else if (response.equalsIgnoreCase("No")) {
                    // set flag/variable to false ot break the loop and end game
                    validResponse = true;
                    playAgain = false;
                } else {
                    // if user provides anything that is not yes or no, print invalid response error and rerun
                    System.out.println("You have provided an invalid response. Please enter Yes or No.");
                }
            } while (!validResponse);

        } while (playAgain);
    }
}
