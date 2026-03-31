import java.util.*;
public class FindYoungestFriend {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
     
        int amarAge, akbarAge, anthonyAge;
        int amarHeight, akbarHeight, anthonyHeight;

        amarAge = sc.nextInt();
        amarHeight = sc.nextInt(); 

        akbarAge = sc.nextInt();
        akbarHeight = sc.nextInt();

        anthonyAge = sc.nextInt();  
        anthonyHeight = sc.nextInt();
//This one is Age comparison
        if (amarAge < akbarAge && amarAge < anthonyAge) {
            System.out.println("The youngest friend is Amar with age " + amarAge);
            return;
        }
        if (akbarAge < anthonyAge && akbarAge < amarAge) {
            System.out.println("The youngest friend is Akbar with age " + akbarAge);
            return;
        }
        if (anthonyAge < akbarAge && anthonyAge < amarAge) {
            System.out.println("The youngest friend is Anthony with age " + anthonyAge);
            return;
        }
            
// Now for Height comparison
        if (amarHeight > akbarHeight && amarHeight > anthonyHeight) {
            System.out.println("The tallest friend is Amar with height " + amarHeight);
            return;
        }
        if (akbarHeight > anthonyHeight && akbarHeight > amarHeight) {
            System.out.println("The tallest friend is Akbar with height " + akbarHeight);
            return;
        }
        if (anthonyHeight > akbarHeight && anthonyHeight > amarHeight) {
            System.out.println("The tallest friend is Anthony with height " + anthonyHeight);
            return;
        }

        sc.close();
    }
    
}
