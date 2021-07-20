/**
 * Created by TanJiaJun on 2021/6/27.
 * 12. 整数转罗马数字（Integer to Roman）
 * 难度：中等
 *
 * @see <a href="https://leetcode-cn.com/problems/integer-to-roman/">Integer to Roman</a>
 */
class IntegerToRoman {

    public static void main(String[] args) {
        // 示例一
        System.out.print("示例一：");

        int firstNumber = 3;
        System.out.println(intToRoman(firstNumber));

        System.out.print("\n");

        // 示例二
        System.out.print("示例二：");

        int secondNumber = 4;
        System.out.println(intToRoman(secondNumber));

        System.out.print("\n");

        // 示例三
        System.out.print("示例三：");

        int thirdNumber = 58;
        System.out.println(intToRoman(thirdNumber));

        System.out.print("\n");

        // 示例四
        System.out.print("示例四：");

        int fourthNumber = 1994;
        System.out.println(intToRoman(fourthNumber));
    }

    /**
     * 贪心算法
     * 时间复杂度：O(N)，其中N是数组num的位数
     * 空间复杂度：O(1)
     *
     * @param num 要转成罗马数字的整数
     * @return 罗马数字
     */
    private static String intToRoman(int num) {
        // 枚举罗马数字七种字符
        String[] strs = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        // 枚举罗马数字七种字符对应的整数
        int[] ints = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        while (index < 13) {
            if (num >= ints[index]) {
                // 如果该数值大于枚举的罗马数字对应的整数，就用这个数值减去该整数，并且赋值给num
                num -= ints[index];
                // 将该罗马数字记录下来
                stringBuilder.append(strs[index]);
            } else {
                // 如果该数值小于枚举的罗马数字对应的整数，就索引往右边移动一格
                index++;
            }
        }
        return stringBuilder.toString();
    }

}