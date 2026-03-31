class TaskNode {
    int id;
    String name, date;
    int priority;
    TaskNode next;

    TaskNode(int i, String n, int p, String d) {
        id = i; name = n; priority = p; date = d;
        next = this;
    }
}

class TaskScheduler {
    static TaskNode head = null, current = null;

    static void addTask(int i, String n, int p, String d) {
        TaskNode t = new TaskNode(i, n, p, d);
        if (head == null) {
            head = current = t;
            return;
        }
        TaskNode temp = head;
        while (temp.next != head) temp = temp.next;
        temp.next = t;
        t.next = head;
    }

    static void nextTask() {
        if (current != null) {
            System.out.println("Current: " + current.name);
            current = current.next;
        }
    }

    static void display() {
        if (head == null) return;
        TaskNode t = head;
        do {
            System.out.println(t.id + " " + t.name + " " + t.priority);
            t = t.next;
        } while (t != head);
    }

    public static void main(String[] args) {
        System.out.pritnln("Welcome ");
        addTask(1,"Coding",1,"10-06");
        addTask(2,"Testing",2,"11-06");
        addTask(3,"Deploy",3,"12-06");

        display();
        nextTask();
        nextTask();
    }
}