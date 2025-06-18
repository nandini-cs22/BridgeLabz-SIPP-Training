import java.util.Scanner;

public class IllegalArgumentDemo
{

    public static void generateException(String text)
	{
        String result = text.substring(5, 2);
        System.out.println("Substring: " + result);
	}

    public static void handleException(String text) {
        try {
            String result = text.substring(5, 2); // Start index > end index
            System.out.println("Substring: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        handleException(input);
    }
}
