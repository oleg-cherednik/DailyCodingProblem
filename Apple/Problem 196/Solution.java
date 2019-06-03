import java.util.HashMap;
import java.util.Map;

/**
 * @author Oleg Cherednik
 * @since 03.06.2019
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(findMostFrequentSubtreeSum(createTree()));    // 2
    }

    private static Node createTree() {
        Node five = new Node(5);
        five.left = new Node(2);
        five.right = new Node(-5);
        return five;
    }

    public static int findMostFrequentSubtreeSum(Node root) {
        Map<Integer, Integer> sumCount = new HashMap<>();
        getSubtreeSum(root, sumCount);
        return findMostFrequentKey(sumCount);
    }

    private static int getSubtreeSum(Node node, Map<Integer, Integer> sumCount) {
        if (node == null)
            return 0;

        int sumLeft = getSubtreeSum(node.left, sumCount);
        int sumRight = getSubtreeSum(node.right, sumCount);
        int sum = sumLeft + sumRight + node.val;

        sumCount.put(sum, sumCount.getOrDefault(sum, 0) + 1);

        return sum;
    }

    private static int findMostFrequentKey(Map<Integer, Integer> sumCount) {
        if (sumCount.isEmpty())
            return 0;

        int res = sumCount.keySet().iterator().next();


        for (int sum : sumCount.keySet())
            if (sumCount.get(sum) > sumCount.get(res))
                res = sum;

        return res;
    }

    public static final class Node {

        private final int val;
        private Node left;
        private Node right;

        public Node(int val) {
            this.val = val;
        }
    }

}
