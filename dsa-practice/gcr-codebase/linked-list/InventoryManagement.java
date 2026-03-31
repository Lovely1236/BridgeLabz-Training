class ItemNode {
    int id, qty;
    String name;
    double price;
    ItemNode next;

    ItemNode(int i,String n,int q,double p){
        id=i; name=n; qty=q; price=p; next=null;
    }
}

class Inventory {
    static ItemNode head=null;

    static void add(ItemNode n){
        if(head==null){ head=n; return; }
        ItemNode t=head;
        while(t.next!=null) t=t.next;
        t.next=n;
    }

    static void totalValue(){
        double sum=0;
        ItemNode t=head;
        while(t!=null){
            sum += t.qty * t.price;
            t=t.next;
        }
        System.out.println("Total Value = "+sum);
    }

    public static void main(String[] args){
        add(new ItemNode(1,"Pen",10,5));
        add(new ItemNode(2,"Book",5,100));
        totalValue();
    }
}