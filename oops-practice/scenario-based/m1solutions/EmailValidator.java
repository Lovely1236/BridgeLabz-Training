import java.util.*;

public class EmailValidator {

    static boolean isValidEmail(String email) {
        String regex = "^[a-z]{3,}\\.[a-z]{3,}\\+[0-9]{4,}@(sales|marketing|IT|product)\\.company\\.com$";
        return email.matches(regex);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        while (n-- > 0) {
            String email = sc.nextLine();

            if (isValidEmail(email))
                System.out.println("Access Granted");
            else
                System.out.println("Access Denied");
        }
    }
}