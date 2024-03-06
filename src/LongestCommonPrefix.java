/**
 * Created by TanJiaJun on 2021/7/5.
 * 14. 最长公共前缀（Longest Common Prefix）
 * 难度：简单
 *
 * @see <a href="https://leetcode-cn.com/problems/longest-common-prefix/">Longest Common Prefix</a>
 */
class LongestCommonPrefix {

    public static void main(String[] args) {
        // 示例一
        System.out.print("示例一：");

        String[] firstStrs = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(firstStrs));

        System.out.print("\n");

        // 示例二
        System.out.print("示例二：");

        String[] secondStrs = {"dog", "racecar", "car"};
        System.out.println(longestCommonPrefix(secondStrs));
    }

    /**
     * 横向扫描
     * <p>
     * 时间复杂度：O(mn)，其中m是字符串数组strs中的字符串平均长度，n是字符串数组strs的长度。
     * 空间复杂度：O(1)，使用的空间复杂度为常数。
     *
     * @param strs 字符串数据
     * @return 最长公共前缀字符串
     */
    private static String longestCommonPrefix(String[] strs) {
        if (strs == null) {
            // 如果是空的字符串数组，就不运行下面的逻辑了，直接返回空字符串
            return "";
        }
        String result = strs[0];
        for (int i = 1, length = strs.length; i < length; i++) {
            // 得到当前两个字符串的公共前缀
            result = getLongestCommonPrefix(result, strs[i]);
            if (result.length() == 0) {
                // 如果result返回空字符串，说明当前两个字符串不存在公共前缀，证明该字符串数组中所有字符串之间不存在公共前缀，
                // 所以跳出循环，不再遍历剩下的字符串，返回空字符串
                break;
            }
        }
        return result;
    }

    /**
     * 得到两个字符串的公共前缀
     *
     * @param firstStr  第一个字符串
     * @param secondStr 第二个字符串
     * @return 两个字符串的最长公共前缀字符串，要注意的是，如果没有的话，就返回空字符串
     */
    private static String getLongestCommonPrefix(String firstStr, String secondStr) {
        // 得到两个字符串的最小长度
        int minLen = Math.min(firstStr.length(), secondStr.length());
        int index = 0;
        // 遍历两个字符串的字符
        while (index < minLen && firstStr.charAt(index) == secondStr.charAt(index)) {
            // 如果索引小于最短长度，并且当前两个字符串的字符相同，就增加索引值
            index++;
        }
        // 截取两个字符串的公共前缀，要注意的是，如果找不到公共前缀会返回空字符串
        return firstStr.substring(0, index);
    }

}