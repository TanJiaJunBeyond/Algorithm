/**
 * Created by TanJiaJun on 2021/6/12.
 * 6. Z字形变换（ZigZag Conversion）
 *
 * @see <a href="https://leetcode-cn.com/problems/zigzag-conversion/">ZigZag Conversion</a>
 */
class ZigZagConversion {

    public static void main(String[] args) {
        String firstStr = "PAYPALISHIRING";
        System.out.println(covert(firstStr, 3));
    }

    private static String covert(String str, int numRows) {
        if (numRows == 1) {
            return str;
        }
        StringBuilder[] stringBuilders = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            stringBuilders[i] = new StringBuilder();
        }
        int index = 0;
        int row = 0;
        int length = str.length();
        while (index < length) {
            while (index < length && row < numRows) {
                char ch = str.charAt(index);
                stringBuilders[row].append(ch);
                index++;
                row++;
            }

            row = numRows - 2;

            while (index < length && row >= 0) {
                char ch = str.charAt(index);
                stringBuilders[row].append(ch);
                index++;
                row--;
            }

            row += 2;
        }
        StringBuilder resultSB = new StringBuilder();
        for (StringBuilder stringBuilder : stringBuilders) {
            resultSB.append(stringBuilder);
        }
        return resultSB.toString();
    }

}