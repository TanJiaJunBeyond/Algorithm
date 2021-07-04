/**
 * Created by TanJiaJun on 2021/7/5.
 * 14. 最长公共前缀（Longest Common Prefix）
 * 难度：简单
 *
 * @see <a href="https://leetcode-cn.com/problems/longest-common-prefix/">Longest Common Prefix</a>
 */
class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] firstStrs = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(firstStrs));

        String[] secondStrs = {"dog", "racecar", "car"};
        System.out.println(longestCommonPrefix(secondStrs));
    }

    private static String longestCommonPrefix(String[] strs) {
        if (strs == null) {
            return "";
        }
        String result = strs[0];
        for (int i = 1, length = strs.length; i < length; i++) {
            result = getLongestCommonPrefix(result, strs[i]);
            if (result.length() == 0) {
                break;
            }
        }
        return result;
    }

    private static String getLongestCommonPrefix(String firstStr, String secondStr) {
        int length = Math.min(firstStr.length(), secondStr.length());
        int index = 0;
        while (index < length && firstStr.charAt(index) == secondStr.charAt(index)) {
            index++;
        }
        return firstStr.substring(0, index);
    }

}