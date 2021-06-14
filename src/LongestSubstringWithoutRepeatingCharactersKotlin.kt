import kotlin.math.max

/**
 * Created by TanJiaJun on 2021/6/6.
 * 3. 无重复字符的最长子串（Longest Substring Without Repeating Characters）
 * 难度：中等
 *
 * @see <a href="https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/">Longest Substring Without Repeating Characters</a>
 */
object LongestSubstringWithoutRepeatingCharactersKotlin {

    @JvmStatic
    fun main(args: Array<String>) {
        // 示例一
        print("示例一：")

        val firstStr = "abcabcbb"
        println(lengthOfLongestSubstring(firstStr))

        print("\n")

        // 示例二
        print("示例二：")

        val secondStr = "bbbbb"
        println(lengthOfLongestSubstring(secondStr))

        print("\n")

        // 示例三
        print("示例三：")

        val thirdStr = "pwwkew"
        println(lengthOfLongestSubstring(thirdStr))
    }

    /**
     * 方法：滑动窗口
     * 时间复杂度：O(N)，其中N是字符串的长度
     * 空间复杂度：O(∣Σ∣)，其中Σ表示字符串中出现的字符集合，∣Σ∣表示该字符集合的大小，默认为所有ASCII码为[0,128)内的字符，也就是大小是128
     *
     * @param str 字符串
     * @return 结果
     */
    private fun lengthOfLongestSubstring(str: String): Int {
        // 结果
        var result = 0
        // 右指针
        var right = 0
        // 哈希集合，记录出现的字符
        val chars = hashSetOf<Char>()
        // 遍历字符串中的字符
        str.forEachIndexed { index, _ ->
            if (index > 0) {
                // 移除一个字符，左指针向右移动一格
                chars.remove(str[index - 1])
            }
            while (right < str.length && !chars.contains(str[right])) {
                // 如果索引小于字符串的长度，同时该字符没出现过，就将该字符放到哈希集合中，然后右指针向右移动一格
                chars.add(str[right])
                right++
            }
            // 计算长度的最大值
            result = max(result, right - index)
        }
        return result
    }
}