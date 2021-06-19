import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by TanJiaJun on 2021/6/18.
 * 8. 字符串转整数（atoi）（String to Integer(atoi)）
 * 难度：简单
 *
 * @see <a href="https://leetcode-cn.com/problems/string-to-integer-atoi/">String to Integer(atoi)</a>
 */
class StringToInteger {

    public static void main(String[] args) {
        String firstStr = "42";
        System.out.println(myAtoi(firstStr));

        String secondStr = "-42";
        System.out.println(myAtoi(secondStr));

        String thirdStr = "4193 with words";
        System.out.println(myAtoi(thirdStr));

        String fourthStr = "words and 987";
        System.out.println(myAtoi(fourthStr));

        String fifthStr = "-91283472332";
        System.out.println(myAtoi(fifthStr));
    }

    private static int myAtoi(String str) {
        str = str.trim();
        Pattern pattern = Pattern.compile("^[\\+\\-]?\\d+");
        Matcher matcher = pattern.matcher(str);
        boolean isInteger = matcher.find();
        int result = 0;
        if (isInteger) {
            try {
                result = Integer.parseInt(str.substring(matcher.start(), matcher.end()));
            } catch (Exception exception) {
                result = str.charAt(0) == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }
        return result;
    }

}