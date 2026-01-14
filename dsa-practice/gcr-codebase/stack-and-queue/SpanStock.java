import java.util.*;
public class SpanStock {
    public static void main(String[] args) {
        Scanner ob = new Scanner(System.in);
        System.out.println("Enter number of days:");
        int n = ob.nextInt();
        int[] prices = new int[n];
        System.out.println("Enter stock prices for " + n + " days:");
        for (int i = 0; i < n; i++) {
            prices[i] = ob.nextInt();
        }
        int[] spans = calculateSpan(prices);
        System.out.println("Stock Spans: " + Arrays.toString(spans));
    }
    public static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] spans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }
            spans[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek());
            stack.push(i);
        }
        System.out.println("Stock Spans: " + Arrays.toString(spans));
        return spans;
    }
}