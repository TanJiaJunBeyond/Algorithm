/**
 * Created by TanJiaJun on 2021/6/9.
 * 4. 寻找两个正序数组的中位数（Median of Two Sorted Arrays）
 * 难度：困难
 *
 * @see <a href="https://leetcode-cn.com/problems/median-of-two-sorted-arrays/">Median of Two Sorted Arrays</a>
 */
class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        // 示例一
        System.out.println("示例一：");

        int[] firstNumbers = {1, 3};
        int[] secondNumbers = {2};
        System.out.println(findMedianSortedArrays(firstNumbers, secondNumbers));

        System.out.print("\n");

        // 示例二
        System.out.println("示例二：");

        int[] thirdNumbers = {1, 2};
        int[] fourthNumbers = {3, 4};
        System.out.println(findMedianSortedArrays(thirdNumbers, fourthNumbers));

        System.out.print("\n");

        // 示例三
        System.out.println("示例三：");

        int[] fifthNumbers = {0, 0};
        int[] sixthNumbers = {0, 0};
        System.out.println(findMedianSortedArrays(fifthNumbers, sixthNumbers));

        System.out.print("\n");

        // 示例四
        System.out.println("示例四：");

        int[] seventhNumbers = {};
        int[] eightNumbers = {1};
        System.out.println(findMedianSortedArrays(seventhNumbers, eightNumbers));

        System.out.print("\n");

        // 示例五
        System.out.println("示例五：");

        int[] ninthNumbers = {2};
        int[] tenthNumbers = {};
        System.out.println(findMedianSortedArrays(ninthNumbers, tenthNumbers));
    }

    /**
     * 双指针
     * 时间复杂度：O(m+n)，其中m是数组num1的长度，n是数组num2的长度
     * 空间复杂度：O(m+n)，其中m是数组num1的长度，n是数组num2的长度
     *
     * @param firstNumbers  第一个数组
     * @param secondNumbers 第二个数组
     * @return 结果
     */
    public static double findMedianSortedArrays(int[] firstNumbers, int[] secondNumbers) {
        int len1 = firstNumbers.length;
        int len2 = secondNumbers.length;
        int index = 0;
        int i = 0;
        int j = 0;
        // 合并两个数组
        int[] arrays = new int[len1 + len2];
        while (i < len1 || j < len2) {
            if (i == len1) {
                arrays[index++] = secondNumbers[j++];
            } else if (j == len2) {
                arrays[index++] = firstNumbers[i++];
            } else if (firstNumbers[i] < secondNumbers[j]) {
                arrays[index++] = firstNumbers[i++];
            } else {
                arrays[index++] = secondNumbers[j++];
            }
        }
        // 找出数组的中位数
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
