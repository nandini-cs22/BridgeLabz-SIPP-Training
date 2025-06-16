import java.util.Scanner;
class Code20
{
	public static void main(String[] args)
	{
	Scanner sc = new Scanner(System.in);

        System.out.print("Enter your salary (INR): ");
        double salary = sc.nextDouble();

        System.out.print("Enter your bonus (INR): ");
        double bonus = sc.nextDouble();

        double totalIncome = salary + bonus;

        System.out.println("The salary is INR " + salary + " and the bonus is INR " + bonus + 
                           ". Hence Total Income is INR " + totalIncome);
	}
}