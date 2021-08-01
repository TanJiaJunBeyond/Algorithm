/**
 * Created by TanJiaJun on 2021/8/1.
 */
object LetterCombinationsOfAPhoneNumberKotlin {

    private val letters = arrayOf(
            charArrayOf('a', 'b', 'c'),
            charArrayOf('d', 'e', 'f'),
            charArrayOf('g', 'h', 'i'),
            charArrayOf('j', 'k', 'l'),
            charArrayOf('m', 'n', 'o'),
            charArrayOf('p', 'q', 'r', 's'),
            charArrayOf('t', 'u', 'v'),
            charArrayOf('w', 'x', 'y', 'z')
    )

    @JvmStatic
    fun main(args: Array<String>) {
        val firstDigits = "23"
        println(letterCombinations(firstDigits))

        val secondDigits = ""
        println(letterCombinations(secondDigits))

        val thirdDigits = "2"
        println(letterCombinations(thirdDigits))
    }

    private fun letterCombinations(digits: String): List<String> =
            mutableListOf<String>().apply {
                if (digits.isNotEmpty()) {
                    backTracking(0, StringBuilder(), digits, this)
                }
            }

    private fun backTracking(index: Int, stringBuilder: StringBuilder, digits: String, result: MutableList<String>) {
        if (index == digits.length) {
            result.add(stringBuilder.toString())
            return
        }
        val charIndex = digits[index] - '2'
        val chars = letters[charIndex]
        for (c in chars) {
            stringBuilder.append(c)
            backTracking(index + 1, stringBuilder, digits, result)
            stringBuilder.deleteCharAt(stringBuilder.length - 1)
        }
    }

}