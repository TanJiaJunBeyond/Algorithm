/**
 * Created by TanJiaJun on 2021/6/5.
 * 2. 两数相加（Add Two Numbers）
 * 难度：中等
 *
 * @see <a href="https://leetcode-cn.com/problems/add-two-numbers/">Add Two Numbers</a>
 */
class AddTwoNumbers {

    public static void main(String[] args) {
        // 示例一
        System.out.print("示例一：");

        Node firstNode =
                new Node(2,
                        new Node(4,
                                new Node(3)));
        Node secondNode =
                new Node(5,
                        new Node(6,
                                new Node(4)));
        printNode(addTwoNumbers(firstNode, secondNode));

        System.out.print("\n");

        // 示例二
        System.out.print("示例二：");

        Node thirdNode = new Node(0);
        Node fourthNode = new Node(0);
        printNode(addTwoNumbers(thirdNode, fourthNode));

        System.out.print("\n");

        // 示例三
        System.out.print("示例三：");

        Node fifthNode =
                new Node(9,
                        new Node(9,
                                new Node(9,
                                        new Node(9,
                                                new Node(9,
                                                        new Node(9,
                                                                new Node(9)))))));
        Node sixthNode =
                new Node(9,
                        new Node(9,
                                new Node(9,
                                        new Node(9))));
        printNode(addTwoNumbers(fifthNode, sixthNode));

        System.out.print("\n");

        // 示例四
        System.out.print("示例四：");

        Node seventhNode = new Node(2);
        Node eightNode = new Node(8);
        printNode(addTwoNumbers(seventhNode, eightNode));
    }

    /**
     * 时间复杂度：O(Max(m, n))，其中m是第一个结点的长度，n是第二个结点的长度
     * 空间复杂度：O(1)
     *
     * @param firstNode  第一个结点
     * @param secondNode 第二个结点
     * @return 结果
     */
    private static Node addTwoNumbers(Node firstNode, Node secondNode) {
        Node dummyNode = new Node(-1);
        Node node = dummyNode;
        int carry = 0;
        while (firstNode != null || secondNode != null) {
            int firstValue = firstNode != null ? firstNode.item : 0;
            int secondValue = secondNode != null ? secondNode.item : 0;
            int value = firstValue + secondValue + carry;
            int newItem = value % 10;
            carry = value / 10;
            Node newNode = new Node(newItem);
            if (firstNode != null) {
                firstNode = firstNode.next;
            }
            if (secondNode != null) {
                secondNode = secondNode.next;
            }
            if (firstNode == null && secondNode == null && carry > 0) {
                newNode.next = new Node(carry);
            }
            node.next = newNode;
            node = node.next;
        }
        return dummyNode.next;
    }

    /**
     * 打印结点
     *
     * @param node 结点
     */
    private static void printNode(Node node) {
        System.out.print("[");
        while (node != null) {
            System.out.print(node.item);
            node = node.next;
            if (node != null) {
                System.out.print(",");
            }
        }
        System.out.print("]");
    }

    private static class Node {

        int item;
        Node next;

        Node(int item) {
            this.item = item;
        }

        Node(int item, Node next) {
            this.item = item;
            this.next = next;
        }

    }

}
