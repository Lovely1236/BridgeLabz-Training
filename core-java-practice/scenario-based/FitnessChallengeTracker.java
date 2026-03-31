import java.util.Scanner;
public class FitnessChallengeTracker{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
         System.out.println("Enter push-ups for each day of the week:");
        System.out.println("(Enter 0 for rest day)");        
        int[] push_Ups = new int[7];
        for(int i = 0;i<7;i++){// Taking input
            System.out.print("Day " + (i + 1) + ": ");
            push_Ups[i] = sc.nextInt();
        }
        int total = 0;
        int workoutD = 0;
        for(int count : push_Ups){          // for-each loop to calculate total and average
            if(count == 0){              // Skip rest days
                continue;
            }
            total += count;
            workoutD++;
        }
        double avg = (workoutD > 0) ? (double) total / workoutD : 0;
        System.out.println("Total push-ups in the week: " + total);
        System.out.println("Average push-ups per workout day: " + avg);
    }
}
