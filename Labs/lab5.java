import java.util.Scanner;

/**
 * Lab5.java
 * 
 * @author (you)
 * @version (a version number or a date)
 */

public class Lab5 {
    public static void main(String[] args)  {
        
        // Test your methods by calling them here
					
    }
    
    /**
     * getRichQuick
     * 
     * Calculates days to earn $1 million
     */
    public static void getRichQuick() {
        // TODO
        
    }
    
    /**
     * isPrime
     * 
     * Prints a message if a number is prime or not 
     */ 
    public static void isPrime() {
        // TODO

    }
    
    /**
     * palindromeCheck 
     * 
     * This program reads words, identifies, counts and writes all the palindromes and the total
     * palindrome count.
     * 
     * hint 1: Using keybord.next() will only return what comes before a space.
     * hint 2: Using keybord.nextLine() automatically reads the entire current line.
     */
    public static void palindromeCheck(){

        String userInput = ""; // Stores words read from user input
        int palindromeCount = 0;        // Keeps track of palindrome words only 
        int totalWords = 0;        // Counts the total number of lines read from the given text file

        System.out.println("Enter some words separated by white space ");    // Ask for user input
      
        // Declare your Scanner object here
        Scanner keyboard = new Scanner(System.in);

        // for each word user enters
        while (keyboard.hasNext()) {
            userInput = keyboard.next();          // Store each word in a string variable and then do your operations
            totalWords++;                             // Increment number of words as you read each one
            
            // TODO: Call your helper method to check if the word is a palindrome and print the results
           

          
            System.out.println("  " + totalLines + " " + userInput);   // test
        }
    }

    // TODO: Write your helper method for palindromeCheck here
}
