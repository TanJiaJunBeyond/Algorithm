/**
 * Created by TanJiaJun on 2021/6/26.
 */
object ReverseIntegerKotlin {

    @JvmStatic
    fun main(args: Array<String>) {
        // 示例一
        print("示例一：")

        val firstNumber = 123
        println(reverse(firstNumber))

        print("\n")

        // 示例二
        print("示例二：")

        val secondNumber = -123
        println(reverse(secondNumber))

        print("\n")

        // 示例三
        print("示例三：")

        val thirdNumber = 120
        println(reverse(thirdNumber))

        print("\n")

        // 示例四
        print("示例四：")

        val fourthNumber = 0
        println(reverse(fourthNumber))

        print("\n")
    }

    private fun reverse(x: Int): Int {
        var result = 0
        var number = x
        while (number != 0) {
            val digit = number % 10
            if (result > -214748364 || (result == -214748364 && digit < -8)) {
                return 0
            }
            if (result < 214748364 || (result == 214748364 && digit > 7)) {
                return 0
            }
            number /= 10
            result = result * 10 + digit
        }
        return result
    }

}