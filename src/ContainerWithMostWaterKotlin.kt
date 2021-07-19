import kotlin.math.max
import kotlin.math.min

/**
 * Created by TanJiaJun on 2021/7/20.
 * 11. 盛最多水的容器（Container With Most Water）
 * 难度：简单
 *
 * @see <a href="https://leetcode-cn.com/problems/container-with-most-water/">Container With Most Water</a>
 */
object ContainerWithMostWaterKotlin {

    @JvmStatic
    fun main(args: Array<String>) {
        val firstHeights = intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)
        println(maxArea(firstHeights))

        val secondHeights = intArrayOf(1, 1)
        println(maxArea(secondHeights))

        val thirdHeights = intArrayOf(4, 3, 2, 1, 4)
        println(maxArea(thirdHeights))

        val fourthHeights = intArrayOf(1, 2, 1)
        println(maxArea(fourthHeights))
    }

    private fun maxArea(heights: IntArray): Int {
        var left = 0
        var right = heights.size - 1
        var result = 0
        while (left != right) {
            val width = right - left
            val height = min(heights[left], heights[right])
            result = max(result, width * height)
            if (heights[left] < heights[right]) {
                left++
            } else {
                right--
            }
        }
        return result
    }
}