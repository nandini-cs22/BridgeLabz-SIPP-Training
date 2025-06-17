import java.util.Scanner;

public class StudentGrades
{
	public static void main(String[] args)
	{
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int number = sc.nextInt();

        int[][] marks = new int[number][3]; 
        double[] percentage = new double[number];
        String[] grade = new String[number];

        for (int i = 0; i < number; i++) {
            System.out.println("\nEnter marks for Student " + (i + 1) + ":");

            for (int j = 0; j < 3; j++) {
                String subject = (j == 0) ? "Physics" : (j == 1) ? "Chemistry" : "Maths";

                System.out.print(subject + ": ");
                int mark = sc.nextInt();

                if (mark < 0) {
                    System.out.println("Invalid input. Marks must be positive.");
                    j--; 
                } else {
                    marks[i][j] = mark;
                }
            }

            int total = marks[i][0] + marks[i][1] + marks[i][2];
            percentage[i] = total / 3.0;

            if (percentage[i] >= 90)
                grade[i] = "A";
            else if (percentage[i] >= 80)
                grade[i] = "B";
            else if (percentage[i] >= 70)
                grade[i] = "C";
            else if (percentage[i] >= 60)
                grade[i] = "D";
            else
                grade[i] = "F";
        }

        System.out.println("\nStudent Results:");
        for (int i = 0; i < number; i++) {
            System.out.printf("Student %d -> Physics: %d, Chemistry: %d, Maths: %d, Percentage: %.2f%%, Grade: %s%n",i + 1, marks[i][0], marks[i][1], marks[i][2], percentage[i], grade[i]);
        }
    }
}
