import java.util.Scanner;
class Code4
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		 System.out.print("Enter your height in cm: ");
       		 double cm = sc.nextDouble();

	         double totalInches = cm / 2.54;

        	int feet = (int)(totalInches / 12);
       		 double inches = totalInches % 12;

        
        	System.out.printf("Your height in cm is %.2f cm, in feet is %d feet and %.2f inches\n", cm, feet, inches);
	}
}