
class Persons{
    
     String name;
     Person(String name){
         this.name=name;
         
        
         System.out.println("Parameteried one");
         
     }
      Person(Person p){
          this.name=p.name;
          

         
     }
     void display(){
         System.out.println(name);
     }
}
public class Person
{
	public static void main(String[] args) {
	    Persons person=new Persons("Mahima");
	    Persons person2=new Persons(person);
	    person.display();
	    person2.display();

	    
	    
	}
}