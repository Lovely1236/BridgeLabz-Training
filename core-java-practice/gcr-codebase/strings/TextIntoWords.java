import java.util.Scanner;

public class TextIntoWords {

  //find length without using length()
    public static int findLength(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            count++;
        }
        return count;
    }

    // c. split text into words using charAt()
    public static String[] userSplit(String str) {

        int len = findLength(str);

        // count words
        int words = 1;
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == ' ') {
                words++;
            }
        }

        String[] result = new String[words];
        int index = 0;
        String temp = "";

        for (int i = 0; i < len; i++) {
            if (str.charAt(i) != ' ') {
                temp += str.charAt(i);
            } else {
                result[index++] = temp;
                temp = "";
            }
        }
        result[index] = temp; // last word

        return result;
    }

    // d. compare two string arrays
    public static boolean compareArrays(String[] a, String[] b) {
        if(a.length != b.length) return false;

        for(int i = 0;i< a.length;i++){
            if (!a[i].equals(b[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        // a. input
        String text = sc.nextLine();

        // user-defined split
        String[] userWords = userSplit(text);

        // built-in split
        String[] builtInWords = text.split(" ");

        // e. compare results
        boolean result = compareArrays(userWords, builtInWords);

        System.out.println("Are both split results equal? " + result);
        sc.close();  
    }
}