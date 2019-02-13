import java.util.Map;
import java.util.TreeMap;

/**
 * @author Oleg Cherednik
 * @since 13.02.2019
 */
public class Solution {

    public static void main(String... args) {
        Map<Integer, Node> map = createTree();
        System.out.println(5 + " -> " + inorderSuccessor(map.get(5)).data);     // 10
        System.out.println(10 + " -> " + inorderSuccessor(map.get(10)).data);   // 22
        System.out.println(22 + " -> " + inorderSuccessor(map.get(22)).data);   // 25
        System.out.println(25 + " -> " + inorderSuccessor(map.get(25)).data);   // 30
        System.out.println(30 + " -> " + inorderSuccessor(map.get(30)).data);   // 35
        System.out.println(35 + " -> " + inorderSuccessor(map.get(35)));        // null
    }

    private static Map<Integer, Node> createTree() {
        Node five = new Node(5);
        Node ten = new Node(10);
        Node twentyTwo = new Node(22);
        Node thirty = new Node(30);
        Node thirtyFive = new Node(35);
        Node twentyFive = new Node(25);

        twentyTwo.right = twentyFive;
        twentyFive.parent = twentyTwo;

        twentyTwo.parent = thirty;
        thirtyFive.parent = thirty;

        thirty.parent = ten;
        thirty.left = twentyTwo;
        thirty.right = thirtyFive;

        five.parent = ten;
        ten.left = five;
        ten.right = thirty;

        Map<Integer, Node> map = new TreeMap<>();
        map.put(five.data, five);
        map.put(ten.data, ten);
        map.put(twentyTwo.data, twentyTwo);
        map.put(twentyFive.data, twentyFive);
        map.put(thirty.data, thirty);
        map.put(thirtyFive.data, thirtyFive);

        return map;
    }

    public static Node inorderSuccessor(Node node) {
        if (node == null)
            return null;

        if (node.right != null) {
            node = node.right;

            while (node.left != null)
                node = node.left;

            return node;
        }
        if (node.parent == null)
            return null;

        while (node.parent != null && node.parent.left != node)
            node = node.parent;

        return node.parent;
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
