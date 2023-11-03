package solution;

public class Solution4 {
    // TODO
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        int k = length / 2;
        int nums1Index = 0;
        int nums2Index = 0;
        while (k > 1) {
            int steep = k / 2 - 1;
            int nums1Steep = Integer.min(nums1Index + steep, nums1.length);
            int nums2Steep = Integer.min(nums2Index + steep, nums2.length);
            nums1Steep -= nums1Index;
            nums2Steep -= nums2Index;
            nums1Index += nums1Steep;
            nums2Index += nums2Steep;
            int nums1CurrValue = nums1[nums1Index];
            int nums2CurrValue = nums2[nums2Index];
            if (nums1CurrValue >= nums2CurrValue) {
                k -= nums2Steep;
                nums1Index -= nums1Steep;
            } else {
                k -= nums1Steep;
                nums2Index -= nums2Steep;
            }
        }
        return Integer.min(nums1[nums1Index], nums2[nums2Index]);
    }
}
