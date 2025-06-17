import java.util.Scanner;

public class BonusCalculator 
{
	public static void main(String[] args)
	{
        Scanner sc = new Scanner(System.in);
        double[][] data = new double[10][2];
        double[] bonus = new double[10];
        double[] newSalary = new double[10];
        double totalBonus = 0, totalOldSalary = 0, totalNewSalary = 0;

        for (int i = 0; i < 10; i++) {
            System.out.println("Enter salary and years of service for employee " + (i + 1) + ":");
            double salary = sc.nextDouble();
            double years = sc.nextDouble();
            if (salary <= 0 || years < 0) {
                System.out.println("Invalid input. Please enter again.");
                i--;
                continue;
            }
            data[i][0] = salary;
            data[i][1] = years;
        }

        for (int i = 0; i < 10; i++) {
            double salary = data[i][0];
            double years = data[i][1];
            if (years > 5)
                bonus[i] = salary * 0.05;
            else
                bonus[i] = salary * 0.02;
            newSalary[i] = salary + bonus[i];
            totalBonus += bonus[i];
            totalOldSalary += salary;
            totalNewSalary += newSalary[i];
        }

        System.out.println("Total Bonus Payout: INR " + totalBonus);
        System.out.println("Total Old Salary: INR " + totalOldSalary);
        System.out.println("Total New Salary: INR " + totalNewSalary);
	}
}
