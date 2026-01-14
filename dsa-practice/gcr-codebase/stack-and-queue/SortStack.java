import java.util.*;
public class SortStack {
    public static void sortStack(Stack<Integer>stack){
        if(stack.isEmpty()){
            return;
        }
        int topElement=stack.pop();
        sortStack(stack);
        insertTopElement(stack,topElement);
    }
    public static void insertTopElement(Stack<Integer>Stack,int value){
        if(Stack.isEmpty()||Stack.peek()<=value){
            Stack.push(value);
            return;
        }
        int topElement=Stack.pop();
        insertTopElement(Stack,value);
        Stack.push(topElement);
    }
    public static void main(String[] args) {
        Scanner ob = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        System.out.println("Enter number of elements to push onto stack:");
        int n = ob.nextInt();
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            stack.push(ob.nextInt());
        }
        System.out.println("Stack before sorting: " + stack);
        sortStack(stack);
        System.out.println("Stack after sorting: " + stack);
    }
}