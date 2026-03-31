public class NullPointerExceptionDemo{

  // make a method name exception
  public static void generateException(){
    String str = null;
    System.out.println(str.length());
  }

  // make another method to make null pointer
  public static void handleNullPointer(){
    String str = null;
    // use try and catch block to handle the exception
    try{
      System.out.println(str.length());
    } catch (NullPointerException e) {
      System.out.println("NullPointerException caught");
    }
  }

  // call them in the main method
  public static void main(String[] args){
    try{
      generateException();

    } catch(NullPointerException e){
      System.out.println("Error occured in Exception method");
    }
    handleNullPointer();
  }

}