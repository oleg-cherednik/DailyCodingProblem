import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Oleg Cherednik
 * @since 09.03.2020
 */
public class Solution {

    public static void main(String... args) {
        Node root = generate();
        System.out.println(root.val());
        System.out.println(root.left().val());
        System.out.println(root.right().val());
    }

    public static Node generate() {
        return new Node();
    }

    public static final class Node {

        private static final AtomicInteger COUNT = new AtomicInteger();

        private final int val = COUNT.incrementAndGet();
        private Node left;
        private Node right;

        public int val() {
            return val;
        }

        public Node left() {
            if (left == null)
                left = new Node();
            return left;
        }

        public Node right() {
            if (right == null)
                right = new Node();
            return right;
        }
    }
}
