import java.util.*;
class OtpGenerator {
    public static int generateOTP() {
        return (int) (Math.random() * 900000) + 100000;
    }
    public static int[] generateOTPs(int count) {
        int[] otps = new int[count];
        for (int i = 0; i < count; i++) {
            otps[i] = generateOTP();
        }
        return otps;
    }
    public static boolean areOTPsUnique(int[] otps) {
        for (int i = 0; i < otps.length; i++) {
            for (int j = i + 1; j < otps.length; j++) {
                if (otps[i] == otps[j]) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[] otpArray = generateOTPs(10);
        System.out.println("Generated OTPs:");
        System.out.println(Arrays.toString(otpArray));
        boolean isUnique = areOTPsUnique(otpArray);
        if (isUnique) {
            System.out.println("All OTPs are unique ");
        } else {
            System.out.println("Duplicate OTP found ");
        }
    }
}