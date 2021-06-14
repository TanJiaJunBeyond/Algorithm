/**
 * Created by TanJiaJun on 2021/6/12.
 * 6. Z字形变换（ZigZag Conversion）
 * 难度：中等
 *
 * @see <a href="https://leetcode-cn.com/problems/zigzag-conversion/">ZigZag Conversion</a>
 */
class ZigZagConversion {

    public static void main(String[] args) {
        // 示例一
        System.out.print("示例一：");

        String firstStr = "PAYPALISHIRING";
        int firstNumRows = 3;
        System.out.println(convert(firstStr, firstNumRows));

        System.out.print("\n");

        // 示例二
        System.out.print("示例二：");

        String secondStr = "PAYPALISHIRING";
        int secondNumRows = 4;
        System.out.println(convert(secondStr, secondNumRows));

        System.out.print("\n");

        // 示例三
        System.out.print("示例三：");

        String thirdStr = "A";
        int thirdNumRows = 1;
        System.out.println(convert(thirdStr, thirdNumRows));
    }

    /**
     * 双指针
     * 时间复杂度：O(N)，其中N是字符串的长度
     * 空间复杂度：O(N)
     *
     * @param str     字符串
     * @param numRows 行数
     * @return 结果
     */
    private static String convert(String str, int numRows) {
        if (numRows == 1) {
            return str;
        }
        // 根据行数创建StringBuilder数组
        StringBuilder[] stringBuilders = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            stringBuilders[i] = new StringBuilder();
        }
        int index = 0;
        int row = 0;
        int length = str.length();
        while (index < length) {
            while (index < length && row < numRows) {
                char ch = str.charAt(index++);
                stringBuilders[row++].append(ch);
            }

            // 此时row是最后一行，所以我们需要回到倒数第二行，执行以下逻辑
            row = numRows - 2;

            while (index < length && row >= 0) {
                char ch = str.charAt(index++);
                stringBuilders[row--].append(ch);
            }

            // 此时row是-1，所以我们需要回到第二行，执行以下逻辑
            row += 2;
        }
        StringBuilder resultSB = new StringBuilder();
        for (StringBuilder stringBuilder : stringBuilders) {
            resultSB.append(stringBuilder);
        }
        return resultSB.toString();
    }

}