import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int totalRounds = 3;
        int round = 1;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (round <= totalRounds) {
            System.out.println("\nRound " + round);
            int targetNumber = random.nextInt(100) + 1;
            int attempts = 0;

            while (true) {
                System.out.print("Guess the number (1 to 100): ");
                int guessedNumber = scanner.nextInt();
                attempts++;

                if (guessedNumber == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    int roundScore = calculateScore(attempts);
                    score += roundScore;
                    System.out.println("Round Score: " + roundScore);
                    break;
                } else if (guessedNumber < targetNumber) {
                    System.out.println("The number is higher. Try again.");
                } else {
                    System.out.println("The number is lower. Try again.");
                }

                if (attempts == 5) {
                    System.out.println("You have reached the maximum number of attempts. The correct number was: " + targetNumber);
                    break;
                }
            }

            round++;
        }

        System.out.println("\nGame Over!");
        System.out.println("Total Score: " + score);
        scanner.close();
    }

    public static int calculateScore(int attempts) {
        int baseScore = 100;
        int score = 0;

        if (attempts == 1) {
            score = baseScore;
        } else if (attempts == 2) {
            score = baseScore / 2;
        } else if (attempts == 3) {
            score = baseScore / 3;
        } else if (attempts == 4) {
            score = baseScore / 4;
        } else {
            score = 0;
        }

        return score;
    }
}

