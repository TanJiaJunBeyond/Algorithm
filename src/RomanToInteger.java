/**
 * Created by TanJiaJun on 2021/7/19.
 * 13. 罗马数字转整数（Roman to Integer）
 * 难度：简单
 *
 * @see <a href="https://leetcode-cn.com/problems/roman-to-integer/">Roman to Integer</a>
 */
class RomanToInteger {

    public static void main(String[] args) {
        String firstStr = "III";
        System.out.println(romanToInt(firstStr));

        String secondStr = "IV";
        System.out.println(romanToInt(secondStr));

        String thirdStr = "IX";
        System.out.println(romanToInt(thirdStr));

        String fourthStr = "LVIII";
        System.out.println(romanToInt(fourthStr));

        String fifthStr = "MCMXCIV";
        System.out.println(romanToInt(fifthStr));
    }

    private static int romanToInt(String s) {
        // 得到第一个罗马数字
        int preNum = getInteger(s.charAt(0));
        int result = 0;
        for (int i = 1, length = s.length(); i < length; i++) {
            int num = getInteger(s.charAt(i));
            // 用这个数字的前一个数字与其比较
            if (preNum < num) {
                // 根据题义可知，如果这个数字大于前一个数字，就做减法运算，减去前一个数字
                result -= preNum;
            } else {
                // 根据题义可知，如果这个数字小于前一个数字，就做加法运算，加上前一个数字
                result += preNum;
            }
            // 记录前一个数字
            preNum = num;
        }
        // 相加得出最后的结果
        result += preNum;
        return result;
    }

    private static int getInteger(char roman) {
        // 枚举罗马数字七种字符和对应的整数
        return switch (roman) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }

}