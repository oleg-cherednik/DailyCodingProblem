/**
 * @author Oleg Cherednik
 * @since 12.02.2019
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(convertToNumber(convertToLinkedList(54321)));    // 54321
        System.out.println(convertToNumber(sum(convertToLinkedList(99), convertToLinkedList(25)))); // 124
    }

    public static Node sum(Node one, Node two) {
        int sum = convertToNumber(one) + convertToNumber(two);
        return convertToLinkedList(sum);
    }

    private static int convertToNumber(Node node) {
        StringBuilder buf = new StringBuilder();

        while (node != null) {
            buf.append(node.digit);
            node = node.next;
        }

        return Integer.parseInt(buf.reverse().toString());
    }

    private static Node convertToLinkedList(int num) {
        String str = String.valueOf(num);
        Node root = null;
        Node prv = null;

        for (int i = str.length() - 1; i >= 0; i--) {
            Node node = new Node(str.charAt(i));

            if (prv != null)
                prv.next = node;
            prv = node;

            root = root == null ? node : root;
        }

        return root;
    }

    private static final class Node {
        private final char digit;
        private Node next;

        public Node(char digit) {
            assert Character.isDigit(digit);
            this.digit = digit;
        }
    }
}
