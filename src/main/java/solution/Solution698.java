package solution;

import java.util.Arrays;

public class Solution698 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (k > nums.length) {
            return false;
        }
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) {
            return false;
        }
        int n = sum / k;
        for (int num : nums) {
            if (num > n) {
                return false;
            }
        }
        return false;
    }
}
