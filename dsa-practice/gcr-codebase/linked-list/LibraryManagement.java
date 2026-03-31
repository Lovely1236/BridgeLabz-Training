class BookNode {
    int id;
    String title, author, status;
    BookNode next, prev;

    BookNode(int i,String t,String a,String s){
        id=i; title=t; author=a; status=s;
    }
}

class Library {
    static BookNode head=null, tail=null;

    static void add(BookNode b){
        if(head==null){ head=tail=b; return; }
        tail.next=b;
        b.prev=tail;
        tail=b;
    }

    static void count(){
        int c=0;
        BookNode t=head;
        while(t!=null){ c++; t=t.next; }
        System.out.println("Total Books: "+c);
    }

    public static void main(String[] args){
        add(new BookNode(1,"Java","James","Available"));
        add(new BookNode(2,"DS","Mark","Issued"));
        count();
    }
}