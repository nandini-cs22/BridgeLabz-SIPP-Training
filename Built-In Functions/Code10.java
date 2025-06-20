import java.util.Scanner;

class FactorialRecursive
{
    public static void main(String[] args)
	{
        int number = getInput();
        long result = factorial(number);
        displayResult(number, result);
    	}

    static int getInput()
	{
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        return sc.nextInt();
    	}

    static long factorial(int n)
	{
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    	}

    static void displayResult(int number, long result)
	{
        System.out.println("Factorial of " + number + " is: " + result);
    	}
}
