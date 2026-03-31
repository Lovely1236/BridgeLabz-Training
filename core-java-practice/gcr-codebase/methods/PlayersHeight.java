import java.util.*;
public class PlayersHeight {
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        int[] height = new int[11];
        Random random = new Random();

        for (int i = 0; i < height.length; i++) {
            // Random height between 150 and 250 (inclusive)
            height[i] = random.nextInt(101) + 150;
        }

        int sum=sum(height);
        System.out.println("Mean :"+mean(sum));
        System.out.println("Shortest height :"+shortest(height));
        System.out.println("Tallest height :"+talllest(height));
        ob.close();
    }
    public static int mean(int sum){
        return sum/11;
    }
    public static int sum(int height[]){
        int sum=0;
        for(int i=0;i<11;i++){
            sum+=height[i];
        }
        return sum;
    }
    public static int talllest(int height[]){
        Arrays.sort(height);
        return height[height.length-1];
    }
    public static int shortest(int height[]){
        Arrays.sort(height);
        return height[0];
    }
}