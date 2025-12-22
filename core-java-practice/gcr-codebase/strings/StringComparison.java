import java.util.*;
public class StringComparison{
	public static boolean comparision(String a, String b){
		if(a.length()!=b.length()){
	         return false;
		 }
		for(int i=0;i<str1.length();i++){
           if(str1.charAt(i)!=str2.charAt(i)){
               return false;
           }
        }
        return true;
 
	}
   public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
		String st1=  sc.next();
		String st2= sc.next();
		boolean res1= comparision(str1, str2);
		boolean res2;
		if(str1.equals(str2)){
			res2= true;
		}
		else res2=false;
		if(res1==res2){
			System.out.print(res1);
	    
		}
        sc.close();
   
}  }