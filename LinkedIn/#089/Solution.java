/**
 * @author Oleg Cherednik
 * @since 10.02.2019
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(isValidBinarySearchTree(createValidBinarySearchTree())); // true
        System.out.println(isValidBinarySearchTree(createInvalidBinarySearchTree())); // false
    }

    private static Node createValidBinarySearchTree() {
        Node one = new Node(1);
        Node four = new Node(4);
        Node seven = new Node(7);
        Node thirteen = new Node(13);

        Node six = new Node(6);
        six.left = four;
        six.right = seven;

        Node three = new Node(3);
        three.left = one;
        three.right = six;

        Node fourteen = new Node(14);
        fourteen.left = thirteen;

        Node ten = new Node(10);
        ten.right = fourteen;

        Node root = new Node(8);
        root.left = three;
        root.right = ten;

        return root;
    }

    private static Node createInvalidBinarySearchTree() {
        Node one = new Node(1);
        Node two = new Node(2);
        Node five = new Node(5);
        Node nine = new Node(9);

        Node three = new Node(3);
        three.left = one;
        three.right = two;

        Node seven = new Node(7);
        seven.left = five;
        seven.right = nine;

        Node root = new Node(4);
        root.left = three;
        root.right = seven;

        return root;
    }

    public static boolean isValidBinarySearchTree(Node root) {
        return isValidBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isValidBinarySearchTree(Node node, int min, int max) {
        if (node == null)
            return true;
        if (node.data <= min || node.data >= max)
            return false;
        return isValidBinarySearchTree(node.left, min, node.data) && isValidBinarySearchTree(node.right, node.data, max);
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
