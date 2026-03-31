class Circle{
    
     int radius;
     Circle(int radius){
         this.radius=radius;
         System.out.println("Parameterised constructor");
         
     }
      Circle(){
          this(7);
         System.out.println("default constructor");
         
     }
}
public class Circles
{
	public static void main(String[] args) {
	    Circle circle1=new Circle();
	    Circle circle2=new Circle(2);
	}
}