/**
 * @author Oleg Cherednik
 * @since 18.01.2019
 */
public class Solution {

    public static void main(String... args) {
        print(swapEveryTwoNodes(createList()));
        print(swapEveryTwoNodes(createList(1)));
        print(swapEveryTwoNodes(createList(1, 2)));
        print(swapEveryTwoNodes(createList(1, 2, 3)));
        print(swapEveryTwoNodes(createList(1, 2, 3, 4)));
        print(swapEveryTwoNodes(createList(1, 2, 3, 4, 5)));
    }

    private static Node createList(int... arr) {
        Node root = null;
        Node prv = null;

        for (int val : arr) {
            Node node = new Node(val);

            if (prv != null)
                prv.next = node;

            prv = node;
            root = root != null ? root : node;
        }

        return root;
    }

    private static void print(Node node) {
        boolean arrow = false;

        while (node != null) {
            if (arrow)
                System.out.print(" -> ");
            System.out.print(node.val);
            node = node.next;
            arrow = true;
        }

        System.out.println("\n---");
    }

    public static Node swapEveryTwoNodes(Node node) {
        Node newRoot = null;
        Node odd = null;
        Node tail = null;

        while (node != null) {
            Node next = node.next;

            if (odd == null) {
                odd = node;
                odd.next = null;
            } else {
                if (tail == null) {
                    tail = node;
                    tail.next = odd;
                    tail = odd;
                    newRoot = node;
                } else {
                    tail.next = node;
                    tail.next.next = odd;
                    tail = odd;
                }

                odd = null;
            }

            node = next;
        }

        if (odd != null) {
            if (tail != null)
                tail.next = odd;
            else
                newRoot = odd;
        }

        return newRoot;
    }

    private static final class Node {

        private final int val;
        private Node next;

        public Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }

}
