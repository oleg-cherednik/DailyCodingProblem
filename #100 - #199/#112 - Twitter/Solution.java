/**
 * @author Oleg Cherednik
 * @since 12.02.2019
 */
public class Solution {

    public static void main(String... args) {
        Node four = new Node(4);
        Node six = new Node(6);
        createTree(four, six);
        System.out.println(findLowestCommonAncestor(four, six).data);   // 2
    }

    private static void createTree(Node four, Node six) {
        Node five = new Node(5);

        Node three = new Node(3);
        three.left = four;
        three.right = five;
        four.parent = three;
        five.parent = three;

        Node two = new Node(2);
        two.left = six;
        two.right = three;
        six.parent = two;
        three.parent = two;

        Node root = new Node(1);
        root.left = two;
        two.parent = root;
    }

    public static Node findLowestCommonAncestor(Node one, Node two) {
        int depthOne = depth(one);
        int depthTwo = depth(two);

        while (depthOne > depthTwo) {
            one = one.parent;
            depthOne--;
        }

        while (depthOne < depthTwo) {
            two = two.parent;
            depthTwo--;
        }

        while (one != null && two != null) {
            if (one == two)
                return one;

            one = one.parent;
            two = two.parent;
        }

        return null;
    }

    private static int depth(Node node) {
        int depth = 0;

        while (node != null) {
            depth++;
            node = node.parent;
        }

        return depth;
    }

    private static final class Node {
        private final int data;
        private Node parent;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }

}
