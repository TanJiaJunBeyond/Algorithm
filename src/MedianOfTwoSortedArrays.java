/**
 * Created by TanJiaJun on 2021/6/9.
 * 4. 寻找两个正序数组的中位数（Median of Two Sorted Arrays）
 *
 * @see <a href="https://leetcode-cn.com/problems/median-of-two-sorted-arrays/">Median of Two Sorted Arrays</a>
 */
class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] firstNumbers = {1, 3};
        int[] secondNumbers = {2};
        System.out.println(findMedianSortedArrays(firstNumbers, secondNumbers));

        int[] thirdNumbers = {1, 2};
        int[] fourthNumbers = {3, 4};
        System.out.println(findMedianSortedArrays(thirdNumbers, fourthNumbers));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int index = 0;
        int i = 0;
        int j = 0;
        int[] arrays = new int[len1 + len2];

        while (i < len1 || j < len2) {
            if (i == len1) {
                arrays[index++] = nums2[j++];
            } else if (j == len2) {
                arrays[index++] = nums1[i++];
            } else if (nums1[i] < nums2[j]) {
                arrays[index++] = nums1[i++];
            } else {
                arrays[index++] = nums2[j++];
            }
        }
        double median;
        int length = arrays.length;
        if (length % 2 == 0) {
            median = (arrays[length / 2] + arrays[length / 2 - 1]) / 2.0D;
        } else {
            median = arrays[length / 2];
        }
        return median;
    }

}
