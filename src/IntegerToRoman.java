/**
 * Created by TanJiaJun on 2021/6/27.
 * 12. 整数转罗马数字（Integer to Roman）
 * 难度：中等
 *
 * @see <a href="https://leetcode-cn.com/problems/integer-to-roman/">Integer to Roman</a>
 */
class IntegerToRoman {

    public static void main(String[] args) {
        int firstNumber = 3;
        System.out.println(intToRoman(firstNumber));

        int secondNumber = 4;
        System.out.println(intToRoman(secondNumber));

        int thirdNumber = 58;
        System.out.println(intToRoman(thirdNumber));

        int fourthNumber = 1994;
        System.out.println(intToRoman(fourthNumber));
    }

    private static String intToRoman(int num) {
        String[] strs = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] ints = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        while (index < 13) {
            if (num >= ints[index]) {
                num -= ints[index];
                stringBuilder.append(strs[index]);
            } else {
                index++;
            }
        }
        return stringBuilder.toString();
    }

}