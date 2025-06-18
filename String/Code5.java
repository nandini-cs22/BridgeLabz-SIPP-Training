import java.util.Scanner;

public class StringIndexDemo
{
	public static void generateException(String text)
	{
        char ch = text.charAt(text.length()); 
        System.out.println("Character: " + ch);
	}
	public static void handleException(String text)
	{
	try
	{
            char ch = text.charAt(text.length());
            System.out.println("Character: " + ch);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught StringIndexOutOfBoundsException: " + e.getMessage());
        }
}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        generateException(input); 
        handleException(input);
    }
}
