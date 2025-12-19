import java.util.Arrays;

class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();

        Arrays.sort(sChar);
        Arrays.sort(tChar);

        return Arrays.equals(sChar, tChar);
    }

    public static void main(String[] args) {
        ValidAnagram obj = new ValidAnagram();

        String s1 = "anagram";
        String t1 = "nagaram";
        System.out.println(obj.isAnagram(s1, t1)); // true

        String s2 = "rat";
        String t2 = "car";
        System.out.println(obj.isAnagram(s2, t2)); // false
    }
}
