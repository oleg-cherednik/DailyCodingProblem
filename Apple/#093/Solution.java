/**
 * @author Oleg Cherednik
 * @since 09.03.2020
 */
public class Solution {

    public static void main(String... args) {
        Node root = generate();
    }

    public static int getLargestBstSize(Node node) {

    }

    private static boolean isBst(Node node) {
        if(node == null)
            return true;

        boolean bst = true;

        if(node.left != null) {
            bst &= isBst(node.left);
        }


    }

    private static Node generate() {
        return null;
    }

    public static final class Node {
        private final int val;
        private Node left;
        private Node right;
        private int size = -1;

        public Node(int val) {
            this.val = val;
        }
    }

}
