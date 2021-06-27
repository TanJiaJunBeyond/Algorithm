/**
 * Created by TanJiaJun on 2021/6/26.
 * 7. 整数反转（Reverse Integer）
 * 难度：简单
 *
 * @see <a href="https://leetcode-cn.com/problems/reverse-integer/">Reverse Integer</a>
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

    /**
     * 时间复杂度：O(log|n|)，其中n是整型x的位数
     * 空间复杂度：O(1)
     *
     * @param x 整型x
     * @return 结果
     */
    private fun reverse(x: Int): Int {
        var result = 0
        var number = x
        while (number != 0) {
            // 得到最后一位，例如：123的3
            val digit = number % 10
            if (result < -214748364 || (result == -214748364 && digit < -8)) {
                // 判断结果是否小于Integer.MIN_VALUE，也就是是否小于-2147483648
                return 0
            }
            if (result > 214748364 || (result == 214748364 && digit > 7)) {
                // 判断结果是否大于Integer.MAX_VALUE，也就是是否大于2147483647
                return 0
            }
            // 得到除了最后一位的前几位，例如：123的12
            number /= 10
            result = result * 10 + digit
        }
        return result
    }

}