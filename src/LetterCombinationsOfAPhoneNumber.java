import java.util.ArrayList;
import java.util.List;

/**
 * Created by TanJiaJun on 2021/7/31.
 * 17. 电话号码的字母组合（Letter Combinations of a Phone Number）
 * 难度：简单
 *
 * @see <a href="https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/">Letter Combinations of a Phone Number</a>
 */
class LetterCombinationsOfAPhoneNumber {

    private static final char[][] letters = {
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}
    };

    public static void main(String[] args) {
        String firstDigits = "23";
        System.out.println(letterCombinations(firstDigits));

        String secondDigits = "";
        System.out.println(letterCombinations(secondDigits));

        String thirdDigits = "2";
        System.out.println(letterCombinations(thirdDigits));
    }

    private static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (!digits.isEmpty()) {
            backTracking(0, new StringBuilder(), digits, result);
        }
        return result;
    }

    private static void backTracking(int index,
                                     StringBuilder stringBuilder,
                                     String digits,
                                     List<String> result) {
        if (index == digits.length()) {
            result.add(stringBuilder.toString());
            return;
        }
        int charsIndex = digits.charAt(index) - '2';
        char[] chars = letters[charsIndex];
        for (char c : chars) {
            stringBuilder.append(c);
            backTracking(index + 1, stringBuilder, digits, result);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }

}