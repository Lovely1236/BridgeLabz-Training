import java.util.*;
public class EduQuiz{
    static int calculateScore(String[] correct,String[] student){
        int score=0;
        for(int i=0;i<correct.length;i++){
            if(student[i].equalsIgnoreCase(correct[i])){
                score++;
            }
        }
        return score;
    }
    public static void main(String[] args){
        Scanner ob=new Scanner(System.in);
        String[] correctAnswers={"A","B","C","D","A","C","B","D","A","B"};
        String[] studentAnswers=new String[10];
        System.out.println("Enter answers for 10 questions (A/B/C/D):");
        for(int i=0;i<10;i++){
            System.out.print("Question "+(i+1)+": ");
            studentAnswers[i]=ob.nextLine();
        }
        int score=calculateScore(correctAnswers,studentAnswers);
        System.out.println("Quiz Feedback:");
        for(int i=0;i<correctAnswers.length;i++){
            if(studentAnswers[i].equalsIgnoreCase(correctAnswers[i])){
                System.out.println("Question "+(i+1)+": Correct");
            }else{
                System.out.println("Question "+(i+1)+": Incorrect");
            }
        }
        double percentage=(score*100.0)/correctAnswers.length;
        System.out.println("Score: "+score+"/"+correctAnswers.length);
        System.out.println("Percentage: "+percentage+"%");
        if(percentage>=50){
            System.out.println("Result: PASS");
        }else{
            System.out.println("Result: FAIL");
        }
    }
}