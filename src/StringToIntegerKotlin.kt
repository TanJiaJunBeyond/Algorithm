import java.util.regex.Pattern

/**
 * Created by TanJiaJun on 2021/6/26.
 * 8. 字符串转整数（atoi）（String to Integer(atoi)）
 * 难度：简单
 *
 * @see <a href="https://leetcode-cn.com/problems/string-to-integer-atoi/">String to Integer(atoi)</a>
 */
object StringToIntegerKotlin {

    @JvmStatic
    fun main(args: Array<String>) {
        // 示例一
        print("示例一：")

        val firstStr = "42"
        println(myAtoi(firstStr))

        print("\n")

        // 示例二
        print("示例二：")

        val secondStr = "-42"
        println(myAtoi(secondStr))

        print("\n")

        // 示例三
        print("示例三：")

        val thirdStr = "4193 with words"
        println(myAtoi(thirdStr))

        print("\n")

        // 示例四
        print("示例四：")

        val fourthStr = "words and 987"
        println(myAtoi(fourthStr))

        print("\n")

        // 示例五
        print("示例五：")

        val fifthStr = "-91283472332"
        println(myAtoi(fifthStr))
    }

    /**
     * 时间复杂度：O(N)，其中N是字符串的长度
     * 空间复杂度：O(1)
     *
     * @param s 字符串
     * @return 结果
     */
    private fun myAtoi(s: String): Int {
        // 去掉字符串前面和后面的空格
        val str = s.trim()
        // ^[\+\-]?的意思是判断字符是否匹配+或者-，匹配零次或者一次
        // \d+的意思是判断字符是否匹配[0-9]，匹配一次或者多次
        val pattern = Pattern.compile("^[\\+\\-]?\\d+")
        val matcher = pattern.matcher(str)
        var result = 0
        if (matcher.find()) {
            result = try {
                str.toInt()
            } catch (exception: NumberFormatException) {
                // 如果抛出NumberFormatException异常，证明小于整型的最小值，大于整型的最大值
                if (str[0] == '-') Int.MIN_VALUE else Int.MAX_VALUE
            }
        }
        return result
    }
}