import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Oleg Cherednik
 * @since 14.02.2019
 */
public class Solution {

    public static void main(String... args) {
        Node root = createTree();
        List<Node> path = getMinSumPath(root);
        System.out.println(path.stream().map(node -> String.valueOf(node.data)).collect(Collectors.joining(" -> "))); // 10 -> 5 -> 1 -> -1
        System.out.println(path.stream().mapToInt(node -> node.data).sum());    // 15
    }

    private static Node createTree() {
        Node fiveLeft = new Node(5);
        fiveLeft.right = new Node(2);

        Node one = new Node(1);
        one.left = new Node(-1);

        Node fiveRight = new Node(5);
        fiveRight.right = one;

        Node ten = new Node(10);
        ten.left = fiveLeft;
        ten.right = fiveRight;

        return ten;
    }

    public static List<Node> getMinSumPath(Node node) {
        if (node == null)
            return Collections.emptyList();

        Deque<Node> path = new LinkedList<>();
        dfs(path, node, 0);
        return new ArrayList<>(path);
    }

    private static int dfs(Deque<Node> path, Node node, int sum) {
        if (node == null)
            return Integer.MAX_VALUE;

        path.addLast(node);

        if (node.left == null && node.right == null)
            return sum + node.data;

        int size = path.size();
        int leftSum = dfs(path, node.left, sum + node.data);
        repair(path, size);
        int rightSum = dfs(path, node.right, sum + node.data);

        if (leftSum < rightSum) {
            repair(path, size);
            return dfs(path, node.left, sum + node.data);
        }

        return rightSum;
    }

    private static void repair(Deque<Node> path, int size) {
        while (path.size() > size)
            path.removeLast();
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
