/**
 * Created by TanJiaJun on 2021/6/10.
 * 5. 最长回文子串（Longest Palindromic Substring）
 *
 * @see <a href="https://leetcode-cn.com/problems/longest-palindromic-substring/">Longest Palindromic Substring</a>
 */
class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String firstStr = "babad";
        System.out.println(secondLongestPalindrome(firstStr));

        String secondStr = "cbbd";
        System.out.println(secondLongestPalindrome(secondStr));

        String thirdStr = "a";
        System.out.println(secondLongestPalindrome(thirdStr));

        String fourthStr = "ac";
        System.out.println(secondLongestPalindrome(fourthStr));
    }

    private static String longestPalindrome(String str) {
        int maxLength = 0;
        String result = "";
        for (int i = 0, iLen = str.length(); i < iLen; i++) {
            for (int j = i + 1, jLen = str.length(); j <= jLen; j++) {
                String substring = str.substring(i, j);
                if (isPalindromeSubstring(substring) && substring.length() > maxLength) {
                    maxLength = substring.length();
                    result = substring;
                }
            }
        }
        return result;
    }

    private static boolean isPalindromeSubstring(String str) {
        int length = str.length();
        for (int i = 0; i < length / 2; i++) {
            if (str.charAt(i) != str.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }

    private static String secondLongestPalindrome(String str) {
        int start = 0;
        int end = 0;
        for (int i = 0, length = str.length(); i < length; i++) {
            int firstLength = getExpandAroundCenterLength(str, i, i);
            int secondLength = getExpandAroundCenterLength(str, i, i + 1);
            int maxLength = Math.max(firstLength, secondLength);
            if (maxLength > end - start) {
                start = i - (maxLength - 1) / 2;
                end = i + maxLength / 2;
            }
        }
        return str.substring(start, end + 1);
    }

    private static int getExpandAroundCenterLength(String str, int left, int right) {
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
