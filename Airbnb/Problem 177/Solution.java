/**
 * @author Oleg Cherednik
 * @since 28.05.2019
 */
public class Solution {

    public static void main(String... args) {
        print(rotate(createList(8, 7, 3, 5), 2));       // 8 -> 7 -> 3 -> 5
        print(rotate(createList(1, 2, 3, 4, 5), 3));    // 3 -> 4 -> 5 -> 1 -> 2
    }

    private static Node createList(int... arr) {
        Node head = null;
        Node node = null;

        for (int val : arr) {
            if (node == null)
                node = new Node(val);
            else {
                node.next = new Node(val);
                node = node.next;
            }

            if (head == null)
                head = node;
        }


        return head;
    }

    private static void print(Node node) {
        boolean first = false;

        while (node != null) {
            if (first)
                System.out.print(" -> ");

            System.out.print(node.val);
            node = node.next;
            first = true;
        }

        System.out.println();
    }

    public static Node rotate(Node head, int k) {
        Node tail = getTail(head);

        for (int i = 1; i <= k; i++) {
            if (head.next == null)
                throw new IllegalArgumentException();

            Node next = head.next;
            head.next = null;
            tail.next = head;

            head = next;
            tail = tail.next;
        }

        return head;
    }

    private static Node getTail(Node node) {
        Node tail = node;

        while (tail.next != null)
            tail = tail.next;

        return tail;
    }


    public static final class Node {

        public final int val;
        public Node next;

        public Node(int val) {
            this.val = val;
        }
    }

}
