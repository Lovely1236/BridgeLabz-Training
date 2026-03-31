class HotelBooking{
    
     String guestName;
     String roomType;
     int nights;

     HotelBooking(){
         System.out.println("default constructors");
     }

     HotelBooking(String guestName,String roomType,int nights){
         this.guestName=guestName;
         this.roomType=roomType;
         this.nights=nights;
         System.out.println("Parameteried one");
         }
      HotelBooking(HotelBooking h){
          System.out.println("Copy constructors");
                   this.guestName=h.guestName;
                   this.roomType=h.roomType;
                   this.nights=h.nights;

     }
     void display(){
         System.out.println(guestName);
         System.out.println(roomType);
         System.out.println(nights);

     }
}


public class Main
{
	public static void main(String[] args){
	    HotelBooking booking=new HotelBooking();
	    HotelBooking booking1=new HotelBooking("Mahima","Premium",2);
	    HotelBooking booking2=new HotelBooking(booking1);
	    booking1.display();
	    booking2.display();

	    
	    
	}
}