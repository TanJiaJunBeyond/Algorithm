import kotlin.math.min

/**
 * Created by TanJiaJun on 2021/7/24.
 * 14. 最长公共前缀（Longest Common Prefix）
 * 难度：简单
 *
 * @see <a href="https://leetcode-cn.com/problems/longest-common-prefix/">Longest Common Prefix</a>
 */
object LongestCommonPrefixKotlin {

    @JvmStatic
    fun main(args: Array<String>) {
        val firstStrs = arrayOf("flower", "flow", "flight")
        println(longestCommonPrefix(firstStrs))

        val secondStrs = arrayOf("dog", "racecar", "car")
        println(longestCommonPrefix(secondStrs))
    }

    private fun longestCommonPrefix(strs: Array<String>): String {
        var result: String = strs[0]
        for (i in 1 until strs.size) {
            result = getLongestCommonPrefix(result, strs[i])
            if (result.isEmpty) {
                break
            }
        }
        return result
    }

    private fun getLongestCommonPrefix(firstStr: String, secondStr: String): String {
        val length = min(firstStr.length, secondStr.length)
        var index = 0
        while (index < length && firstStr[index] == secondStr[index]) {
            index++
        }
        return firstStr.substring(0, index)
    }

}