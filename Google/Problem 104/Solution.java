import java.util.ArrayList;
import java.util.List;

/**
 * @author Oleg Cherednik
 * @since 08.01.2019
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(isPalindrome(singlyLinkedList(1, 4, 3, 4, 1)));    // true
        System.out.println(isPalindrome(singlyLinkedList(1, 4, 3, 5, 1)));    // false

        System.out.println(isPalindrome(doublyLinkedList(1, 4, 3, 4, 1)));    // true
        System.out.println(isPalindrome(doublyLinkedList(1, 4, 3, 5, 1)));    // false
    }

    private static SingleNode singlyLinkedList(int... arr) {
        SingleNode root = null;
        SingleNode prev = null;

        for (int val : arr) {
            SingleNode node = new SingleNode(val);

            if (prev != null)
                prev.next = node;

            prev = node;
            root = root != null ? root : node;
        }

        return root;
    }

    private static DoubleNode doublyLinkedList(int... arr) {
        DoubleNode root = null;
        DoubleNode prev = null;

        for (int val : arr) {
            DoubleNode node = new DoubleNode(val);

            if (prev != null) {
                prev.next = node;
                node.prev = prev;
            }

            prev = node;
            root = root != null ? root : node;
        }

        return root;
    }

    public static boolean isPalindrome(SingleNode node) {
        if (node == null)
            return false;
        if (node.next == null)
            return true;

        List<Integer> values = new ArrayList<>();

        while (node != null) {
            values.add(node.val);
            node = node.next;
        }

        for (int i = 0, j = values.size() - 1; i < j; i++, j--)
            if (values.get(i).intValue() != values.get(j).intValue())
                return false;

        return true;
    }

    public static boolean isPalindrome(DoubleNode node) {
        if (node == null)
            return false;
        if (node.next == null)
            return true;

        DoubleNode lastNode = node;

        while (lastNode.next != null)
            lastNode = lastNode.next;

        while (node != lastNode && node.next != lastNode) {
            if (node.val != lastNode.val)
                return false;
            node = node.next;
            lastNode = lastNode.prev;
        }

        return true;

    }

    private static final class SingleNode {

        private final int val;
        private SingleNode next;

        public SingleNode(int val) {
            this.val = val;
        }
    }

    private static final class DoubleNode {

        private final int val;
        private DoubleNode next;
        private DoubleNode prev;

        public DoubleNode(int val) {
            this.val = val;
        }
    }


}
