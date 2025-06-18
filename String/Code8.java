import java.util.Scanner;

public class ArrayIndexDemo
	{
	public static void generateException(String[] names)
	{
        System.out.println("Name: " + names[names.length]); 
	}

    public static void handleException(String[] names) {
        try {
            System.out.println("Name: " + names[names.length]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] names = new String[3];
        for (int i = 0; i < names.length; i++) {
            names[i] = sc.next();
        }
        handleException(names);
	}
}
