import java.util.*;
public class CanVote {
      public static void main(String[] args){
         Scanner sc = new Scanner(System.in);
         int[] ages= new int[10];
         for(int i=0;i<10;i++){
            ages[i]=sc.nextInt();
        }

        // Check voting eligibility for each age
            for(int i=0;i<ages.length;i++){
            if(ages[i]>=18){
               System.out.println("Person "+(i+1)+" can vote.");
            }
            else{
               System.out.println("Person "+(i+1)+" cannot vote.");
            }
         }

         sc.close();
      }
}
