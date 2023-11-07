package solution;

public class Solution599 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        int min = Integer.MAX_VALUE;
        int count = 0;
        int minIndex = 0;
        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                if (list1[i].equals(list2[j])) {
                    if (i + j < min) {
                        count = 1;
                        minIndex = 1 << i;
                        min = i + j;
                        break;
                    } else if (i + j == min) {
                        count++;
                        minIndex += 1 << i;
                        break;
                    }
                }
            }
        }
        String[] result = new String[count];
        for (int i = 0; i < list1.length; i++) {
            if ((minIndex & 1 << i) == 1 << i) {
                result[--count] = list1[i];
            }
        }
        return result;
    }
}
