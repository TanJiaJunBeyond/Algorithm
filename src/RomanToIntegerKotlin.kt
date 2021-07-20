/**
 * Created by TanJiaJun on 2021/7/21.
 * 13. 罗马数字转整数（Roman to Integer）
 * 难度：简单
 *
 * @see <a href="https://leetcode-cn.com/problems/roman-to-integer/">Roman to Integer</a>
 */
object RomanToIntegerKotlin {

    @JvmStatic
    fun main(args: Array<String>) {
        // 示例一
        print("示例一：")

        val firstStr = "III"
        println(romanToInt(firstStr))

        print("\n")

        // 示例二
        print("示例二：")

        val secondStr = "IV"
        println(romanToInt(secondStr))

        print("\n")

        // 示例三
        print("示例三：")

        val thirdStr = "IX"
        println(romanToInt(thirdStr))

        print("\n")

        // 示例四
        print("示例四：")

        val fourthStr = "LVIII"
        println(romanToInt(fourthStr))

        print("\n")

        // 示例五
        print("示例五：")

        val fifthStr = "MCMXCIV"
        println(romanToInt(fifthStr))
    }

    /**
     * 时间复杂度：O(N)，其中N是字符串s的长度
     * 空间复杂度：O(1)
     *
     * @param s 罗马数字
     * @return 整数
     */
    private fun romanToInt(s: String): Int {
        // 得到第一个罗马数字
        var preNum = getInteger(s[0])
        var result = 0
        var i = 1
        val length = s.length
        while (i < length) {
            val num = getInteger(s[i])
            // 用这个数字的前一个数字与其比较
            if (preNum < num) {
                // 根据题义可知，如果这个数字大于前一个数字，就做减法运算，减去前一个数字
                result -= preNum
            } else {
                // 根据题义可知，如果这个数字小于前一个数字，就做加法运算，加上前一个数字
                result += preNum
            }
            // 记录前一个数字
            preNum = num
            i++
        }
        // 相加得出最后的结果
        result += preNum
        return result
    }

    /**
     * 通过罗马数字字符得到对应的整数
     *
     * @param roman 罗马数字字符
     * @return 整数
     */
    private fun getInteger(roman: Char): Int =
            // 枚举罗马数字七种字符和对应的整数
            when (roman) {
                'I' -> 1
                'V' -> 5
                'X' -> 10
                'L' -> 50
                'C' -> 100
                'D' -> 500
                'M' -> 1000
                else -> 0
            }

}