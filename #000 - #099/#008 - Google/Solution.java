/**
 * @author Oleg Cherednik
 * @since 07.12.2018
 */
public class Solution {

    public static void main(String... args) {
        Node node = createTree();
        System.out.println(countUnivalSubtrees(node));
    }

    private static Node createTree() {
        Node a = new Node(1);
        a.left = new Node(1);
        a.right = new Node(1);

        Node b = new Node(0);
        b.left = a;
        b.right = new Node(0);


        Node root = new Node(0);
        root.left = new Node(1);
        root.right = b;

        return root;
    }

    private static class Node {

        private final int val;
        private Node left;
        private Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public static int countUnivalSubtrees(Node node) {
        if (node == null)
            return 0;

        int count = countUnivalSubtrees(node.left);
        count += countUnivalSubtrees(node.right);

        return isUnivalTree(node) ? count + 1 : count;
    }

    private static boolean isUnivalTree(Node node) {
        if (node == null)
            return true;
        if (node.left != null && node.left.val != node.val)
            return false;
        if (node.right != null && node.right.val != node.val)
            return false;
        return isUnivalTree(node.left) && isUnivalTree(node.right);
    }

}
