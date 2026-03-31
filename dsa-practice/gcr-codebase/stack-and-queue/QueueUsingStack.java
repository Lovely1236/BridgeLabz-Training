import java.util.*;
public class QueueUsingStack{
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        Stack<Integer>enqueueStack=new Stack<>();
        Stack<Integer>dequeueStack=new Stack<>();
        boolean loop=true;
        while(loop){
            System.out.println("Enter 1 to add element to queue");
            System.out.println("Enter 2 to remove element from queue");
            System.out.println("Enter 3 to display elements of queue");
            System.out.println("Enter 0 to exit");
            int choice=ob.nextInt();
            switch(choice){
                case 1:
                    System.out.println("Enter element:");
                    int element=ob.nextInt();
                    enqueue(enqueueStack,element);
                    break;
                case 2:
                    dequeue(enqueueStack,dequeueStack);
                    break;
                case 3:
                    displayQueue(enqueueStack,dequeueStack);
                    break;
                case 0:
                    loop=false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
    public static void enqueue(Stack<Integer>enqueueStack,int element){
        enqueueStack.push(element);
        System.out.println("Inserted: "+element);
    }
    public static void dequeue(Stack<Integer>enqueueStack,Stack<Integer>dequeueStack){
        if(enqueueStack.isEmpty()&&dequeueStack.isEmpty()){
            System.out.println("Queue is empty");
            return;
        }
        if(dequeueStack.isEmpty()){
            while(!enqueueStack.isEmpty()){
                dequeueStack.push(enqueueStack.pop());
            }
        }
        System.out.println("Removed: "+dequeueStack.pop());
    }
    public static void displayQueue(Stack<Integer>enqueueStack,Stack<Integer>dequeueStack){
        if(enqueueStack.isEmpty()&&dequeueStack.isEmpty()){
            System.out.println("Queue is empty");
            return;
        }
        System.out.print("Queue elements: ");
        for(int i=dequeueStack.size()-1;i>=0;i--){
            System.out.print(dequeueStack.get(i)+" ");
        }
        for(int i=0;i<enqueueStack.size();i++){
            System.out.print(enqueueStack.get(i)+" ");
        }
        System.out.println();
    }
}