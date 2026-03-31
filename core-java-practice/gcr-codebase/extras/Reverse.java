public class Reverse {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int j = 0;
        String st = sc.next();
        for (int i = s.length() - 1; i >= 0; i--) {
            st += s.charAt(j);
        }
    }

}