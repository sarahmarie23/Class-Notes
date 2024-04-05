import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        /*
        1. Statement: "Guess a number between 1 and 50"
        2. Get the answer from the player
        3. Check if the answer is higher, lower, or correct
        4. The result is given to the player. 
        5. If its higher or lower, player guesses again.
        6. If the result is correct, display "Correct!" with the amount of guesses.
        */
        int numberToGuess = 35;
        int playerGuess;

        printStatement();
        playerGuess = getPlayerGuess();
    }
    public static void printStatement() {
        // Statement: "Guess a number between 1 and 50"
        System.out.println("Guess a number between 1 and 50");
    }
    public static int getPlayerGuess() {
        // Get the answer from the player
        Scanner input = new Scanner(System.in);
        int guess = input.nextInt();    
        System.out.println("You guessed " + guess);
        input.close();

        return guess;
    }
    public static void checkGuess(int playerGuess, int numberToGuess) {
        // Check if the answer is higher, lower, or correct

    }
}