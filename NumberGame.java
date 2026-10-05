// package classroom.internship;

import java.util.Scanner;
import java.util.Random;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int totalRounds = 0;
        int roundsWon = 0;
        int totalAttemptsTaken = 0;

        System.out.println("========================================");
        System.out.println("       WELCOME TO THE NUMBER GAME       ");
        System.out.println("========================================");

        boolean playAgain = true;

        while (playAgain) {
            totalRounds++;
        
            int minRange = 1;
            int maxRange = 100;
            int generatedNumber = random.nextInt(maxRange - minRange + 1) + minRange;

        
            int maxAttempts = 7;
            int attempts = 0;
            boolean hasGuessedCorrectly = false;

            System.out.println("\n--- Round " + totalRounds + " ---");
            System.out.println("I have chosen a number between " + minRange + " and " + maxRange + ".");
            System.out.println("You have a maximum of " + maxAttempts + " attempts to guess it.");

            while (attempts < maxAttempts) {
            
                System.out.print("Enter your guess (Attempt " + (attempts + 1) + "/" + maxAttempts + "): ");
                int userGuess;

            
                if (scanner.hasNextInt()) {
                    userGuess = scanner.nextInt();
                } else {
                    System.out.println("Invalid input! Please enter a valid integer.");
                    scanner.next(); 
                    continue;
                }

                attempts++;
                totalAttemptsTaken++;

                
                if (userGuess == generatedNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    hasGuessedCorrectly = true;
                    roundsWon++;
                    break;
                } else if (userGuess > generatedNumber) {
                    System.out.println("Too high! Try a lower number.");
                } else {
                    System.out.println("Too low! Try a higher number.");
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println("Game Over for this round! You ran out of attempts.");
                System.out.println("The correct number was: " + generatedNumber);
            }

        
            System.out.print("\nDo you want to play another round? (yes/no): ");
            String response = scanner.next().trim().toLowerCase();
            if (!response.equals("yes") && !response.equals("y")) {
                playAgain = false;
            }
        }

        
        System.out.println("\n========================================");
        System.out.println("               FINAL SCORE              ");
        System.out.println("========================================");
        System.out.println("Total Rounds Played : " + totalRounds);
        System.out.println("Rounds Won          : " + roundsWon);
        System.out.println("Total Attempts Made : " + totalAttemptsTaken);

        
        int score = (roundsWon * 100) - (totalAttemptsTaken * 5);
        if (score < 0)
            score = 0; 

        System.out.println("Your Final Score    : " + score);
        System.out.println("Thanks for playing! Goodbye.");

        scanner.close();
    }
}
