import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author Oleg Cherednik
 * @since 12.12.2018
 */
public class Solution {

    public static void main(String... args) {
        Sum sum = getPair(createTree(), 20);
        System.out.println(sum.one.data + ", " + sum.two.data);   // 5, 15
    }

    private static Node createTree() {
        Node fifteen = new Node(15);
        fifteen.left = new Node(11);
        fifteen.right = new Node(15);

        Node root = new Node(10);
        root.left = new Node(5);
        root.right = fifteen;

        return root;
    }

    public static Sum getPair(Node root, int K) {
        Map<Integer, Node> map = new HashMap<>();
        Deque<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.remove();
            int num = K - node.data;

            if (map.containsKey(num))
                return new Sum(node, map.get(num));

            if (!map.containsKey(node.data))
                map.put(node.data, node);

            queue.add(node.left);
            queue.add(node.right);
        }

        return null;
    }

    private static final class Sum {
        private final Node one;
        private final Node two;

        public Sum(Node one, Node two) {
            this.one = one;
            this.two = two;
        }
    }

    private static final class Node {
        private final int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }

}
