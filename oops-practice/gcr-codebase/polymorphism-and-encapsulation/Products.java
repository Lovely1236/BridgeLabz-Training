abstract class Product{
    String productId;
    String name;
    int price;
    Product(String productId,String name ,int price){
        this.productId=productId;
        this.name=name;
        this.price=price;
        
    }
    public void setprice(){
        this.price=price;
        
    }
    public int getprice(){
        return price;
    }
      public void setname(){
        this.name=name;
        
    }
    public String getproductId(){
        return productId;
    }
      public void setproductId(){
        this.productId=productId;
        
    }
    public String getname(){
        return name;
    }
    
   abstract  int calculateDiscount();
//   void displayDetails(){
//       System.out.println("Employee details is:"+employeeId);
//       System.out.println("The name of the employee is :"+name);
//   }
     
}
class Electronics extends Product {
    int discount;
    Electronics(String productId,String name ,int price,int discount){
         super(productId, name , price);
    }

    int calculateDiscount(){
        System.out.print("The discount   is:");
        return price-(discount*price/100);
    }
    
}
class Clothing extends Product {
   int discount;
    Clothing(String productId,String name ,int price,int discount){
         super(productId, name , price);
         this.discount=discount;
         
    }
    int calculateDiscount(){
        System.out.print("The discount   is:");
        return price-(discount*price/100);
    }
}
interface Taxable{
    int tax=18;
    
    int calculateTax(int price);
    void getTaxDetails();
}
class Tax implements Taxable{
    public int calculateTax(int price){
        return price+(tax*price/100);
    }
   public void getTaxDetails(){
        System.out.println("The tax on products is 18%");
    }
    
}
public class Products
{

	public static void main(String[] args) {
	    Product p=new Electronics("8duvidfuivdui","Refrigerator",700000,4);
	   System.out.println(p.calculateDiscount());
	   	    Product p1=new Clothing ("8duvidfuivdui","Refrigerator",700000,8);
	   System.out.println(p1.calculateDiscount());
	   	   	    Tax t=new Tax();
	   	   	    System.out.println(t.calculateTax(20000));
	   	   	    t.getTaxDetails();

	   


	   

	   
	}
}