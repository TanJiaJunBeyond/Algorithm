import kotlin.math.max

/**
 * Created by TanJiaJun on 2021/6/14.
 * 5. 最长回文子串（Longest Palindromic Substring）
 * 难度：中等
 *
 * @see <a href="https://leetcode-cn.com/problems/longest-palindromic-substring/">Longest Palindromic Substring</a>
 */
object LongestPalindromicSubstringKotlin {

    @JvmStatic
    fun main(args: Array<String>) {
        // 示例一
        print("示例一：")

        val firstStr = "babad"
        println(expandAroundCenterLongestPalindrome(firstStr))

        print("\n")

        // 示例二
        print("示例二：")

        val secondStr = "cbbd"
        println(expandAroundCenterLongestPalindrome(secondStr))

        print("\n")

        // 示例三
        print("示例三：")

        val thirdStr = "a"
        println(expandAroundCenterLongestPalindrome(thirdStr))

        print("\n")

        // 示例四
        print("示例四：")

        val fourthStr = "ac"
        println(expandAroundCenterLongestPalindrome(fourthStr))
    }

    /**
     * 方法一：枚举算法
     * 时间复杂度：O(N^3)，其中N是字符串的长度
     * 空间复杂度：O(1)
     *
     * @param str 字符串
     * @return 结果
     */
    private fun longestPalindrome(str: String): String {
        var maxLength = 0
        var result = ""
        str.forEachIndexed { index, _ ->
            for (i in index + 1..str.length) {
                val substring = str.substring(index, i)
                if (isPalindromicSubstring(substring) && substring.length > maxLength) {
                    maxLength = substring.length
                    result = substring
                }
            }
        }
        return result
    }

    /**
     * 判断是否为回文子串
     *
     * @param str 字符串
     * @return 结果
     */
    private fun isPalindromicSubstring(str: String): Boolean {
        val length = str.length
        for (i in 0 until length / 2) {
            if (str[i] != str[length - i - 1]) {
                return false
            }
        }
        return true
    }

    /**
     * 方法二：中心扩展法（双指针）
     * 时间复杂度：O(N^2)，其中N是字符串的长度
     * 空间复杂度：O(1)
     *
     * @param str 字符串
     * @return 结果
     */
    private fun expandAroundCenterLongestPalindrome(str: String): String {
        var start = 0
        var end = 0
        str.forEachIndexed { index, c ->
            val oddLength = getExpandAroundCenterLength(str = str, left = index, right = index)
            val evenLength = getExpandAroundCenterLength(str = str, left = index, right = index + 1)
            val maxLength = max(oddLength, evenLength)
            if (maxLength > end - start) {
                start = index - (maxLength - 1) / 2
                end = index + maxLength / 2
            }
        }
        return str.substring(start, end + 1)
    }

    /**
     * 得到中心往两边扩展的长度
     *
     * @param str   字符串
     * @param left  左指针
     * @param right 右指针
     * @return 长度
     */
    private fun getExpandAroundCenterLength(str: String, left: Int, right: Int): Int {
        var l = left
        var r = right
        while ((l >= 0 && r < str.length && str[l] == str[r])) {
            l--
            r++
        }
        return r - l - 1
    }

}