package solution;

import java.util.HashMap;
import java.util.Map;

public class Solution13 {
    Map<Character, Integer> m = new HashMap<Character, Integer>() {
        {
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }
    };
    public int romanToInt(String s) {
        int result = 0;
        result += m.get(s.charAt(s.length() - 1));
        for (int i = 0; i < s.length() - 1; i++) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(i + 1);
            int i1 = m.get(c1);
            int i2 = m.get(c2);
            if (i2 > i1) {
                i1 = -i1;
            }
            result += i1;
        }
        return result;
    }
}
