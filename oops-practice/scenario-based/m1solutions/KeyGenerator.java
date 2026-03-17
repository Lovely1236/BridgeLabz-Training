import java.util.*;

public class KeyGenerator {

    static boolean isValid(String s) {
        if (s == null || s.length() == 0) return false;
        if (s.length() < 6) return false;
        return s.matches("[a-zA-Z]+");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        while (n-- > 0) {
            String s = sc.nextLine();

            if (s.length() == 0) {
                System.out.println("Invalid Input (empty string)");
                continue;
            }

            if (s.length() < 6) {
                System.out.println("Invalid Input (length < 6)");
                continue;
            }

            if (s.contains(" ")) {
                System.out.println("Invalid Input (contains space)");
                continue;
            }

            if (s.matches(".*\\d.*")) {
                System.out.println("Invalid Input (contains digits)");
                continue;
            }

            if (!s.matches("[a-zA-Z]+")) {
                System.out.println("Invalid Input (contains special character)");
                continue;
            }

            s = s.toLowerCase();

            StringBuilder filtered = new StringBuilder();
            for (char c : s.toCharArray()) {
                if (c % 2 != 0) filtered.append(c);
            }

            filtered.reverse();

            StringBuilder result = new StringBuilder();
            for (int i = 0; i < filtered.length(); i++) {
                char c = filtered.charAt(i);
                if (i % 2 == 0)
                    result.append(Character.toUpperCase(c));
                else
                    result.append(c);
            }

            System.out.println("The generated key is - " + result);
        }
    }
}