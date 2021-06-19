/**
 * Created by TanJiaJun on 2021/6/10.
 * 5. 最长回文子串（Longest Palindromic Substring）
 * 难度：中等
 *
 * @see <a href="https://leetcode-cn.com/problems/longest-palindromic-substring/">Longest Palindromic Substring</a>
 */
class LongestPalindromicSubstring {

    public static void main(String[] args) {
        // 示例一
        System.out.print("示例一：");

        String firstStr = "babad";
        System.out.println(expandAroundCenterLongestPalindrome(firstStr));

        System.out.print("\n");

        // 示例二
        System.out.print("示例二：");

        String secondStr = "cbbd";
        System.out.println(expandAroundCenterLongestPalindrome(secondStr));

        System.out.print("\n");

        // 示例三
        System.out.print("示例三：");

        String thirdStr = "a";
        System.out.println(expandAroundCenterLongestPalindrome(thirdStr));

        System.out.print("\n");

        // 示例四
        System.out.print("示例四：");

        String fourthStr = "ac";
        System.out.println(expandAroundCenterLongestPalindrome(fourthStr));
    }

    /**
     * 方法一：枚举算法
     * 时间复杂度：O(N^3)，其中N是字符串的长度
     * 空间复杂度：O(1)
     *
     * @param str 字符串
     * @return 结果
     */
    private static String longestPalindrome(String str) {
        int maxLength = 0;
        String result = "";
        // 枚举所有的元素
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

    /**
     * 判断字符串是否为回文串
     *
     * @param str 字符串
     * @return 结果
     */
    private static boolean isPalindromeSubstring(String str) {
        int length = str.length();
        for (int i = 0; i < length / 2; i++) {
            // 找出该元素作为回文子串的起始位置还有结束位置
            if (str.charAt(i) != str.charAt(length - i - 1)) {
                // 如果其中一个不相同，证明该字符串不是回文串
                return false;
            }
        }
        // 如果字符都相同，证明该字符串是回文串
        return true;
    }

    /**
     * 方法二：中心扩展法（双指针）
     * 时间复杂度：O(N^2)，其中N是字符串的长度
     * 空间复杂度：O(1)
     *
     * @param str 字符串
     * @return 结果
     */
    private static String expandAroundCenterLongestPalindrome(String str) {
        int start = 0;
        int end = 0;
        for (int i = 0, length = str.length(); i < length; i++) {
            // 长度是奇数
            int oddLength = getExpandAroundCenterLength(str, i, i);
            // 长度是偶数
            int evenLength = getExpandAroundCenterLength(str, i, i + 1);
            // 得到最大长度
            int maxLength = Math.max(oddLength, evenLength);
            if (maxLength > end - start) {
                // 得到起始位置
                start = i - (maxLength - 1) / 2;
                // 得到结束位置
                end = i + maxLength / 2;
            }
        }
        // 截取对应的字符
        return str.substring(start, end + 1);
    }

    /**
     * 得到中心往两边扩展的长度
     *
     * @param str   字符串
     * @param left  左指针
     * @param right 右指针
     * @return 长度
     */
    private static int getExpandAroundCenterLength(String str, int left, int right) {
        // 找出该元素作为回文子串的起始位置还有结束位置
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            // 如果符合条件，左指针向左移动一格，右指针向右移动一格
            left--;
            right++;
        }
        // 得到长度
        return right - left - 1;
    }
}
