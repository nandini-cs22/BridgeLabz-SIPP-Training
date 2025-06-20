import java.util.Scanner;

class MaxOfThreeNumbers
{
    public static void main(String[] args)
	{
        int num1 = getInput("Enter first number: ");
        int num2 = getInput("Enter second number: ");
        int num3 = getInput("Enter third number: ");

        int max = findMax(num1, num2, num3);
        System.out.println("Maximum number is: " + max);
    }

    static int getInput(String prompt) {
        Scanner sc = new Scanner(System.in);
        System.out.print(prompt);
        return sc.nextInt();
    }

    static int findMax(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    	}
}
