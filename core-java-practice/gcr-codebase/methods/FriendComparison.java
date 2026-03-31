import java.util.*;
public class FriendComparison {
    public static int findYoungest(int[] ages) {
        int index = 0;
        for (int i = 1; i < ages.length; i++) {
            if (ages[i] < ages[index]) {
                index = i;
            }
        }
        return index;
    }
    public static int findTallest(double[] heights) {
        int index = 0;
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > heights[index]) {
                index = i;
            }
        }
        return index;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];
        System.out.println("Enter age and height of friends:");
        for (int i = 0; i < names.length; i++) {
            System.out.print(names[i] + " Age: ");
            ages[i] = sc.nextInt();
            System.out.print(names[i] + " Height (cm): ");
            heights[i] = sc.nextDouble();
        }
        int youngestIndex = findYoungest(ages);
        int tallestIndex = findTallest(heights);
        System.out.println("Youngest Friend: " + names[youngestIndex]);
        System.out.println("Tallest Friend: " + names[tallestIndex]);
        sc.close();
    }
}