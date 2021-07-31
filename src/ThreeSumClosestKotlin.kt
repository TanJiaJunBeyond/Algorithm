import java.util.*
import kotlin.math.abs

/**
 * Created by TanJiaJun on 2021/7/31.
 */
object ThreeSumClosestKotlin {

    @JvmStatic
    fun main(args: Array<String>) {
        val firstNums = intArrayOf(-1, 2, 1, -4)
        val firstTarget = 1
        println(threeSumClosest(firstNums, firstTarget))
    }

    private fun threeSumClosest(nums: IntArray, target: Int): Int {
        Arrays.sort(nums)
        var result = nums[0] + nums[1] + nums[2]
        for (i in nums.indices) {
            var left = i + 1
            var right = nums.size - 1
            while (left < right) {
                val sum = nums[i] + nums[left] + nums[right]
                if (abs(target - sum) < abs(target - result)) {
                    result = sum
                }
                if (sum < target) {
                    left++
                } else if (sum > target) {
                    right--
                } else {
                    result = sum
                    break
                }
            }
        }
        return result
    }

}