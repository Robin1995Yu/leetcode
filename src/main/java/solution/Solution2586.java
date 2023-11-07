package solution;

public class Solution2586 {
    public int vowelStrings(String[] words, int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            char c0 = words[i].charAt(0);
            char c1 = words[i].charAt(words[i].length() - 1);
            if (
                    (c0 == 'a' || c0 == 'e' || c0 == 'i' || c0 == 'o' || c0 == 'u') &&
                    (c1 == 'a' || c1 == 'e' || c1 == 'i' || c1 == 'o' || c1 == 'u')
            ) {
                count++;
            }
        }
        return count;
    }
}
