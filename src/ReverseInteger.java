/**
 * Created by TanJiaJun on 2021/6/15.
 * 7. 整数反转（Reverse Integer）
 * 难度：简单
 *
 * @see <a href="https://leetcode-cn.com/problems/reverse-integer/">Reverse Integer</a>
 */
class ReverseInteger {

    public static void main(String[] args) {
        int firstNumber = 123;
        System.out.println(reverse(firstNumber));

        int secondNumber = -123;
        System.out.println(reverse(secondNumber));

        int thirdNumber = 120;
        System.out.println(reverse(thirdNumber));

        int fourthNumber = 0;
        System.out.println(reverse(fourthNumber));
    }

    private static int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int digit = x % 10;
            if (result < -214748364 || (result == -214748364 && digit < -8)) {
                return 0;
            }
            if (result > 214748364 || (result == 214748364 && digit > 7)) {
                return 0;
            }
            x /= 10;
            result = result * 10 + digit;
        }
        return result;
    }

}