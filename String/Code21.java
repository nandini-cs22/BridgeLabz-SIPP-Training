import java.util.Scanner;

class BMICalculator
{
	public static double calculateBMI(double weight, double heightCm)
	{
        double heightM = heightCm / 100.0;
        return Math.round((weight / (heightM * heightM)) * 100.0) / 100.0;
        }

    public static String getStatus(double bmi) {
        if (bmi < 18.5) return "Underweight";
        else if (bmi < 25) return "Normal";
        else if (bmi < 30) return "Overweight";
        else return "Obese";
    }

    public static String[][] computeBMIandStatus(double[][] hwData) {
        String[][] result = new String[hwData.length][4];
        for (int i = 0; i < hwData.length; i++) {
            double weight = hwData[i][0];
            double height = hwData[i][1];
            double bmi = calculateBMI(weight, height);
            String status = getStatus(bmi);

            result[i][0] = String.valueOf(height);
            result[i][1] = String.valueOf(weight);
            result[i][2] = String.valueOf(bmi);
            result[i][3] = status;
        }
        return result;
    }

    public static void displayBMIReport(String[][] report) {
        System.out.println("Person\tHeight(cm)\tWeight(kg)\tBMI\t\tStatus");
        for (int i = 0; i < report.length; i++) {
            System.out.println((i + 1) + "\t" + report[i][0] + "\t\t" + report[i][1] + "\t\t" + report[i][2] + "\t\t" + report[i][3]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] hwData = new double[10][2];

        for (int i = 0; i < 10; i++) {
            System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");
            hwData[i][0] = sc.nextDouble();

            System.out.print("Enter height (cm) for person " + (i + 1) + ": ");
            hwData[i][1] = sc.nextDouble();
        }

        String[][] bmiReport = computeBMIandStatus(hwData);
        displayBMIReport(bmiReport);
       }
}
