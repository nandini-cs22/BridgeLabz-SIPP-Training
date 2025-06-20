import java.util.Scanner;
import java.util.Random;

class NumberGuessingGame
{
    public static void main(String[] args)
	{
        Scanner sc = new Scanner(System.in);
        int low = 1, high = 100;
        boolean correct = false;

        while (!correct && low <= high) {
            int guess = generateGuess(low, high);
            System.out.println("Is your number " + guess + "? (enter: low, high, correct)");
            String feedback = sc.nextLine().trim().toLowerCase();

            if (feedback.equals("low")) {
                low = guess + 1;
            } else if (feedback.equals("high")) {
                high = guess - 1;
            } else if (feedback.equals("correct")) {
                System.out.println("Yay! The computer guessed your number: " + guess);
                correct = true;
            } else {
                System.out.println("Invalid input. Please enter: low, high, or correct.");
            }
        }

        if (!correct) {
            System.out.println("There was an issue with the guesses or feedback.");
        }
    }

    static int generateGuess(int low, int high) {
        Random rand = new Random();
        return rand.nextInt(high - low + 1) + low;
    	}
}
