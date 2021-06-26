/**
 * Created by TanJiaJun on 2021/6/15.
 * 7. 整数反转（Reverse Integer）
 * 难度：简单
 *
 * @see <a href="https://leetcode-cn.com/problems/reverse-integer/">Reverse Integer</a>
 */
class ReverseInteger {

    public static void main(String[] args) {
        // 示例一
        System.out.print("示例一：");

        int firstNumber = 123;
        System.out.println(reverse(firstNumber));

        System.out.print("\n");

        // 示例二
        System.out.print("示例二：");

        int secondNumber = -123;
        System.out.println(reverse(secondNumber));

        System.out.print("\n");

        // 示例三
        System.out.print("示例三：");

        int thirdNumber = 120;
        System.out.println(reverse(thirdNumber));

        System.out.print("\n");

        // 示例四
        System.out.print("示例四：");

        int fourthNumber = 0;
        System.out.println(reverse(fourthNumber));

        System.out.print("\n");
    }

    /**
     * 时间复杂度：O(log|n|)，其中n是整型x的位数
     * 空间复杂度：O(1)
     *
     * @param x 整型x
     * @return 结果
     */
    private static int reverse(int x) {
        int result = 0;
        while (x != 0) {
            // 得到最后一位，例如：123的3
            int digit = x % 10;
            if (result < -214748364 || (result == -214748364 && digit < -8)) {
                // 判断结果是否小于Integer.MIN_VALUE，也就是是否小于-2147483648
                return 0;
            }
            if (result > 214748364 || (result == 214748364 && digit > 7)) {
                // 判断结果是否大于Integer.MAX_VALUE，也就是是否大于2147483647
                return 0;
            }
            // 得到除了最后一位的前几位，例如：123的12
            x /= 10;
            result = result * 10 + digit;
        }
        return result;
    }

}