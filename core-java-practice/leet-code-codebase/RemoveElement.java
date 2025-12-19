import java.util.Arrays;

class RemoveElement {

    public int remove(int[] nums, int val) {
        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }

    public static void main(String[] args) {
        RemoveElement obj = new RemoveElement();

        int[] nums = {3, 2, 2, 3};
        int val = 3;

        int k = obj.remove(nums, val);

        System.out.println("k = " + k);
        System.out.println(Arrays.toString(Arrays.copyOf(nums, k)));
    }
}
