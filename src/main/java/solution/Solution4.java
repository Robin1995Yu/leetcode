package solution;

public class Solution4 {
    // TODO
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return findMedianSortedArrays(nums1, 0, nums1.length , nums2, 0, nums2.length, 0);
    }

    private double findMedianSortedArrays(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int offset) {
        if (nums1.length == 0 || nums2.length == 0) {
            return findMedianSortedArrays0(nums1, start1, end1, nums2, start2, end2, offset);
        }
        if (nums1[0] >= nums2[nums2.length - 1]) {
            return findMedianSortedArrays0(nums2, start2, end2, nums1, start1, end1, offset);
        }
        if (nums2[0] >= nums1[nums2.length - 1]) {
            return findMedianSortedArrays0(nums1, start1, end1, nums2, start2, end2, offset);
        }
//        if (nums1[0])
        return 0;
    }

    private double findMedianSortedArrays0(int[] low, int startLow, int endLow, int[] hei, int startHei, int endHei, int offset) {
        int length = endLow - startLow + endHei + startHei + offset;
        int mid = length >> 1;
        if ((length & 1) == 1) {
            return get(low, startLow, endLow, hei, startHei, endHei, mid);
        } else {
            return (get(low, startLow, endLow, hei, startHei, endHei, mid) + get(low, startLow, endLow, hei, startHei, endHei, mid - 1)) / 2.0;
        }
    }

    private int findIndex(int[] nums, int start, int end, int value) {
        int start1 = start;
        int end1 = end;
        int mid;
        while (start1 < end1) {
            mid = (start1 + end1) / 2;
            if (value > nums[mid] && value <= nums[mid + 1]) {
                return mid;
            } else if (value == nums[mid]) {
                for (int i = mid; i >= 0; i--) {
                    if (nums[i] != value) {
                        return i;
                    }
                }
                return -1;
            } else if (value < nums[mid]) {
                end1 = mid;
            } else {
                start1 = mid;
            }
        }
        return -1;
    }

    private int get(int[] low, int startLow, int endLow, int[] hei, int startHei, int endHei, int index) {
        return index < endLow - startLow ? low[index + startLow] : hei[index - endLow + startLow + startHei];
    }

    public static void main(String[] args) {
    }
}
