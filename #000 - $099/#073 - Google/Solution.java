/**
 * @author Oleg Cherednik
 * @since 30.10.2018
 */
public class Solution {

    public static void main(String... args) {
        Node root = createList(1, 2, 3, 4, 5);
        print(root);
        Node reverseRoot = reverseInPlace(root);
        print(reverseRoot);
    }

    public static Node reverseInPlace(Node node) {
        Node prv = null;

        while (node != null) {
            Node next = node.next;

            if (prv == null) {
                prv = node;
                prv.next = null;
            } else {
                node.next = prv;
                prv = node;
            }

            node = next;
        }

        return prv;
    }

    private static void print(Node node) {
        while (node != null) {
            System.out.print(node.val + ", ");
            node = node.next;
        }

        System.out.println();
    }

    private static Node createList(int... vals) {
        Node root = null;
        Node node = null;

        for (int val : vals) {
            Node tmp = new Node(val);

            if (node == null) {
                node = tmp;
                root = node;
            } else {
                node.next = tmp;
                node = tmp;
            }
        }

        return root;
    }

    private static class Node {

        private final int val;
        private Node next;

        public Node(int val) {
            this.val = val;
        }
    }

}
