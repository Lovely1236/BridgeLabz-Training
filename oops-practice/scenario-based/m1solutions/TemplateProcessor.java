import java.util.*;
import java.util.regex.*;
import java.time.*;
import java.time.format.*;

public class TemplateProcessor {

    static String process(String line) {
        Pattern pattern = Pattern.compile("\\$\\{(\\w+):(.*?)\\}");
        Matcher matcher = pattern.matcher(line);
        StringBuffer result = new StringBuffer();

        while (matcher.find()) {
            String type = matcher.group(1);
            String value = matcher.group(2);
            String replacement = "INVALID";

            try {
                switch (type) {
                    case "UPPER":
                        replacement = value.toUpperCase();
                        break;

                    case "LOWER":
                        replacement = value.toLowerCase();
                        break;

                    case "DATE":
                        DateTimeFormatter input = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                        DateTimeFormatter output = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                        LocalDate date = LocalDate.parse(value, input);
                        replacement = date.format(output);
                        break;

                    case "REPEAT":
                        String[] parts = value.split(",");
                        String word = parts[0];
                        int count = Integer.parseInt(parts[1]);
                        replacement = word.repeat(count);
                        break;
                }
            } catch (Exception e) {
                replacement = "INVALID";
            }

            matcher.appendReplacement(result, replacement);
        }
        matcher.appendTail(result);
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        while (n-- > 0) {
            System.out.println(process(sc.nextLine()));
        }
    }
}