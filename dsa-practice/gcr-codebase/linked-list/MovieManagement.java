import java.util.Scanner;

class MovieNode {
    String title, director;
    int year;
    double rating;
    MovieNode next, prev;

    MovieNode(String t, String d, int y, double r) {
        title = t;
        director = d;
        year = y;
        rating = r;
        next = prev = null;
    }
}

class MovieManagement {
    static MovieNode head = null, tail = null;

    static void addMovie(String t, String d, int y, double r) {
        MovieNode n = new MovieNode(t, d, y, r);

        if (head == null) {
            head = tail = n;
            return;
        }
        tail.next = n;
        n.prev = tail;
        tail = n;
    }

    static void removeMovie(String title) {
        MovieNode temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                if (temp == head) head = head.next;
                if (temp == tail) tail = tail.prev;
                if (temp.prev != null) temp.prev.next = temp.next;
                if (temp.next != null) temp.next.prev = temp.prev;
                System.out.println("Movie removed");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found");
    }

    static void searchByDirector(String d) {
        MovieNode temp = head;
        while (temp != null) {
            if (temp.director.equalsIgnoreCase(d))
                System.out.println(temp.title + " " + temp.rating);
            temp = temp.next;
        }
    }

    static void updateRating(String title, double r) {
        MovieNode temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = r;
                System.out.println("Rating updated");
                return;
            }
            temp = temp.next;
        }
    }

    static void displayForward() {
        MovieNode temp = head;
        while (temp != null) {
            System.out.println(temp.title + " " + temp.director + " " + temp.rating);
            temp = temp.next;
        }
    }

    static void displayReverse() {
        MovieNode temp = tail;
        while (temp != null) {
            System.out.println(temp.title + " " + temp.director + " " + temp.rating);
            temp = temp.prev;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ch;
        do {
            System.out.println("\n1 Add  2 Remove  3 Search  4 Update  5 Forward  6 Reverse  7 Exit");
            ch = sc.nextInt(); sc.nextLine();

            if (ch == 1) {
                System.out.print("Title: "); String t = sc.nextLine();
                System.out.print("Director: "); String d = sc.nextLine();
                System.out.print("Year: "); int y = sc.nextInt();
                System.out.print("Rating: "); double r = sc.nextDouble();
                addMovie(t, d, y, r);
            } 
            else if (ch == 2) {
                System.out.print("Title: ");
                removeMovie(sc.nextLine());
            } 
            else if (ch == 3) {
                System.out.print("Director: ");
                searchByDirector(sc.nextLine());
            } 
            else if (ch == 4) {
                System.out.print("Title: ");
                String t = sc.nextLine();
                System.out.print("New Rating: ");
                updateRating(t, sc.nextDouble());
            } 
            else if (ch == 5) displayForward();
            else if (ch == 6) displayReverse();

        } while (ch != 7);
    }
}