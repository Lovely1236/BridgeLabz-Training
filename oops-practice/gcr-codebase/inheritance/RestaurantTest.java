interface Worker{
    void performDuties();
}
class Person{
    String name;
    int id;
    Person(String name,int id){
        this.name=name;
        this.id=id;
    }
}
class Chef extends Person implements Worker{
    Chef(String name,int id){
        super(name,id);
    }
    public void performDuties(){
        System.out.println("Cooking");
    }
}
class Waiter extends Person implements Worker{
    Waiter(String name,int id){
        super(name,id);
    }
    public void performDuties(){
        System.out.println("Serving");
    }
}
public class RestaurantTest{
    public static void main(String[] args){
        Worker w1=new Chef("Ram",1);
        Worker w2=new Waiter("Sam",2);
        w1.performDuties();
        w2.performDuties();
    }
}