/**
 * @author Oleg Cherednik
 * @since 24.09.2022
 */
public class Solution {

    public static void main(String... args) {
        Node root = createTree();
        System.out.println(getTotalNodes(root));   // 10
    }

    private static int getTotalNodes(Node root) {
        Data data = new Data();
        dfs(root, 1, data);
        return (int)Math.pow(2, data.height - 1) - 1 + data.lastLevelSize;
    }

    private static boolean dfs(Node parent, int curHeight, Data data) {
        if (parent == null)
            return true;

        if (!data.heightFound)
            data.height = Math.max(data.height, curHeight);

        if (parent.left == null || parent.right == null) {
            data.heightFound = true;
            data.lastLevelSize++;
            return parent.left == null;
        }

        return dfs(parent.left, curHeight + 1, data) && dfs(parent.right, curHeight + 1, data);
    }

    private static Node createTree() {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        Node eight = new Node(8);
        Node nine = new Node(9);
        Node ten = new Node(10);

        one.left = two;
        one.right = three;
        two.left = four;
        two.right = five;
        three.left = six;
        three.right = seven;
        four.left = eight;
        four.right = nine;
        five.left = ten;

        return one;
    }

    private static final class Node {

        private final int val;
        private Node left;
        private Node right;

        public Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }

    private static class Data {

        private int height;
        private boolean heightFound;
        private int lastLevelSize;

        @Override
        public String toString() {
            return String.valueOf(height + "-" + heightFound + '-' + lastLevelSize);
        }
    }

}
