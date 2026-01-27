package review;
import java.util.Scanner;
public class StackDemo {
    private int top;
    private int size;
    private int[] stack;
    StackDemo(int size) {
        this.size = size;
        stack = new int[size];
        top = -1;
    }
    void push(int value) {
        if (top == size - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        stack[++top] = value;
        System.out.println(value + " pushed into stack");
    }
    int pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return stack[top--];
    }
    int peek() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return -1;
        }
        return stack[top];
    }

    void display() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.println("Stack elements:");
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter stack size: ");
        int size = sc.nextInt();
        StackDemo s = new StackDemo(size);
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println("Top element: " + s.peek());
        System.out.println("Popped element: " + s.pop());
        s.display();
        sc.close();
    }
}
