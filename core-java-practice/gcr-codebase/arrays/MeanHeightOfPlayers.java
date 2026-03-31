import java.util.*;
public class MeanHeightOfPlayers {
      
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double totalHeight = 0.0;
        double[] heights = new double[11];
     

        for(int i = 0; i < 11; i++){
            heights[i] = sc.nextDouble();
            totalHeight += heights[i];
        }


        double meanHeight = totalHeight / 11;
        
        System.out.printf("Mean height of the football team is--> %.2f\n", meanHeight);
        sc.close();
    }
}
