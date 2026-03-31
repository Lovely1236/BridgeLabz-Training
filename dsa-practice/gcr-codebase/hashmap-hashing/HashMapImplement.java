import java.util.*;
public class HashMapImplement {
    static class MyHashMap {
        class Node{
            int key;
            String value;
            Node next;
            Node(int key,String value){
                this.key=key;
                this.value=value;
                this.next=null;
            }
        }
        private int size;
        private Node table[];
        MyHashMap(int size){
            this.size=size;
            table=new Node[size];
        }
        private int hashFunction(int key){
            return key%size;
        }
        public void put(int key,String value){
            int index=hashFunction(key);
            Node head=table[index];
            if(head==null){
                table[index]=new Node(key,value);
                return;
            }
            Node current=head;
            while(current!=null){
                if(current.key==key){
                    current.value=value;
                    return;
                }
                if(current.next==null)
                    break;
                current=current.next;
            }
            current.next=new Node(key,value);
        }
        public String get(int key){
            int index=hashFunction(key);
            Node current=table[index];
            while(current!=null){
                if(current.key==key)
                    return current.value;
                current=current.next;
            }
            return null;
        }
        public void remove(int key){
            int index=hashFunction(key);
            Node current=table[index];
            Node prev=null;

            while(current!=null){
                if(current.key==key){
                    if(prev==null)
                        table[index]=current.next;
                    else
                        prev.next=current.next;
                    return;
                }
                prev=current;
                current=current.next;
            }
        }
        public void display(){
            for(int i=0;i<size;i++){
                Node current=table[i];
                System.out.print(i+" : ");
                while(current!=null){
                    System.out.print("("+current.key+","+current.value+") ");
                    current=current.next;
                }
                System.out.println();
            }
        }
    }
    public static void main(String[] args){
        Scanner ob=new Scanner(System.in);
        System.out.println("Enter size of hash table:");
        int size=ob.nextInt();
        MyHashMap map=new MyHashMap(size);
        while(true){
            System.out.println("\n1.Insert");
            System.out.println("2.Get");
            System.out.println("3.Remove");
            System.out.println("4.Display");
            System.out.println("0.Exit");
            System.out.print("Enter choice:");
            int choice=ob.nextInt();
            if(choice==0)
                break;
            switch(choice){
                case 1:
                    System.out.print("Enter key:");
                    int key=ob.nextInt();
                    System.out.print("Enter value:");
                    String value=ob.next();
                    map.put(key,value);
                    break;
                case 2:
                    System.out.print("Enter key to search:");
                    int searchKey=ob.nextInt();
                    String result=map.get(searchKey);
                    if(result==null)
                        System.out.println("Key not found");
                    else
                        System.out.println("Value:"+result);
                    break;
                case 3:
                    System.out.print("Enter key to remove:");
                    int removeKey=ob.nextInt();
                    map.remove(removeKey);
                    System.out.println("Key removed if existed");
                    break;
                case 4:
                    map.display();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}