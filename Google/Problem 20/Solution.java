/**
 * @author Oleg Cherednik
 * @since 06.02.2019
 */
public class Solution {

    public static void main(String... args) {
        Node node10 = new Node(10, null);
        Node node8 = new Node(8, node10);
        Node node7 = new Node(7, node8);
        Node node3 = new Node(3, node7);
        Node node1 = new Node(1, node8);
        Node node99 = new Node(99, node1);

        Node res = findIntersectionNode(node3, node99);
        System.out.println(res.value); // 8;
    }

    public static Node findIntersectionNode(Node one, Node two) {
        int lengthOne = getLength(one);
        int lengthTwo = getLength(two);

        if (lengthOne > lengthTwo)
            one = skip(one, lengthOne - lengthTwo);
        else if (lengthOne < lengthTwo)
            two = skip(two, lengthTwo - lengthOne);

        while (one != null && one != two) {
            one = one.next;
            two = two.next;
        }

        return one;
    }

    private static int getLength(Node node) {
        int length = 0;

        while (node != null) {
            node = node.next;
            length++;
        }

        return length;
    }

    private static Node skip(Node node, int count) {
        while (node != null && count > 0) {
            node = node.next;
            count--;
        }

        return node;
    }

    private static final class Node {
        private final int value;
        private final Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

}
