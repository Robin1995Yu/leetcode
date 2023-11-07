package solution;

import java.util.Stack;

public class Solution2609 {
    public int findTheLongestBalancedSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int max = 0;
        int count0 = 0;
        int count1 = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                if (count1 != 0) {
                    int i = Integer.min(count0, count1);
                    if (i > max) {
                        max = i;
                    }
                    count0 = 0;
                    count1 = 0;
                }
                count0++;
            } else {
                count1++;
            }
        }
        int i = Integer.min(count0, count1);
        if (i > max) {
            max = i;
        }
        return max << 1;
    }
}
