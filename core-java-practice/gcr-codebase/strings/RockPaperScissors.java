import java.util.Scanner;

public class RockPaperScissors {
    static String computerChoice() {
        int num = (int) (Math.random() * 3);
        if (num == 0) return "rock";
        if (num == 1) return "paper";
        return "scissors";
    }
    static String findWinner(String user, String computer) {
        if (user.equals(computer)) return "Draw";
        if (user.equals("rock") && computer.equals("scissors")) return "User";
        if (user.equals("paper") && computer.equals("rock")) return "User";
        if (user.equals("scissors") && computer.equals("paper")) return "User";
        return "Computer";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int games = sc.nextInt();
        int userWin = 0;
        int compWin = 0;
        for (int i = 0; i < games; i++) {
            String user = sc.next();
            String comp = computerChoice();
            String winner = findWinner(user, comp);
            if (winner.equals("User")) userWin++;
            if (winner.equals("Computer")) compWin++;
            System.out.println(user + "\t" + comp + "\t" + winner);
        }
        double userPercent = (userWin * 100.0) / games;
        double compPercent = (compWin * 100.0) / games;
        System.out.println(userWin + "\t" + userPercent);
        System.out.println(compWin + "\t" + compPercent);
        sc.close();
        }
}