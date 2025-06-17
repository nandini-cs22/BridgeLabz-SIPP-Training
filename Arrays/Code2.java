import java.util.Scanner;

public class NumberAnalysis {
    public static void main(String[] args) {
        int[] numbers = new int[5];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }


        for (int num : numbers) {
            if (num > 0) {
                if (num % 2 == 0) {
                    System.out.println("The number " + num + " is positive and even.");
                } else {
                    System.out.println("The number " + num + " is positive and odd.");
                }
            } else if (num < 0) {
                System.out.println("The number " + num + " is negative.");
            } else {
                System.out.println("The number is zero.");
            }
        }

        int first = numbers[0];
        int last = numbers[numbers.length - 1];

        System.out.println("Comparison of First and Last Elements");

        if (first == last) {
            System.out.println("The first and last elements are equal.");
        } else if (first > last) {
            System.out.println("The first element (" + first + ") is greater than the last element (" + last + ").");
        } else {
            System.out.println("The first element (" + first + ") is less than the last element (" + last + ").");
        }

        scanner.close();
    }
}
