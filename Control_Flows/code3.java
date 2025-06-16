import java.util.Scanner;
class Divisible3
{
	public static void main(String[] args)
	{
	Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        boolean isDivisible = number % 5 == 0;

        System.out.println("Is the number " + number + " divisible by 5? " + isDivisible);
	}
}