import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Oleg Cherednik
 * @since 31.01.2019
 */
public class Solution {

    public static void main(String... args) {
        Node root = createList(5);
        print(root);
        print(remove(root, 1));
    }

    public static Node remove(Node root, int k) {
        Node prv1 = null;
        Node node1 = root;
        int pos1 = 0;


        Node prv = null;
        Node node = root;

        int pos = 0;

        while (node.hasNext()) {
            prv = node;
            node = node.next;
            pos++;

            if (pos % (k + 1) == 0) {
                node1 = node;
                pos1 = pos;
                prv1 = prv;
            }
        }

        if (prv1 == null) {
            Node res = node1.next;
            node1.next = null;
            return res;
        }

        Node tmp = node1.next;
        node1.next = null;
        prv1.next = tmp;
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

    private static void print(Node node) {
        List<Integer> values = new ArrayList<>();

        while (node != null) {
            values.add(node.data);
            node = node.next;
        }

        System.out.println(Arrays.toString(values.stream().mapToInt(val -> val).toArray()));
    }
}
