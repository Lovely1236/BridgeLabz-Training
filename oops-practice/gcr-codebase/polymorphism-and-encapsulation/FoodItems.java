abstract class FoodItem {
    String itemName;
     int price;
     int quantity;
     FoodItem(String itemName,int price,int quantity){
         this.itemName=itemName;
         this.price=price;
         this.quantity=quantity;
     }
      abstract double calculateTotalPrice();
     void getItemDetails(){
         System.out.println("The details are:");
         System.out.println("The name of the item is :"+itemName);
         System.out.println("The price is:"+price);
         System.out.println("The quantity is:"+quantity);

         
     }
}
interface Discountable{
    double  discount=0.10;
    double  applyDiscount();
     String getDiscountDetails();
}
class VegItem extends FoodItem implements Discountable{
    int additionalCharges=50;
    VegItem(String itemName,int price,int quantity){
        super(itemName,price,quantity);
    }
    @Override
    double calculateTotalPrice(){
        return price*quantity+additionalCharges;
    }
        @Override

   public  double applyDiscount(){
        return (price*quantity+additionalCharges)*discount;
    }
        @Override

     public  String getDiscountDetails(){
        return "The discount is 10%";
    }
    
}
class NonVegItem extends FoodItem implements Discountable{
    int additionalCharges=100;
    NonVegItem(String itemName,int price,int quantity){
        super(itemName,price,quantity);
    }
        @Override

    double calculateTotalPrice(){
        return price*quantity+additionalCharges;
    }
        @Override

   public  double applyDiscount (){
     return (price*quantity+additionalCharges)*discount;

    }
        @Override

   public  String getDiscountDetails(){
        return "The discount is 10%";
    }
    
    
}
public class FoodItems
{
	public static void main(String[] args) {
	    FoodItem f1=new VegItem("Chhole bhature",100,2);
	  System.out.println ( f1.calculateTotalPrice());
	  f1.getItemDetails();
	    Discountable d=new VegItem("Chhole bhature",100,2);
	    System.out.println(d.applyDiscount()); 
	    System.out.println(d.getDiscountDetails());
	}
}