import java.util.Scanner;
class Code26
{
	public static void main(String[] args)
	{
	Scanner sc = new Scanner(System.in);
        double weight = sc.nextDouble();
        double kg = weight / 2.2;
        System.out.println("The weight of the person in pounds is " + weight + " and in kg is " + kg);
	}
}
