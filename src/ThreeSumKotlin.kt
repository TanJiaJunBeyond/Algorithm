import java.util.*

/**
 * Created by TanJiaJun on 2021/7/25.
 * 15. 三数之和（3Sum）
 * 难度：中等
 *
 * @see <a href="https://leetcode-cn.com/problems/3sum/">3Sum</a>
 */
object ThreeSumKotlin {

    @JvmStatic
    fun main(args: Array<String>) {
        val firstNums = intArrayOf(-1, 0, 1, 2, -1, -4)
        println(threeSum(firstNums))

        val secondNums = intArrayOf()
        println(threeSum(secondNums))

        val thirdNums = intArrayOf(0)
        println(threeSum(thirdNums))
    }

    private fun threeSum(nums: IntArray): List<List<Int>> =
            mutableListOf<List<Int>>().apply {
                Arrays.sort(nums)
                if (nums.size > 2) {
                    for (i in nums.indices) {
                        if (i > 0 && nums[i] == nums[i - 1]) {
                            continue
                        }
                        var left = i + 1
                        var right = nums.size - 1
                        while (left < right) {
                            val sum = nums[i] + nums[left] + nums[right]
                            when {
                                sum < 0 -> left++
                                sum > 0 -> right--
                                else -> {
                                    add(listOf(nums[i], nums[left], nums[right]))
                                    left++
                                    right--
                                }
                            }
                        }
                    }
                }
            }

}