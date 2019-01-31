import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Oleg Cherednik
 * @since 31.01.2019
 */
public class Solution {

    public static void main(String... args) {
        test(5, 0);
    }

    private static void test(int total, int k) {
        Node root = createList(total);
        System.out.println(print(root) + " -> " + print(remove(root, k)));
    }

    public static Node remove(Node root, int k) {
        int size = 0;

        Node node = root;

        while (node != null) {
            node
        }

        return root;
    }

    private static final class Node {
        private final int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }

        public boolean hasNext() {
            return next != null;
        }

        @Override
        public String toString() {
            return String.valueOf(data);
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
