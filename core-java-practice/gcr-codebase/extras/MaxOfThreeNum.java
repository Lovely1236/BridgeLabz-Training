import java.util.Scanner;
public class MaxOfThreeNum{
    public static int[] takeInput(){    // Method to take input from user
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[3];
        System.out.print("Enter first number: ");
        nums[0] = sc.nextInt();
        System.out.print("Enter second number: ");
        nums[1] = sc.nextInt();
        System.out.print("Enter third number: ");
        nums[2] = sc.nextInt();
        return nums;
    }
    public static int findMaximum(int[] numbers){    // Method to find maximum of three numbers
        int max = numbers[0];
        for(int i = 1;i<numbers.length;i++){
            if(numbers[i]>max){
                max = numbers[i];
            }
        }
        return max;
    }
    public static void main(String[] args){
        int[] nums = takeInput();
        int max = findMaximum(nums);
        System.out.println("Maximum of the three numbers is: " + max);
    }
}
