package solution;

public class Solution17_19 {
    public int[] missingTwo(int[] nums) {
        int i = 0;
        for (int j = 1; j <= nums.length + 2; j++) {
            i ^= j;
        }
        for (int num : nums) {
            i ^= num;
        }
        int base = i & -i;
        int x = 0;
        int y = 0;
        for (int j = 1; j <= nums.length + 2; j++) {
            if ((j & base) == base) {
                x ^= j;
            } else {
                y ^= j;
            }
        }
        for (int num : nums) {
            if ((num & base) == base) {
                x ^= num;
            } else {
                y ^= num;
            }
        }
        return new int[] {x, y};
    }
}
