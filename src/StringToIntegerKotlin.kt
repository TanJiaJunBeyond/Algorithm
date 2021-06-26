import java.util.regex.Pattern

/**
 * Created by TanJiaJun on 2021/6/26.
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

    private fun myAtoi(s: String): Int {
        val pattern = Pattern.compile("^[\\+\\-]?\\d+")
        val matcher = pattern.matcher(s)
        var result = 0
        if (matcher.find()) {
            result = try {
                s.toInt()
            } catch (exception: NumberFormatException) {
                if (s[0] == '-') Int.MIN_VALUE else Int.MAX_VALUE
            }
        }
        return result
    }
}