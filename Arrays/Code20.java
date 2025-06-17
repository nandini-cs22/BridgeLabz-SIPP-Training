import java.util.Scanner;

public class DigitFrequency
{
	public static void main(String[] args)
	{
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        long number = sc.nextLong();

        int digitCount = String.valueOf(Math.abs(number)).length();
        int[] digits = new int[digitCount];
        int index = 0;
        long temp = Math.abs(number); 

        while (temp > 0) {
            digits[index++] = (int)(temp % 10);
            temp /= 10;
        }
        int[] frequency = new int[10]; // index 0–9 for digits 0–9

        for (int i = 0; i < digitCount; i++) {
            frequency[digits[i]]++;
        }

        System.out.println("\nDigit Frequencies:");
        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0) {
                System.out.println("Digit " + i + ": " + frequency[i] + " time(s)");
            }
        }
    }
}
