import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Oleg Cherednik
 * @since 26.02.2019
 */
public class Solution {

    public static void main(String... args) {
        Node root = createTree();
        String str = serialize(root);   // 1(2(4()())(5(6()())()))(3(7()(8()()))())
        System.out.println(str);
        Node res = deserialize(str);
    }

    private static Node createTree() {
        Node five = new Node(5);
        five.left = new Node(6);

        Node two = new Node(2);
        two.left = new Node(4);
        two.right = five;

        Node seven = new Node(7);
        seven.right = new Node(8);

        Node three = new Node(3);
        three.left = seven;

        Node root = new Node(1);
        root.left = two;
        root.right = three;

        return root;
    }

    public static String serialize(Node root) {
        return serialize(new StringBuilder(), root).toString();
    }

    private static StringBuilder serialize(StringBuilder buf, Node node) {
        if (node == null)
            return buf;

        buf.append(node.val);

        buf.append('(');
        serialize(buf, node.left).append(')');

        buf.append('(');
        serialize(buf, node.right).append(')');

        return buf;
    }

    public static Node deserialize(String str) {
        Deque<Node> stack = new LinkedList<>();
        deserialize(str, 0, stack);
        return stack.pop();
    }

    private static int deserialize(String str, int pos, Deque<Node> stack) {
        if (pos >= str.length() || str.charAt(pos) == ')')
            stack.push(null);
        else {
            int offs = pos;

            while (str.charAt(offs) != '(')
                offs++;

            Node node = new Node(Integer.parseInt(str.substring(pos, offs)));
            stack.push(node);

            pos = deserialize(str, offs + 1, stack);
            pos = deserialize(str, pos + 2, stack) + 1;

            node.right = stack.pop();
            node.left = stack.pop();
        }

        return pos;
    }

    private static final class Node {
        private final int val;
        private Node left;
        private Node right;

        public Node(int val) {
            this.val = val;
        }
    }

}
