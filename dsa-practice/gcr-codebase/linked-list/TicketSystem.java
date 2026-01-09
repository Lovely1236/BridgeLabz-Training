class TicketNode {
    int ticketId;
    String customer;
    String movie;
    int seat;
    TicketNode next;

    TicketNode(int id, String c, String m, int s) {
        ticketId = id;
        customer = c;
        movie = m;
        seat = s;
        next = null;
    }
}

class TicketSystem {
    TicketNode head;

    public void bookTicket(int id, String c, String m, int s) {
        TicketNode node = new TicketNode(id, c, m, s);

        if (head == null) {
            head = node;
            node.next = head;
            return;
        }

        TicketNode temp = head;
        while (temp.next != head)
            temp = temp.next;

        temp.next = node;
        node.next = head;
    }

    public void display() {
        if (head == null) return;

        TicketNode temp = head;
        do {
            System.out.println(
                temp.ticketId + " | " +
                temp.customer + " | " +
                temp.movie + " | Seat " + temp.seat
            );
            temp = temp.next;
        } while (temp != head);
    }

    public int countTickets() {
        if (head == null) return 0;
        int count = 0;
        TicketNode temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        return count;
    }

    public static void main(String[] args) {
        TicketSystem ts = new TicketSystem();
        ts.bookTicket(1, "Mahima", "Inception", 12);
        ts.bookTicket(2, "Malay", "Interstellar", 15);

        ts.display();
        System.out.println("Total Tickets: " + ts.countTickets());
    }
}