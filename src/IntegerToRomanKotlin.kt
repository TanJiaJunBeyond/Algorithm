/**
 * Created by TanJiaJun on 2021/7/21.
 * 12. 整数转罗马数字（Integer to Roman）
 * 难度：中等
 *
 * @see <a href="https://leetcode-cn.com/problems/integer-to-roman/">Integer to Roman</a>
 */
object IntegerToRomanKotlin {

    @JvmStatic
    fun main(args: Array<String>) {
        // 示例一
        print("示例一：")

        val firstNumber = 3
        println(intToRoman(firstNumber))

        print("\n")

        // 示例二
        print("示例二：")

        val secondNumber = 4
        println(intToRoman(secondNumber))

        print("\n")

        // 示例三
        print("示例三：")

        val thirdNumber = 58
        println(intToRoman(thirdNumber))

        print("\n")

        // 示例四
        print("示例四：")

        val fourthNumber = 1994
        println(intToRoman(fourthNumber))
    }

    /**
     * 贪心算法
     * 时间复杂度：O(N)，其中N是数组num的位数
     * 空间复杂度：O(1)
     *
     * @param num 要转成罗马数字的整数
     * @return 罗马数字
     */
    private fun intToRoman(num: Int): String =
            StringBuilder()
                    .apply {
                        var number = num
                        // 枚举罗马数字七种字符
                        val strs = arrayOf("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I")
                        // 枚举罗马数字七种字符对应的整数
                        val ints = intArrayOf(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
                        var index = 0
                        while (index < 13) {
                            if (number >= ints[index]) {
                                // 如果该数值大于枚举的罗马数字对应的整数，就用这个数值减去该整数，并且赋值给num
                                number -= ints[index]
                                // 将该罗马数字记录下来
                                append(strs[index])
                            } else {
                                // 如果该数值小于枚举的罗马数字对应的整数，就索引往右边移动一格
                                index++
                            }
                        }
                    }
                    .toString()

}