import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Oleg Cherednik
 * @since 11.02.2019
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(bfs(createTree()).stream()
                                   .map(node -> String.valueOf(node.data))
                                   .collect(Collectors.joining(","))); // 1,2,3,4,5
    }

    private static Node createTree() {
        Node two = new Node(2);
        Node four = new Node(4);
        Node five = new Node(5);

        Node three = new Node(3);
        three.left = four;
        three.right = five;

        Node root = new Node(1);
        root.left = two;
        root.right = three;

        return root;
    }

    public static List<Node> bfs(Node root) {
        if (root == null)
            return Collections.emptyList();

        List<Node> res = new LinkedList<>();
        Deque<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            res.add(node);

            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }

        return res;
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
