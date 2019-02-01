import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Oleg Cherednik
 * @since 01.02.2019
 */
public class Solution {

    public static void main(String... args) {
        test(5, 0); // [0, 1, 2, 3]
        test(5, 1); // [0, 1, 2, 4]
        test(5, 2); // [0, 1, 3, 4]
        test(5, 3); // [0, 2, 3, 4]
        test(5, 4); // [1, 2, 3, 4]
        test(1, 0); // []
    }

    private static void test(int total, int k) {
        Node root = createList(total);
        System.out.println(print(root) + " -> " + print(remove(root, k)));
    }

    public static Node remove(Node root, int k) {
        if (root == null)
            return null;

        int pos = 0;
        Node prv = null;
        Node node = root;

        while (node != null) {
            node = node.next;
            pos++;

            if (pos > k + 1)
                prv = prv != null ? prv.next : root;
        }

        if (prv == null) {
            node = root.next;
            root.next = null;
            return node;
        }

        node = prv.next.next;
        prv.next = null;
        prv.next = node;

        return root;
    }

    private static final class Node {

        private final int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    private static Node createList(int total) {
        Node root = null;
        Node node = null;

        for (int i = 0; i < total; i++) {
            Node tmp = new Node(i);

            if (node != null)
                node.next = tmp;

            node = tmp;

            if (root == null)
                root = tmp;
        }

        return root;
    }

    private static String print(Node node) {
        List<Integer> values = new ArrayList<>();

        while (node != null) {
            values.add(node.data);
            node = node.next;
        }

        return Arrays.toString(values.stream().mapToInt(val -> val).toArray());
    }
}
