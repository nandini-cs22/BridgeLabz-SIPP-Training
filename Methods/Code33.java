import java.util.Scanner;

class NumberChecker
{
	 public static boolean isPerfectNumber(int num)
	{
        int sum = 0;
        for (int i = 1; i <= num / 2; i++)
            if (num % i == 0)
                sum += i;
        return sum == num;
    	}

    public static boolean isAbundantNumber(int num)
	{
        int sum = 0;
        for (int i = 1; i <= num / 2; i++)
            if (num % i == 0)
                sum += i;
        return sum > num;
    	}

    public static boolean isDeficientNumber(int num)
	{
        int sum = 0;
        for (int i = 1; i <= num / 2; i++)
            if (num % i == 0)
                sum += i;
        return sum < num;
    	}

    public static boolean isStrongNumber(int num)
	{
        int sum = 0;
        int original = num;
        while (num > 0) {
            int digit = num % 10;
            sum += factorial(digit);
            num /= 10;
        }
        return sum == original;
    }

    public static int factorial(int n)
	{
        int fact = 1;
        for (int i = 2; i <= n; i++)
            fact *= i;
        return fact;
    	}

    public static void main(String[] args)
	{
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        System.out.println("Is Perfect Number: " + isPerfectNumber(num));
        System.out.println("Is Abundant Number: " + isAbundantNumber(num));
        System.out.println("Is Deficient Number: " + isDeficientNumber(num));
        System.out.println("Is Strong Number: " + isStrongNumber(num));
    	}
}
