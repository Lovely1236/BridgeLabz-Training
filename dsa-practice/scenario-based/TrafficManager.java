package scenario_based;
import java.util.*;
class VehicleNode{
    String vehicleNumber;
    VehicleNode next;
    VehicleNode(String vehicleNumber){
        this.vehicleNumber=vehicleNumber;
        this.next=null;
    }
}
class Roundabout{
    private VehicleNode head=null;
    public void addVehicle(String vehicleNumber){
        VehicleNode newNode=new VehicleNode(vehicleNumber);
        if(head==null){
            head=newNode;
            newNode.next=head;
        }else{
            VehicleNode temp=head;
            while(temp.next!=head){
                temp=temp.next;
            }
            temp.next=newNode;
            newNode.next=head;
        }
        System.out.println("Vehicle entered roundabout:"+vehicleNumber);
    }
    public void removeVehicle(){
        if(head==null){
            System.out.println("Roundabout is empty");
            return;
        }
        if(head.next==head){
            System.out.println("Vehicle exited:"+head.vehicleNumber);
            head=null;
        }else{
            VehicleNode temp=head;
            while(temp.next!=head){
                temp=temp.next;
            }
            System.out.println("Vehicle exited:"+head.vehicleNumber);
            temp.next=head.next;
            head=head.next;
        }
    }
    public void displayRoundabout(){
        if(head==null){
            System.out.println("Roundabout is empty");
            return;
        }
        VehicleNode temp=head;
        System.out.print("Roundabout vehicles: ");
        do{
            System.out.print(temp.vehicleNumber+" -> ");
            temp=temp.next;
        }while(temp!=head);
        System.out.println("(back to start)");
    }
}
class VehicleQueue{
    private String[] queue;
    private int front=0;
    private int rear=-1;
    private int size=0;
    VehicleQueue(int capacity){
        queue=new String[capacity];
    }
    public boolean isFull(){
        return size==queue.length;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public void enqueue(String vehicleNumber){
        if(isFull()){
            System.out.println("Queue Overflow! Vehicle cannot enter:"+vehicleNumber);
            return;
        }
        rear=(rear+1)%queue.length;
        queue[rear]=vehicleNumber;
        size++;
        System.out.println("Vehicle added to waiting queue:"+vehicleNumber);
    }
    public String dequeue(){
        if(isEmpty()){
            System.out.println("Queue Underflow! No vehicle waiting");
            return null;
        }
        String vehicle=queue[front];
        front=(front+1)%queue.length;
        size--;
        return vehicle;
    }
}
public class TrafficManager{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Roundabout roundabout=new Roundabout();
        VehicleQueue queue=new VehicleQueue(3);
        while(true){
            System.out.println("1.Add Vehicle\n2.Remove Vehicle\n3.Display Roundabout\n4.Exit");
            int choice=sc.nextInt();
            sc.nextLine();
            if(choice==1){
                System.out.print("Enter vehicle number:");
                String vehicle=sc.nextLine();
                if(!queue.isFull()){
                    queue.enqueue(vehicle);
                    String allowedVehicle=queue.dequeue();
                    if(allowedVehicle!=null){
                        roundabout.addVehicle(allowedVehicle);
                    }
                }else{
                    queue.enqueue(vehicle);
                }
            }else if(choice==2){
                roundabout.removeVehicle();
            }else if(choice==3){
                roundabout.displayRoundabout();
            }else if(choice==4){
                System.out.println("Traffic system stopped");
                break;
            }else{
                System.out.println("Invalid choice");
            }
        }
    }
}