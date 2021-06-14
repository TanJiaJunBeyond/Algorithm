/**
 * Created by TanJiaJun on 2021/6/6.
 * 2. 两数相加（Add Two Numbers）
 * 难度：中等
 *
 * @see <a href="https://leetcode-cn.com/problems/add-two-numbers/">Add Two Numbers</a>
 */
object AddTwoNumbersKotlin {

    @JvmStatic
    fun main(args: Array<String>) {
        // 示例一
        print("示例一：")
        val firstNode =
                Node(
                        2,
                        Node(
                                4,
                                Node(3)
                        )
                )
        val secondNode =
                Node(
                        5,
                        Node(
                                6,
                                Node(4)
                        )
                )
        printNode(addTwoNumbers(firstNode, secondNode))

        print("\n")

        // 示例二
        print("示例二：")
        val thirdNode = Node(0)
        val fourthNode = Node(0)
        printNode(addTwoNumbers(thirdNode, fourthNode))

        print("\n")

        // 示例三
        print("示例三：")
        val fifthNode =
                Node(
                        9,
                        Node(
                                9,
                                Node(
                                        9,
                                        Node(
                                                9,
                                                Node(
                                                        9,
                                                        Node(
                                                                9,
                                                                Node(9)
                                                        )
                                                )
                                        )
                                )
                        )
                )
        val sixthNode =
                Node(
                        9,
                        Node(
                                9,
                                Node(
                                        9,
                                        Node(9)
                                )
                        )
                )
        printNode(addTwoNumbers(fifthNode, sixthNode))

        print("\n")

        // 示例四
        print("示例四：")
        val seventhNode = Node(2)
        val eightNode = Node(8)
        printNode(addTwoNumbers(seventhNode, eightNode))
    }

    /**
     * 时间复杂度：O(Max(m, n))，其中m是第一个结点的长度，n是第二个结点的长度
     * 空间复杂度：O(1)
     *
     * @param first 第一个结点
     * @param second 第二个结点
     * @return 结果
     */
    private fun addTwoNumbers(first: Node?, second: Node?): Node {
        var firstNode = first
        var secondNode = second
        val dummy = Node(-1)
        var node: Node = dummy
        var carry = 0
        // 遍历两个链表
        while (firstNode != null || secondNode != null) {
            // 如果两个链表的长度不相同的话，就在短的链表的后面通过添加若干个0
            val firstValue = firstNode?.item ?: 0
            val secondValue = secondNode?.item ?: 0
            val value = firstValue + secondValue + carry
            val newItem = value.rem(10)
            // 相加后的进位值通过carry来存储
            carry = value.div(10)
            val newNode = Node(newItem)
            firstNode?.let { firstNode = it.next }
            secondNode?.let { secondNode = it.next }
            // 如果在遍历完这两个链表后，carry的值大于0，那么就应该在链表的后面增加一个新的结点来存储这个值
            if (firstNode == null && secondNode == null && carry > 0) {
                newNode.next = Node(carry)
            }
            node.next = newNode
            node = node.next ?: dummy
        }
        return dummy.next ?: dummy
    }

    /**
     * 打印结点
     *
     * @param node 结点
     */
    private fun printNode(node: Node?) {
        print("[")
        var curNode: Node? = node
        while (curNode != null) {
            print(curNode.item)
            curNode = curNode.next
            if (curNode != null) {
                print(",")
            }
        }
        print("]")
    }

    private data class Node(
            var item: Int,
            var next: Node? = null
    )

}