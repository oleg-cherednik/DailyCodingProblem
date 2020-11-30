import java.util.HashMap;
import java.util.Map;

/**
 * @author Oleg Cherednik
 * @since 13.02.2019
 */
public class Solution {

    public static void main(String... args) {
        Node head = createList();
        print(head);                    // 1(4) -> 2(5) -> 3(1) -> 4(2) -> 5(3) -> 6(null)
        Node resHead = deepCopy(head);
        print(resHead);                 // 1(4) -> 2(5) -> 3(1) -> 4(2) -> 5(3) -> 6(null)
    }

    private static Node createList() {
        // 1(4) -> 2(5) -> 3(1) -> 4(2) -> 5(3) -> 6(null)

        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);

        one.next = two;
        one.rnd = four;

        two.next = three;
        two.rnd = five;

        three.next = four;
        three.rnd = one;

        four.next = five;
        four.rnd = two;

        five.next = six;
        five.rnd = three;

        return one;
    }

    private static void print(Node node) {
        StringBuilder buf = new StringBuilder();

        while (node != null) {
            if (buf.length() > 0)
                buf.append(" -> ");
            buf.append(node.data).append('(').append(node.rnd != null ? node.rnd.data : null).append(')');
            node = node.next;
        }

        System.out.println(buf);
    }

    public static Node deepCopy(Node head) {
        Map<Node, Node> mapOriginalCopy = new HashMap<>();

        Node originalTail = head;
        Node resHead = null;
        Node resTail = null;

        while (originalTail != null) {
            if (!mapOriginalCopy.containsKey(originalTail))
                mapOriginalCopy.put(originalTail, new Node(originalTail.data));

            if (resTail != null) {
                resTail.next = mapOriginalCopy.get(originalTail);
                resTail = resTail.next;
            } else
                resTail = mapOriginalCopy.get(originalTail);

            if (originalTail.rnd != null) {
                if (!mapOriginalCopy.containsKey(originalTail.rnd))
                    mapOriginalCopy.put(originalTail.rnd, new Node(originalTail.rnd.data));
                resTail.rnd = mapOriginalCopy.get(originalTail.rnd);
            }

            resHead = resHead == null ? resTail : resHead;
            originalTail = originalTail.next;
        }

        mapOriginalCopy.clear();

        return resHead;
    }

    private static final class Node {
        private final int data;
        private Node next;
        private Node rnd;

        public Node(int data) {
            this.data = data;
        }
    }

}
