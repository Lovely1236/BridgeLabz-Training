import java.util.*;

// Custom Exception
class InvalidQuizSubmissionException extends Exception {
    public InvalidQuizSubmissionException(String message) {
        super(message);
    }
}

public class ResultProcessor {

    // Method to calculate score
    public static int calculateScore(String[] correct, String[] user)
            throws InvalidQuizSubmissionException {

        if (correct.length != user.length) {
            throw new InvalidQuizSubmissionException(
                    "Number of answers does not match number of questions");
        }

        int score = 0;
        for (int i = 0; i < correct.length; i++) {
            if (user[i].equalsIgnoreCase(correct[i])) {
                score++;
            }
        }
        return score;
    }

    // Method to calculate grade
    public static String calculateGrade(int score, int total) {
        double percentage = (score * 100.0) / total;

        if (percentage >= 90) return "A";
        else if (percentage >= 75) return "B";
        else if (percentage >= 50) return "C";
        else return "F";
    }

    public static void main(String[] args) {

        // Correct answers
        String[] answers = {"A", "B", "C", "B"};

        // Users answers
        String[] user1 = {"B", "C", "A", "B"};
        String[] user2 = {"A", "B", "C", "B"};
        String[] user3 = {"A", "B"}; // invalid (length mismatch)

        List<Integer> scores = new ArrayList<>();

        try {
            int score1 = calculateScore(answers, user1);
            scores.add(score1);
            System.out.println("User 1 Score: " + score1 + "/" + answers.length);
            System.out.println("Grade: " + calculateGrade(score1, answers.length));

            int score2 = calculateScore(answers, user2);
            scores.add(score2);
            System.out.println("\nUser 2 Score: " + score2 + "/" + answers.length);
            System.out.println("Grade: " + calculateGrade(score2, answers.length));

            // This will throw exception
            int score3 = calculateScore(answers, user3);
            scores.add(score3);

        } catch (InvalidQuizSubmissionException e) {
            System.out.println("\nError: " + e.getMessage());
        }

        // Display all stored scores
        System.out.println("\nAll Scores Stored: " + scores);
    }
}