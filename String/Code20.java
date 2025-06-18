import java.util.Random;
import java.util.Scanner;

class StudentScoreCard {

    public static int[][] generateRandomScores(int students) {
        Random rand = new Random();
        int[][] scores = new int[students][3];
        for (int i = 0; i < students; i++) {
            scores[i][0] = rand.nextInt(90) + 10; 
            scores[i][1] = rand.nextInt(90) + 10;
            scores[i][2] = rand.nextInt(90) + 10; 
        }
        return scores;
    }

    public static double[][] calculateResults(int[][] scores) {
        int students = scores.length;
        double[][] results = new double[students][3]; 
        for (int i = 0; i < students; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;
            results[i][0] = total;
            results[i][1] = Math.round(average * 100.0) / 100.0;
            results[i][2] = Math.round(percentage * 100.0) / 100.0;
        }
        return results;
    }

    public static String[] calculateGrades(double[][] results) {
        String[] grades = new String[results.length];
        for (int i = 0; i < results.length; i++) {
            double percent = results[i][2];
            if (percent >= 90) grades[i] = "A+";
            else if (percent >= 80) grades[i] = "A";
            else if (percent >= 70) grades[i] = "B+";
            else if (percent >= 60) grades[i] = "B";
            else if (percent >= 50) grades[i] = "C";
            else if (percent >= 40) grades[i] = "D";
            else grades[i] = "F";
        }
        return grades;
    }

    public static void displayScorecard(int[][] scores, double[][] results, String[] grades) {
        System.out.println("Stu\tPhy\tChem\tMath\tTotal\tAvg\t%\tGrade");
        for (int i = 0; i < scores.length; i++) {
            System.out.println((i + 1) + "\t" + scores[i][0] + "\t" + scores[i][1] + "\t" + scores[i][2] + "\t"
                    + (int) results[i][0] + "\t" + results[i][1] + "\t" + results[i][2] + "\t" + grades[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[][] scores = generateRandomScores(n);
        double[][] results = calculateResults(scores);
        String[] grades = calculateGrades(results);
        displayScorecard(scores, results, grades);
       }
}
