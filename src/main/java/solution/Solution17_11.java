package solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution17_11 {
    public int findClosest(String[] words, String word1, String word2) {
        return new FindClosest(words).findClosest(word1, word2);
    }

    public static class FindClosest {
        private final Map<String, List<Integer>> dir;

        public FindClosest(String[] words) {
            Map<String, List<Integer>> dir = new HashMap<>();
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                List<Integer> list = dir.get(word);
                if (list == null) {
                    list = new ArrayList<>();
                    dir.put(word, list);
                }
                list.add(i);
            }
            this.dir = dir;
        }

        public int findClosest(String word1, String word2) {
            List<Integer> list1 = dir.get(word1);
            List<Integer> list2 = dir.get(word2);
            if (list1 == null || list2 == null) {
                return -1;
            }
            int result = Integer.MAX_VALUE;
            for (Integer i1 : list1) {
                for (Integer i2 : list2) {
                    int curr = Math.abs(i1 - i2);
                    if (curr < result) {
                        result = curr;
                    }
                }
            }
            return result;
        }
    }
}
