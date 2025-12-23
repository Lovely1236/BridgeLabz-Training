import java.util.Scanner;

public class StudentGrade {
    static int[][] generateScores(int students) {
        int[][] scores = new int[students][3];
        for (int i = 0; i < students; i++) {
            scores[i][0] = 10 + (int) (Math.random() * 91);
            scores[i][1] = 10 + (int) (Math.random() * 91);
            scores[i][2] = 10 + (int) (Math.random() * 91);
        }
        return scores;
    }
    static double[][] calculateResults(int[][] scores) {
        double[][] result = new double[scores.length][4];
        for (int i = 0; i < scores.length; i++) {
            double total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3;
            double percentage = (total / 300) * 100;
            total = Math.round(total * 100.0) / 100.0;
            average = Math.round(average * 100.0) / 100.0;
            percentage = Math.round(percentage * 100.0) / 100.0;
            result[i][0] = total;
            result[i][1] = average;
            result[i][2] = percentage;
        }
        return result;
    }
    static String[] calculateGrades(double[][] result) {
        String[] grades = new String[result.length];

        for (int i = 0; i < result.length; i++) {
            double p = result[i][2];

            if (p >= 80) grades[i] = "A";
            else if (p >= 70) grades[i] = "B";
            else if (p >= 60) grades[i] = "C";
            else if (p >= 50) grades[i] = "D";
            else if (p >= 40) grades[i] = "E";
            else grades[i] = "R";
        }
        return grades;
    }

    static void displayScorecard(int[][] scores, double[][] result, String[] grades) {
        System.out.println("ID\tPhy\tChem\tMath\tTotal\tAvg\t%\tGrade");

        for (int i = 0; i < scores.length; i++) {
            System.out.println(
                (i + 1) + "\t" +
                scores[i][0] + "\t" +
                scores[i][1] + "\t" +
                scores[i][2] + "\t" +
                result[i][0] + "\t" +
                result[i][1] + "\t" +
                result[i][2] + "\t" +
                grades[i]
            );
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int students = sc.nextInt();

        int[][] scores = generateScores(students);
        double[][] result = calculateResults(scores);
        String[] grades = calculateGrades(result);

        displayScorecard(scores, result, grades);

        sc.close();
    }
}