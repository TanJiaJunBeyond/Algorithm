/**
 * Created by TanJiaJun on 2021/6/26.
 * 9. 回文数（Palindrome Number）
 * 难度：简单
 *
 * @see <a href="https://leetcode-cn.com/problems/palindrome-number/">Palindrome Number</a>
 */
object PalindromeNumberKotlin {

    @JvmStatic
    fun main(args: Array<String>) {
        // 示例一
        print("示例一：")

        val firstNumber = 121
        println(isPalindrome(firstNumber))

        print("\n")

        // 示例二
        print("示例二：")

        val secondNumber = -121
        println(isPalindrome(secondNumber))

        print("\n")

        // 示例三
        print("示例三：")

        val thirdNumber = 10
        println(isPalindrome(thirdNumber))

        print("\n")

        // 示例四
        print("示例四：")

        val fourthNumber = -101
        println(isPalindrome(fourthNumber))

        print("\n")
    }

    /**
     * 时间复杂度：O(N)，其中N是整型x的位数
     * 空间复杂度：O(N)，其中N是整型x的位数，因为要创建长度为位数的字符串
     *
     * @param x 整型x
     * @return 结果
     */
    private fun isPalindrome(x: Int): Boolean {
        // 将整型x转为字符串
        val str = x.toString()
        val length = str.length
        // 只需要遍历该字符串长度一半就可以了
        for (i in 0 until length / 2) {
            // 因为回文串的特性，我们可以用该字符和索引为length-i-1的字符比较是否相同就可以判断了
            if (str[i] != str[length - i - 1]) {
                // 只要有一个不相同，证明不是回文串
                return false
            }
        }
        // 如果都相同，证明是回文串
        return true
    }

}