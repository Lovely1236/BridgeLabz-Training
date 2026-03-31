import java.util.*;
public class StudentScoreAnalyzer{
    public static void main(String[] args){
        Scanner ob=new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n=ob.nextInt();
        double[] scores=new double[n];
        double sum=0;
        for(int i=0;i<n;i++){
            while(true){
                try{
                    System.out.print("Enter score for student "+(i+1)+": ");
                    double score=ob.nextDouble();
                    if(score<0){
                        System.out.println("Invalid score! Score cannot be negative.");
                        continue;
                    }
                    scores[i]=score;
                    sum+=score;
                    break;
                }catch(Exception e){
                    System.out.println("Invalid input! Please enter a number.");
                    ob.next();
                }
            }
        }
        double average=sum/n;
        double highest=scores[0];
        double lowest=scores[0];
        for(double score:scores){
            if(score>highest)
                highest=score;
            if(score<lowest)
                lowest=score;
        }
        System.out.println("Average Score: "+average);
        System.out.println("Highest Score: "+highest);
        System.out.println("Lowest Score: "+lowest);
        System.out.println("Scores above average:");
        for(double score:scores){
            if(score>average){
                System.out.println(score);
            }
        }
    }
}