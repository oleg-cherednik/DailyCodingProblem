import java.util.HashSet;
import java.util.Set;

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
        Set<Node> visited = new HashSet<>();

        while (one != null) {
            visited.add(one);
            one = one.parent;
        }

        while (two != null) {
            if (visited.contains(two)) {
                visited.clear();
                return two;
            }

            two = two.parent;
        }

        visited.clear();
        return null;
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
