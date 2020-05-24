/**
 * @author Oleg Cherednik
 * @since 18.02.2020
 */
public class Solution {

    public static void main(String... args) {
        Node root1 = new Node(4, 3);
        root1.children[0] = new Node(3, 2);
        root1.children[2] = new Node(5, 0);
        root1.children[2] = new Node(3, 2);
        root1.children[0].children[0] = new Node(9, 0);
        root1.children[2].children[1] = new Node(9, 0);

        Node root2 = new Node(4, 2);
        root2.children[0] = new Node(3, 3);
        root2.children[1] = new Node(3, 3);
        root2.children[0].children[0] = new Node(9, 0);
        root2.children[0].children[1] = new Node(4, 0);
        root2.children[0].children[2] = new Node(1, 0);
        root2.children[1].children[0] = new Node(1, 0);
        root2.children[1].children[1] = new Node(4, 0);
        root2.children[1].children[2] = new Node(9, 0);

        System.out.println(isSymmetric(root1));  // true
        System.out.println(isSymmetric(root2));  // true
    }

    private static final class Node {

        private final int val;
        private final Node[] children;

        public Node(int val, int totalChildren) {
            this.val = val;
            children = new Node[totalChildren];
        }
    }

    public static boolean isSymmetric(Node root) {
        for (int i = 0, j = root.children.length - 1; i < j; i++, j--)
            if (!isSymmetric(root.children[i], root.children[j]))
                return false;

        return true;
    }

    private static boolean isSymmetric(Node one, Node two) {
        if (one == null ^ two == null)
            return false;
        if (one.val != two.val)
            return false;
        if (one.children.length != two.children.length)
            return false;

        for (int i = 0, j = one.children.length - 1; i < j; i++, j--)
            if (!isSymmetric(one.children[i], two.children[j]))
                return false;

        return true;
    }

}
