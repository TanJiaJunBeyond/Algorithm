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
        // 示例一
        print("示例一：")

        val firstStrs = arrayOf("flower", "flow", "flight")
        println(longestCommonPrefix(firstStrs))

        print("\n")

        // 示例二
        print("示例二：")

        val secondStrs = arrayOf("dog", "racecar", "car")
        println(longestCommonPrefix(secondStrs))
    }

    /**
     * 横向扫描
     *
     * 时间复杂度：O(mn)，其中m是字符串数组strs中的字符串平均长度，n是字符串数组strs的长度。
     * 空间复杂度：O(1)，使用的空间复杂度为常数。
     *
     * @param strs 字符串数据
     * @return 最长公共前缀字符串
     */
    private fun longestCommonPrefix(strs: Array<String>): String {
        var result: String = strs[0]
        for (i in 1 until strs.size) {
            // 得到当前两个字符串的公共前缀
            result = getLongestCommonPrefix(result, strs[i])
            if (result.isEmpty()) {
                // 如果结果返回空字符串，说明当前两个字符串不存在公共前缀，证明该字符串数组中所有字符串之间不存在公共前缀，
                // 所以跳出循环，不再遍历剩下的字符串，返回空字符串
                break
            }
        }
        return result
    }

    /**
     * 得到两个字符串的公共前缀
     *
     * @param firstStr 第一个字符串
     * @param secondStr 第二个字符串
     * @return 两个字符串的最长公共前缀字符串，要注意的是，如果没有的话，就返回空字符串
     */
    private fun getLongestCommonPrefix(firstStr: String, secondStr: String): String {
        // 得到两个字符串的最小长度
        val minLen = min(firstStr.length, secondStr.length)
        var index = 0
        // 遍历两个字符串的字符
        while (index < minLen && firstStr[index] == secondStr[index]) {
            // 如果索引小于最短长度，并且当前两个字符串的字符相同，就增加索引值
            index++
        }
        // 截取两个字符串的公共前缀，要注意的是，如果找不到公共前缀会返回空字符串
        return firstStr.substring(0, index)
    }

}