import java.util.ArrayList;
import java.util.List;

/**
 * @author Oleg Cherednik
 * @since 31.03.2019
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(getLongestPathLength(createTree())); // 18
    }

    private static Node createTree() {
        Node e = new Node("e", 2);
        e.children.add(new Node("g", 1));
        e.children.add(new Node("h", 3));

        Node d = new Node("d", 8);
        d.children.add(e);
        d.children.add(new Node("f", 4));

        Node a = new Node("a", 0);
        a.children.add(new Node("b", 3));
        a.children.add(new Node("c", 5));
        a.children.add(d);

        return a;
    }

    public static int getLongestPathLength(Node root) {
        Data data = new Data(0);
        dfs(root, data);
        return data.length;
    }

    private static int dfs(Node node, Data maxLengthPath) {
        if (node == null || node.children.isEmpty())
            return 0;

        List<Data> children = new ArrayList<>();

        for (Node child : node.children)
            children.add(new Data(child.weight + dfs(child, maxLengthPath)));

        children.sort((one, two) -> Integer.compare(two.length, one.length));
        maxLengthPath.set(children.size() > 1 ? children.get(0).length + children.get(1).length : children.get(0).length);

        return children.get(0).length;
    }

    private static final class Node {
        private final String id;
        private final int weight;
        private final List<Node> children = new ArrayList<>();

        public Node(String id, int weight) {
            this.id = id;
            this.weight = weight;
        }
    }

    private static final class Data {
        private int length;

        public Data(int length) {
            this.length = length;
        }

        public void set(int length) {
            this.length = Math.max(this.length, length);
        }
    }

}
