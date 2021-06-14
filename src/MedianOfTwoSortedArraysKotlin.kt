/**
 * Created by TanJiaJun on 2021/6/13.
 * 4. 寻找两个正序数组的中位数（Median of Two Sorted Arrays）
 * 难度：困难
 *
 * @see <a href="https://leetcode-cn.com/problems/median-of-two-sorted-arrays/">Median of Two Sorted Arrays</a>
 */
object MedianOfTwoSortedArraysKotlin {

    @JvmStatic
    fun main(args: Array<String>) {
        // 示例一
        println("示例一：")

        val firstNumbers = intArrayOf(1, 3)
        val secondNumbers = intArrayOf(2)
        println(MedianOfTwoSortedArrays.findMedianSortedArrays(firstNumbers, secondNumbers))

        print("\n")

        // 示例二
        println("示例二：")

        val thirdNumbers = intArrayOf(1, 2)
        val fourthNumbers = intArrayOf(3, 4)
        println(MedianOfTwoSortedArrays.findMedianSortedArrays(thirdNumbers, fourthNumbers))

        print("\n")

        // 示例三
        println("示例三：")

        val fifthNumbers = intArrayOf(0, 0)
        val sixthNumbers = intArrayOf(0, 0)
        println(MedianOfTwoSortedArrays.findMedianSortedArrays(fifthNumbers, sixthNumbers))

        print("\n")

        // 示例四
        println("示例四：")

        val seventhNumbers = intArrayOf()
        val eightNumbers = intArrayOf(1)
        println(MedianOfTwoSortedArrays.findMedianSortedArrays(seventhNumbers, eightNumbers))

        print("\n")

        // 示例五
        println("示例五：")

        val ninthNumbers = intArrayOf(2)
        val tenthNumbers = intArrayOf()
        println(MedianOfTwoSortedArrays.findMedianSortedArrays(ninthNumbers, tenthNumbers))
    }

    /**
     * 双指针
     * 时间复杂度：O(m+n)，其中m是数组num1的长度，n是数组num2的长度
     * 空间复杂度：O(m+n)，其中m是数组num1的长度，n是数组num2的长度
     *
     * @param nums1 第一个数组
     * @param nums2 第二个数组
     * @return 结果
     */
    private fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val size1 = nums1.size
        val size2 = nums2.size
        var index = 0
        var i = 0
        var j = 0
        // 合并两个数组
        val arrays = IntArray(size1 + size2)
        while (i < size1 || j < size2) {
            when {
                i == size1 -> arrays[index++] = nums2[j++]
                j == size2 -> arrays[index++] = nums1[i++]
                nums1[i] < nums2[j] -> arrays[index++] = nums1[i++]
                else -> arrays[index++] = nums2[j++]
            }
        }
        // 找出数组的中位数
        val size = arrays.size
        return if (size % 2.0 == 0.0) {
            (arrays[size / 2] + arrays[size / 2 - 1]) / 2.0
        } else {
            arrays[size / 2].toDouble()
        }
    }
}