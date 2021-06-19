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
        println(findMedianSortedArrays(firstNumbers, secondNumbers))

        print("\n")

        // 示例二
        println("示例二：")

        val thirdNumbers = intArrayOf(1, 2)
        val fourthNumbers = intArrayOf(3, 4)
        println(findMedianSortedArrays(thirdNumbers, fourthNumbers))

        print("\n")

        // 示例三
        println("示例三：")

        val fifthNumbers = intArrayOf(0, 0)
        val sixthNumbers = intArrayOf(0, 0)
        println(findMedianSortedArrays(fifthNumbers, sixthNumbers))

        print("\n")

        // 示例四
        println("示例四：")

        val seventhNumbers = intArrayOf()
        val eightNumbers = intArrayOf(1)
        println(findMedianSortedArrays(seventhNumbers, eightNumbers))

        print("\n")

        // 示例五
        println("示例五：")

        val ninthNumbers = intArrayOf(2)
        val tenthNumbers = intArrayOf()
        println(findMedianSortedArrays(ninthNumbers, tenthNumbers))
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
        // 合并后的数组的索引
        var index = 0
        // 第一个数组的指针，下面用i指针描述
        var i = 0
        // 第二个数组的指针，下面用j指针描述
        var j = 0
        // 合并两个数组
        // 创建一个大小是两个数组长度之和的数组
        val arrays = IntArray(size1 + size2)
        while (i < size1 || j < size2) {
            when {
                // 如果第一个数组遍历完毕后，就继续遍历第二个数组
                i == size1 -> arrays[index++] = nums2[j++]
                // 如果第二个数组遍历完毕后，就继续遍历第一个数组
                j == size2 -> arrays[index++] = nums1[i++]
                // 如果第一个数组的元素小于第二个数组的元素，就将第一个数组中的该元素添加到合并后的新数组，同时将i指针向右移动一格
                nums1[i] < nums2[j] -> arrays[index++] = nums1[i++]
                // 如果第一个数组的元素大于第二个数组的元素，就将第二个数组中的该元素添加到合并后的新数组，同时将j指针向右移动一格
                else -> arrays[index++] = nums2[j++]
            }
        }
        // 找出数组的中位数
        val size = arrays.size
        return if (size % 2.0 == 0.0) {
            // 如果数组长度是偶数，就找出这条中线旁边的两个元素，然后相加之后除以2得到结果
            (arrays[size / 2] + arrays[size / 2 - 1]) / 2.0
        } else {
            // 如果数组长度是奇数，就找出这条中线对应的元素，该元素就是结果
            arrays[size / 2].toDouble()
        }
    }
}