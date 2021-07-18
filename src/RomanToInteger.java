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
        int preNum = getInteger(s.charAt(0));
        int result = 0;
        for (int i = 1, length = s.length(); i < length; i++) {
            int num = getInteger(s.charAt(i));
            if (preNum < num) {
                result -= preNum;
            } else {
                result += preNum;
            }
            preNum = num;
        }
        result += preNum;
        return result;
    }

    private static int getInteger(char roman) {
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