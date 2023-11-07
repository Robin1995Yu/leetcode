package solution;

public class Solution26 {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int result = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                nums[result] = nums[i + 1];
                result++;
            }
        }
        return result;
    }
}
