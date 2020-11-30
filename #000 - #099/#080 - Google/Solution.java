import java.util.*;

/**
 * @author Oleg Cherednik
 * @since 08.02.2019
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(findDeepestNode(createTree()));  // d
    }

    private static Node createTree() {
        Node d = new Node('d');
        Node b = new Node('b');
        b.left = d;

        Node c = new Node('c');
        Node root = new Node('a');
        root.left = b;
        root.right = c;

        return root;
    }

    public static char findDeepestNode(Node root) {
        if (root == null)
            return '\0';

        Deque<List<Node>> queue = new LinkedList<>();
        queue.add(Collections.singletonList(root));
        List<Node> deepestNodes = Collections.emptyList();

        while (!queue.isEmpty()) {
            deepestNodes = queue.poll();
            List<Node> nodes = new ArrayList<>();

            for (Node node : deepestNodes) {
                if (node.left != null)
                    nodes.add(node.left);
                if (node.right != null)
                    nodes.add(node.right);
            }

            if (!nodes.isEmpty())
                queue.add(nodes);
        }

        return deepestNodes.isEmpty() ? '\0' : deepestNodes.iterator().next().data;
    }

    private static final class Node {
        private final char data;
        private Node left;
        private Node right;

        public Node(char data) {
            this.data = data;
        }
    }
}
