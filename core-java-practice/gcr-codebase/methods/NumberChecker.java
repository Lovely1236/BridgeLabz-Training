import java.util.Scanner;
class NumberChecker{
    public static int countDigits(int number){
        int count = 0;
        while(number != 0){
            count++;
            number /= 10;
        }
        return count;
    }
    public static int[] storeDigits(int number, int digitCount){
        int[] digits = new int[digitCount];
        int index = digitCount - 1;
        while (number != 0){
            digits[index] = number % 10;
            number /= 10;
            index--;
        }
        return digits;
    }
    public static boolean isDuckNumber(int[] digits){
        for(int digit : digits){
            if (digit != 0) {
                return true;
            }
        }
        return false;
    }
    public static boolean isArmstrongNumber(int number, int[] digits){
        int sum = 0;
        int power = digits.length;
        for(int digit : digits){
            sum += Math.pow(digit, power);
        }
        return sum == number;
    }
    public static void findLargestAndSecondLargest(int[] digits){
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for(int digit : digits){
            if(digit > largest){
                secondLargest = largest;
                largest = digit;
            } 
            else if(digit > secondLargest && digit != largest){
                secondLargest = digit;
            }
        }
        System.out.println("Largest Digit: " + largest);
        System.out.println("Second Largest Digit: " + secondLargest);
    }
    public static void findSmallestAndSecondSmallest(int[] digits){
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        for(int digit : digits){
            if(digit < smallest){
                secondSmallest = smallest;
                smallest = digit;
            } 
            else if(digit < secondSmallest && digit != smallest){
                secondSmallest = digit;
            }
        }
        System.out.println("Smallest Digit: " + smallest);
        System.out.println("Second Smallest Digit: " + secondSmallest);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        int digitCount = countDigits(number);
        int[] digits = storeDigits(number, digitCount);
        System.out.println("Total Digits: " + digitCount);
        System.out.print("Digits Array: ");
        for (int digit : digits) {
            System.out.print(digit + " ");
        }
        System.out.println("Is Duck Number: " + isDuckNumber(digits));
        System.out.println("Is Armstrong Number: " + isArmstrongNumber(number, digits));
        findLargestAndSecondLargest(digits);
        findSmallestAndSecondSmallest(digits);
        sc.close();
    }
}