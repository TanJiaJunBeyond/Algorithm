/**
 * Created by TanJiaJun on 2021/6/5.
 * 1. 两数之和（Two Sum）
 * 难度：简单
 *
 * @see <a href="https://leetcode-cn.com/problems/two-sum/">Two Sum</a>
 */
object TwoSumKotlin {

    @JvmStatic
    fun main(args: Array<String>) {
        // 示例一
        println("示例一")

        val firstNumbers = intArrayOf(2, 7, 11, 15)
        val firstTarget = 9
        println(hashTwoSum(firstNumbers, firstTarget).contentToString())

        print("\n")

        // 示例二
        println("示例二")

        val secondNumbers = intArrayOf(3, 2, 4)
        val secondTarget = 6
        println(hashTwoSum(secondNumbers, secondTarget).contentToString())

        print("\n")

        // 示例三
        println("示例三")
        val thirdNumbers = intArrayOf(3, 3)
        val thirdTarget = 6
        println(hashTwoSum(thirdNumbers, thirdTarget).contentToString())
    }

    /**
     * 方法一：枚举
     * 时间复杂度：O(N^2)，其中N是数组的元素数量
     * 空间复杂度：O(1)
     *
     * @param numbers int类型的数组
     * @param target  目标值
     * @return 结果
     */
    private fun twoSum(numbers: IntArray, target: Int): IntArray {
        numbers.forEachIndexed { index, number ->
            for (i in index + 1 until numbers.size) {
                if (number + numbers[i] == target) {
                    return intArrayOf(index, i)
                }
            }
        }
        return intArrayOf()
    }

    /**
     * 方法二：哈希表
     * 时间复杂度：O(N)，其中N是数组的元素数量
     * 空间复杂度：O(N)，其中N是数组的元素数量
     *
     * @param numbers int类型的数组
     * @param target  目标值
     * @return 结果
     */
    private fun hashTwoSum(numbers: IntArray, target: Int): IntArray {
        mutableMapOf<Int, Int>().apply {
            numbers.forEachIndexed { index, number ->
                val other = target - number
                if (containsKey(other)) {
                    val otherIndex = get(other) ?: 0
                    return intArrayOf(otherIndex, index)
                }
                put(number, index)
            }
        }
        return intArrayOf()
    }

}