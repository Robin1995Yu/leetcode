package solution;

public class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length <= 1) {
            return "";
        }
        int length = 0;
        out:while (true) {
            if (strs[0].length() <= length) {
                break;
            }
            char c = strs[0].charAt(length);
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].length() <= length) {
                    break out;
                }
                if (strs[i].charAt(i) != c) {
                    break out;
                }
            }
            length++;
        }
        return strs[0].substring(0, length);
    }
}
