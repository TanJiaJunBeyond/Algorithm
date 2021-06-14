/**
 * Created by TanJiaJun on 2021/6/14.
 * 6. Z字形变换（ZigZag Conversion）
 * 难度：中等
 *
 * @see <a href="https://leetcode-cn.com/problems/zigzag-conversion/">ZigZag Conversion</a>
 */
object ZigZagConversionKotlin {

    @JvmStatic
    fun main(args: Array<String>) {
        // 示例一
        print("示例一：")

        val firstStr = "PAYPALISHIRING"
        val firstNumRows = 3
        println(convert(firstStr, firstNumRows))

        print("\n")

        // 示例二
        print("示例二：")

        val secondStr = "PAYPALISHIRING"
        val secondNumRows = 4
        println(convert(secondStr, secondNumRows))

        print("\n")

        // 示例三
        print("示例三：")

        val thirdStr = "A"
        val thirdNumRows = 1
        println(convert(thirdStr, thirdNumRows))
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
    private fun convert(str: String, numRows: Int): String {
        if (numRows == 1) {
            return str
        }
        // 根据长度是行数的容量StringBuilder数组
        val stringBuilders = Array(numRows, init = { StringBuilder() })
        var index = 0
        var row = 0
        val length = str.length
        while (index < length) {
            while (index < length && row < numRows) {
                stringBuilders[row++].append(str[index++])
            }

            // 此时row是最后一行，所以我们需要回到倒数第二行，执行以下逻辑
            row = numRows - 2

            while (index < length && row >= 0) {
                stringBuilders[row--].append(str[index++])
            }

            // 此时row是-1，所以我们需要回到第二行，执行以下逻辑
            row += 2
        }
        val resultSB = StringBuilder()
        stringBuilders.forEach { resultSB.append(it) }
        return resultSB.toString()
    }

}