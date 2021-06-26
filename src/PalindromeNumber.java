/**
 * Created by TanJiaJun on 2021/6/19.
 * 9. 回文数（Palindrome Number）
 * 难度：简单
 *
 * @see <a href="https://leetcode-cn.com/problems/palindrome-number/">Palindrome Number</a>
 */
class PalindromeNumber {

    public static void main(String[] args) {
        // 示例一
        System.out.print("示例一：");

        int firstNumber = 121;
        System.out.println(isPalindrome(firstNumber));

        System.out.print("\n");

        // 示例二
        System.out.print("示例二：");

        int secondNumber = -121;
        System.out.println(isPalindrome(secondNumber));

        System.out.print("\n");

        // 示例三
        System.out.print("示例三：");

        int thirdNumber = 10;
        System.out.println(isPalindrome(thirdNumber));

        System.out.print("\n");

        // 示例四
        System.out.print("示例四：");

        int fourthNumber = -101;
        System.out.println(isPalindrome(fourthNumber));
    }

    /**
     * 时间复杂度：O(N)，其中N是整型x的位数
     * 空间复杂度：O(N)，其中N是整型x的位数，因为要创建长度为位数的字符串
     *
     * @param x 整型x
     * @return 结果
     */
    private static boolean isPalindrome(int x) {
        // 将整型x转为字符串
        String str = String.valueOf(x);
        int length = str.length();
        // 只需要遍历该字符串长度一半就可以了
        for (int i = 0; i < length / 2; i++) {
            // 因为回文串的特性，我们可以用该字符和索引为length-i-1的字符比较是否相同就可以判断了
            if (str.charAt(i) != str.charAt(length - i - 1)) {
                // 只要有一个不相同，证明不是回文串
                return false;
            }
        }
        // 如果都相同，证明是回文串
        return true;
    }

}