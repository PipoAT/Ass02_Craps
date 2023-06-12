import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // declare/initialize random functionality for dice
        Random rnd = new Random();

        // declare/initialize scanner for user input to play again
        Scanner userPlaysAgain = new Scanner(System.in);

        // declare variable to determine if user wants to play again
        boolean playAgain = false;

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
                // for now, fix this, display case iii
                System.out.println("Your dice rolls were: " + die1 + " and " + die2);
                System.out.println("Total was: " + crapsRoll);
            }

            // output and ask user if they would want to play again
            boolean validResponse = false;
            do {
                System.out.println("Would you like to play again/continue? [Yes/No]: ");
                String response = userPlaysAgain.nextLine();
                if (response.equalsIgnoreCase("Yes")) {
                    validResponse = true;
                    playAgain = true;
                } else if (response.equalsIgnoreCase("No")) {
                    validResponse = true;
                    playAgain = false;
                } else {
                    System.out.println("You have provided an invalid response. Please enter Yes or No.");
                }
            } while (!validResponse);

        } while (playAgain);
    }
}
