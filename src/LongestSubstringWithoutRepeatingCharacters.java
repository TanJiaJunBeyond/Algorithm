import java.util.HashSet;
import java.util.Set;

/**
 * Created by TanJiaJun on 2021/6/6.
 * 3. 无重复字符的最长子串（Longest Substring Without Repeating Characters）
 * 难度：中等
 *
 * @see <a href="https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/">Longest Substring Without Repeating Characters</a>
 */
class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        // 示例一
        System.out.print("示例一：");
        String firstStr = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(firstStr));

        // 示例二
        System.out.print("示例二：");
        String secondStr = "bbbbb";
        System.out.println(lengthOfLongestSubstring(secondStr));

        // 示例三
        System.out.print("示例三：");
        String thirdStr = "pwwkew";
        System.out.println(lengthOfLongestSubstring(thirdStr));
    }

    /**
     * 方法：滑动窗口
     * 时间复杂度：O(N)，其中N是字符串的长度
     * 空间复杂度：O(∣Σ∣)，其中Σ表示字符串中出现的字符集合，∣Σ∣表示该字符集合的大小，默认为所有ASCII码为[0,128)内的字符，也就是大小是128
     *
     * @param str 字符串
     * @return 结果
     */
    private static int lengthOfLongestSubstring(String str) {
        // 结果
        int result = 0;
        // 右指针
        int right = 0;
        // 哈希集合，记录出现的字符
        Set<Character> chars = new HashSet<>();
        // 遍历字符串中的字符
        for (int i = 0, length = str.length(); i < length; i++) {
            if (i > 0) {
                // 左指针向右移动一格
                chars.remove(str.charAt(i - 1));
            }
            while (right < length && !chars.contains(str.charAt(right))) {
                // 如果索引小于字符串的长度，同时该字符没出现过，就将该字符放到哈希集合中，然后右指针向右移动一格
                chars.add(str.charAt(right));
                right++;
            }
            // 计算长度的最大值
            result = Math.max(result, right - i);
        }
        return result;
    }

}
