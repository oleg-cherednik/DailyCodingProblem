import java.util.*;

/**
 * @author Oleg Cherednik
 * @since 11.02.2019
 */
public class Solution {

    public static void main(String... args) {
        getLeavesPath(createTree()).forEach(path -> System.out.println(Arrays.toString(path)));  // [[1, 2], [1, 3, 4], [1, 3, 5]]
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

    public static List<int[]> getLeavesPath(Node root) {
        List<int[]> res = new LinkedList<>();
        dfs(root, new LinkedList<>(), res);
        return res;
    }

    private static void dfs(Node node, Deque<Node> stack, List<int[]> res) {
        if (node == null)
            return;

        stack.push(node);
        dfs(node.left, stack, res);
        dfs(node.right, stack, res);

        if (node.left == null && node.right == null) {
            int[] path = new int[stack.size()];
            int i = path.length;

            for (Node parent : new ArrayList<>(stack))
                path[--i] = parent.data;

            res.add(path);
        }

        stack.pop();
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
