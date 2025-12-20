public class NaturalSumFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        if (number > 0) {
            System.out.println("It is a natural number ");
        }
        int FormulaSum = number(number + 1) / 2;
        int sum = 0;
        for (int i = 1; i < number; i++) {
            sum += i;
        }
        if (FormulaSum == sum)
            System.out.println(sum);
    }

}