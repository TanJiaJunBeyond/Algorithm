/**
 * Created by TanJiaJun on 2021/6/19.
 * 9. 回文数（Palindrome Number）
 * 难度：简单
 *
 * @see <a href="https://leetcode-cn.com/problems/palindrome-number/">Palindrome Number</a>
 */
class PalindromeNumber {

    public static void main(String[] args) {
        int firstNumber = 121;
        System.out.println(isPalindrome(firstNumber));

        int secondNumber = -121;
        System.out.println(isPalindrome(secondNumber));

        int thirdNumber = 10;
        System.out.println(isPalindrome(thirdNumber));

        int fourthNumber = -101;
        System.out.println(isPalindrome(fourthNumber));
    }

    private static boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        int length = str.length();
        for (int i = 0; i < length / 2; i++) {
            if (str.charAt(i) != str.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }

}