import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * @author Oleg Cherednik
 * @since 27.02.2019
 */
public class Solution {

    public static void main(String... args) {
        Node root = createTree();
        List<Node> res = getLevelWithMinSum(root);
        System.out.println(res.stream().map(node -> String.valueOf(node.val)).collect(Collectors.joining(" ")));    // 1 2 2 2
    }

    private static Node createTree() {
        Node one = new Node(1);
        one.right = new Node(8);

        Node two1 = new Node(2);
        two1.left = new Node(7);

        Node three = new Node(3);
        three.left = one;
        three.right = two1;

        Node two2 = new Node(2);
        two2.right = new Node(11);

        Node two3 = new Node(2);
        two3.left = new Node(10);

        Node six = new Node(6);
        six.left = two2;
        six.right = two3;

        Node root = new Node(15);
        root.left = three;
        root.right = six;

        return root;
    }

    public static List<Node> getLevelWithMinSum(Node root) {
        if (root == null)
            return Collections.emptyList();

        List<Node> res = new ArrayList<>();
        res.add(root);

        int minSum = root.val;

        Queue<List<Node>> queue = new LinkedList<>();
        queue.add(Collections.singletonList(root));

        while (!queue.isEmpty()) {
            List<Node> nodes = queue.remove();
            int sum = 0;

            List<Node> nextLevelNodes = new ArrayList<>();

            for (Node node : nodes) {
                sum += node.val;

                if (node.left != null)
                    nextLevelNodes.add(node.left);
                if (node.right != null)
                    nextLevelNodes.add(node.right);
            }

            if (!nextLevelNodes.isEmpty())
                queue.add(nextLevelNodes);

            if (sum < minSum) {
                res.clear();
                res.addAll(nodes);
            }
        }

        return res;
    }

    public static final class Node {
        private final int val;
        private Node left;
        private Node right;

        public Node(int val) {
            this.val = val;
        }
    }
}
