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
     * 时间复杂度：O(N)，其中N是字符串的长度
     * 空间复杂度：O(N)
     *
     * @param str     字符串
     * @param numRows 行数
     * @return 结果
     */
    private fun convert(str: String, numRows: Int): String {
        if (numRows == 1) {
            // 如果只是一行的话，就直接返回该字符串
            return str
        }
        // 创建长度是行数的StringBuilder数组，并且每个元素都创建StringBuilder对象
        val stringBuilders = Array(numRows, init = { StringBuilder() })
        // 索引
        var index = 0
        // 行数
        var row = 0
        val length = str.length
        while (index < length) {
            // 从第一行开始，按照行数添加到对应的数组，并且追加字符，然后一直遍历到最后一行对应的数组
            while (index < length && row < numRows) {
                stringBuilders[row++].append(str[index++])
            }

            // 此时row是最后一行，所以我们需要回到倒数第二行，执行以下逻辑
            row = numRows - 2

            // 从倒数第二行开始，按照行数添加到对应的数组，并且追加字符，然后一直遍历到第一行的对应的数组
            while (index < length && row >= 0) {
                stringBuilders[row--].append(str[index++])
            }

            // 此时row是-1，所以我们需要回到第二行，执行以下逻辑
            row += 2
        }
        // 创建一个新的StringBuilder，将每一行对应的StringBuilder数组对应的StringBuilder追加到这个对象
        val resultSB = StringBuilder()
        stringBuilders.forEach { resultSB.append(it) }
        // 将这个StringBuilder转成字符串
        return resultSB.toString()
    }

}