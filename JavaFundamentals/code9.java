import java.util.Scanner;
class Code
{
	public static void main(String[] args)
	{
	Scanner sc = new Scanner(System.in);

        System.out.print("Enter the student fee (INR): ");
        double fee = sc.nextDouble();

        System.out.print("Enter the university discount percent: ");
        double discountPercent = sc.nextDouble();

        double discount = (discountPercent / 100) * fee;
        double finalFee = fee - discount;

        System.out.println("The discount amount is INR " + discount);
        System.out.println("The final discounted fee is INR " + finalFee);
	}
}