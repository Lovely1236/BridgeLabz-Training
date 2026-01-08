import java.util.Scanner;
class Node{
    int roll;
    String name;
    int age;
    char grade;
    Node next;
    Node(int r, String n, int a, char g) {
        roll = r;
        name = n;
        age = a;
        grade = g;
        next = null;
    }
}

public class StudentLinkedList {
    static Node head = null;
    // Add at end
    static void addStudent(int r, String n, int a, char g) {
        Node newNode = new Node(r, n, a, g);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null)
            temp = temp.next;
            
        temp.next = newNode;
    }

    // Delete by roll number
    static void deleteStudent(int r) {
        if (head == null) return;
        if (head.roll == r) {
            head = head.next;
            return;
        }
        Node temp = head;
        while (temp.next != null && temp.next.roll != r)
            temp = temp.next;

        if (temp.next != null)
            temp.next = temp.next.next;
    }
    // Search student
    static void searchStudent(int r) {
        Node temp = head;
        while (temp != null) {
            if (temp.roll == r) {
                System.out.println(temp.roll + " " + temp.name + " " + temp.age + " " + temp.grade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Not Found");
    }

    // Update grade
    static void updateGrade(int r, char g) {
        Node temp = head;
        while (temp != null) {
            if (temp.roll == r) {
                temp.grade = g;
                return;
            }
            temp = temp.next;
        }
    }

    // Display all
    static void display() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.roll + " " + temp.name + " " + temp.age + " " + temp.grade);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ch;

        do {
            System.out.println("\n1 Add  2 Delete  3 Search  4 Update  5 Display  6 Exit");
            ch = sc.nextInt();

            int r, a;
            String n;
            char g;

            switch (ch) {
                case 1:
                    r = sc.nextInt();
                    n = sc.next();
                    a = sc.nextInt();
                    g = sc.next().charAt(0);
                    addStudent(r, n, a, g);
                    break;

                case 2:
                    deleteStudent(sc.nextInt());
                    break;

                case 3:
                    searchStudent(sc.nextInt());
                    break;

                case 4:
                    r = sc.nextInt();
                    g = sc.next().charAt(0);
                    updateGrade(r, g);
                    break;

                case 5:
                    display();
                    break;
            }
        } while (ch != 6);
    }
}
