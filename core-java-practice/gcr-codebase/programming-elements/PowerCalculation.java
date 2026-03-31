public class PowerCalculation {
    public static void main(String[] args) {
        int a = 2;
        int e = 3;





        int ans = 1;
        for (int i = 0; i < e; i++) {
            ans *= a;
        }

        
        System.out.println(a + " raised to the power of " + e + " is: " + ans);
    }
}
