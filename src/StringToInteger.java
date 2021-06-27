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
        // 示例一
        System.out.print("示例一：");

        String firstStr = "42";
        System.out.println(myAtoi(firstStr));

        System.out.print("\n");

        // 示例二
        System.out.print("示例二：");

        String secondStr = "-42";
        System.out.println(myAtoi(secondStr));

        System.out.print("\n");

        // 示例三
        System.out.print("示例三：");

        String thirdStr = "4193 with words";
        System.out.println(myAtoi(thirdStr));

        System.out.print("\n");

        // 示例四
        System.out.print("示例四：");

        String fourthStr = "words and 987";
        System.out.println(myAtoi(fourthStr));

        System.out.print("\n");

        // 示例五
        System.out.print("示例五：");

        String fifthStr = "-91283472332";
        System.out.println(myAtoi(fifthStr));
    }

    /**
     * 时间复杂度：O(N)，其中N是字符串的长度
     * 空间复杂度：O(1)
     *
     * @param s 字符串
     * @return 结果
     */
    private static int myAtoi(String s) {
        // 去掉字符串前面和后面的空格
        s = s.trim();
        // ^[\+\-]?的意思是判断字符是否匹配+或者-，匹配零次或者一次
        // \d+的意思是判断字符是否匹配[0-9]，匹配一次或者多次
        Pattern pattern = Pattern.compile("^[\\+\\-]?\\d+");
        Matcher matcher = pattern.matcher(s);
        boolean isInteger = matcher.find();
        int result = 0;
        if (isInteger) {
            try {
                result = Integer.parseInt(s.substring(matcher.start(), matcher.end()));
            } catch (NumberFormatException exception) {
                // 如果抛出NumberFormatException异常，证明小于整型的最小值，大于整型的最大值
                result = s.charAt(0) == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }
        return result;
    }

}