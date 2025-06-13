import java.util.Scanner;
class Prgm3
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the temp in Celsius");
		int temp1 = sc.nextInt();
		double finalTemp = (temp1*1.8)+32;
		System.out.println(finalTemp);
	}
}		