
import java.util.*;
import java.util.regex.*;
import java.time.*;

public class ShipmentValidator {

    static boolean isValidCode(String code) {
        if (!code.matches("SHIP-[1-9][0-9]{5}")) return false;

        String digits = code.substring(5);
        int count = 1;
        for (int i = 1; i < digits.length(); i++) {
            if (digits.charAt(i) == digits.charAt(i - 1)) {
                count++;
                if (count > 3) return false;
            } else count = 1;
        }
        return true;
    }

    static boolean isValidDate(String date) {
        try {
            LocalDate d = LocalDate.parse(date);
            return d.getYear() >= 2000 && d.getYear() <= 2099;
        } catch (Exception e) {
            return false;
        }
    }

    static boolean isValidMode(String mode) {
        return mode.matches("AIR|SEA|ROAD|RAIL|EXPRESS|FREIGHT");
    }

    static boolean isValidWeight(String weight) {
        if (!weight.matches("(0|[1-9][0-9]{0,5})(\\.[0-9]{1,2})?")) return false;
        return Double.parseDouble(weight) <= 999999.99;
    }

    static boolean isValidStatus(String status) {
        return status.matches("DELIVERED|CANCELLED|IN_TRANSIT");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        while (n-- > 0) {
            String[] parts = sc.nextLine().split("\\|");

            if (parts.length != 5 ||
                !isValidCode(parts[0]) ||
                !isValidDate(parts[1]) ||
                !isValidMode(parts[2]) ||
                !isValidWeight(parts[3]) ||
                !isValidStatus(parts[4])) {

                System.out.println("NON-COMPLIANT RECORD");
            } else {
                System.out.println("COMPLIANT RECORD");
            }
        }
    }
}