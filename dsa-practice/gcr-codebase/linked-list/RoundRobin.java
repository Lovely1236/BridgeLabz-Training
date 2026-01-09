class ProcessNode {
    int pid;
    int burstTime;
    ProcessNode next;

    ProcessNode(int pid, int burstTime) {
        this.pid = pid;
        this.burstTime = burstTime;
        this.next = null;
    }
}

class RoundRobin {
    ProcessNode head = null;
    int timeQuantum = 2;

    // Add process at end
    public void addProcess(int pid, int burst) {
        ProcessNode node = new ProcessNode(pid, burst);

        if (head == null) {
            head = node;
            node.next = head;
            return;
        }

        ProcessNode temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        temp.next = node;
        node.next = head;
    }

    // Display processes
    public void display() {
        if (head == null) return;

        ProcessNode temp = head;
        do {
            System.out.print("[P" + temp.pid + " BT:" + temp.burstTime + "] ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    // Simulate scheduling
    public void schedule() {
        if (head == null) return;

        ProcessNode temp = head;
        int time = 0;

        while (head != null) {
            if (temp.burstTime > timeQuantum) {
                time += timeQuantum;
                temp.burstTime -= timeQuantum;
                temp = temp.next;
            } else {
                time += temp.burstTime;
                System.out.println("Process " + temp.pid + " completed at time " + time);
                remove(temp.pid);
                temp = (head != null) ? head : null;
            }
            display();
        }
    }

    // Remove process
    private void remove(int pid) {
        if (head == null) return;

        if (head.pid == pid && head.next == head) {
            head = null;
            return;
        }

        ProcessNode temp = head;
        ProcessNode prev = null;

        do {
            prev = temp;
            temp = temp.next;
        } while (temp.pid != pid && temp != head);

        prev.next = temp.next;
        if (temp == head)
            head = temp.next;
    }

    public static void main(String[] args) {
        RoundRobin rr = new RoundRobin();
        rr.addProcess(1, 5);
        rr.addProcess(2, 3);
        rr.addProcess(3, 4);

        rr.display();
        rr.schedule();
    }
}