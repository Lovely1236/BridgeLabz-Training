
class Books{
    String author;
    String name;
     int price;
     Book(String author,String name,int price){
         System.out.println("Parameterised constructor");
         
     }
      Book(){
         System.out.println("default constructor");
         
     }
}
public class Book
{
	public static void main(String[] args){
	    Books book1=new Books();
	    Books book2=new Books("Wings of fire", "APJ abdul kalam ",200);
	}
}