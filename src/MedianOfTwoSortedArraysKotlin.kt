/**
 * Created by TanJiaJun on 2021/6/13.
 * 4. 寻找两个正序数组的中位数（Median of Two Sorted Arrays）
 *
 * @see <a href="https://leetcode-cn.com/problems/median-of-two-sorted-arrays/">Median of Two Sorted Arrays</a>
 */
object MedianOfTwoSortedArraysKotlin {

    @JvmStatic
    fun main(args: Array<String>) {
        val firstNumbers = intArrayOf(1, 3)
        val secondNumbers = intArrayOf(2)
        println(findMedianSortedArrays(firstNumbers, secondNumbers))

        val thirdNumbers = intArrayOf(1, 2)
        val fourthNumbers = intArrayOf(3, 4)
        println(findMedianSortedArrays(thirdNumbers, fourthNumbers))
    }

    private fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val size1 = nums1.size
        val size2 = nums2.size
        var index = 0
        var i = 0
        var j = 0
        val arrays = IntArray(size1 + size2)
        while (i < size1 || j < size2) {
            when {
                i == size1 -> arrays[index++] = nums2[j++]
                j == size2 -> arrays[index++] = nums1[i++]
                nums1[i] < nums2[j] -> arrays[index++] = nums1[i++]
                else -> arrays[index++] = nums2[j++]
            }
        }
        val size = arrays.size
        return if (size % 2.0 == 0.0) {
            (arrays[size / 2] + arrays[size / 2 - 1]) / 2.0
        } else {
            arrays[size / 2].toDouble()
        }
    }
}