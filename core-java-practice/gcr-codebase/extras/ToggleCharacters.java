import java.util.Scanner;

public class ToggleCharacters{

    // Method to toggle characters
    public static String toggleString(String str){

        StringBuilder result = new StringBuilder();



        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);

            if(Character.isUpperCase(ch)){
                result.append(Character.toLowerCase(ch));
            } else if(Character.isLowerCase(ch)){
                result.append(Character.toUpperCase(ch));
            } else{
                // Non-alphabetic characters remain same
                result.append(ch);
            }
        }



        return result.toString();
    }

    // MAIN METHOD
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String toggled = toggleString(input);

        System.out.println("Toggled String: " + toggled);

        sc.close();
    }
}