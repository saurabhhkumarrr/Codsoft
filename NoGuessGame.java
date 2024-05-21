import java.util.Random;
import java.util.Scanner;

public class NoGuessGame {
    private static final int start = 1;
    private static final int end = 100;
    private static int maxAttempts = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Guess number between 1 to 100");
        int score = 0;
        int roundsPlayed = 0;
        String playAgain = "y";

        while (playAgain.equalsIgnoreCase("y")) {
            roundsPlayed++;
            System.out.println("Round " + roundsPlayed);
            int attempts = playGame(scanner);

            if (attempts <= maxAttempts) {
                score += (maxAttempts - attempts + 1);
            }

            System.out.println("Your score: " + score);
            System.out.print("Do you want to play again? (y/n): ");
            playAgain = scanner.next();
        }

        System.out.println("Game over! You played " + roundsPlayed + " rounds with a total score of " + score + ".");
        scanner.close();
    }

    private static int playGame(Scanner scanner) {
        int number = generateNumber(start, end);
        int attempts = 0;

        while (attempts < maxAttempts) {
            int guess = UserGuessed(scanner);
            attempts++;
            String feedback = Feedback(guess, number);
            System.out.println(feedback);

            if (feedback.equals("Correct!")) {
                return attempts;
            }
        }

        System.out.println(
                "Sorry, you've used all " + maxAttempts + " attempts. The correct number was " + number + ".");
        return maxAttempts + 1;
    }

    private static int generateNumber(int rangeStart, int rangeEnd) {
        Random random = new Random();
        return random.nextInt(rangeEnd - rangeStart + 1) + rangeStart;
    }

    private static int UserGuessed(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Enter your guess: ");
                return Integer.parseInt(scanner.next());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer.");
            }
        }
    }

    private static String Feedback(int guess, int number) {
        if (guess < number) {
            return "Too low!";
        } else if (guess > number) {
            return "Too high!";
        } else {
            return "Correct!";
        }
    }
}
