import java.util.Scanner;

public class CompareUsingCharArray{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    //taking input from the user...
    String str=sc.next();

    //using charArray for compare
    char [ ] ch1=str.toCharArray();

    //using built in function
    char [] ch2=new char[str.length()];

    for(int i = 0;i<str.length();i++){
      ch2[i]=str.charAt(i);
    }

    System.out.println(CompareStrings(ch1, ch2));
    sc.close();
  }


  //making a built in method to comapre the strings 
   public static boolean CompareStrings(char [] ch1, char [] ch2){
    boolean isEqual=true;
    if(ch1.length!=ch2.length){
      isEqual=false;
    }else{
      for(int i=0;i<ch2.length;i++){
        if(ch1[i]!=ch2[i]){
          isEqual=false;
          break;
        }
      }
    }

   return isEqual;
   

  }
}

