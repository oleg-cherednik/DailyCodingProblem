import java.util.ArrayList;
import java.util.List;

/**
 * @author Oleg Cherednik
 * @since 05.12.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(reverseList(1, 2, 3, 4, 5, 6));  // [6, 5, 4, 3, 2, 1]
    }

    private static List<Integer> reverseList(int... vals) {
        Node head = build(vals);
        head = reverseList(head);

        List<Integer> res = new ArrayList<>();

        while (head != null) {
            res.add(head.val);
            head = head.next;
        }

        return res;
    }

    // 1 -> 2 -> 3
    private static Node reverseList(Node head) {
        Node prv = null;

        while (head != null) {
            Node next = head.next;
            head.next = prv;
            prv = head;
            head = next;
        }

        return prv;
    }

    private static Node build(int... vals) {
        Node head = null;
        Node tail = null;

        for (int val : vals) {
            Node node = new Node(val);

            if (head == null)
                head = node;
            else
                tail.next = node;

            tail = node;
        }

        return head;
    }

    private static final class Node {

        private final int val;
        private Node next;

        public Node(int val) {
            this.val = val;
        }
    }

}
