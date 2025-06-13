import java.util.Scanner;
class Prgm6
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your principle amount");
		int principle = sc.nextInt();
		System.out.println("Enter the rate");
		int rate = sc.nextInt();
		System.out.println("Enter the time");
		int time = sc.nextInt();
		double SI = (principle*rate* time)/100;
		System.out.println(SI);
	}
}