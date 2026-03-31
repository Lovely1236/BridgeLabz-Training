import java.util.*;

public class CountdownNumber {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int counter = sc.nextInt();

        while(counter == 1){
            // If counter is 1, just print 1 and break
            System.out.println(counter);
            break;
        }
       

        // if counter is greater than 1
        while(counter > 1){
            System.out.println(counter);
            counter--;
        }

        sc.close();
    }

}
