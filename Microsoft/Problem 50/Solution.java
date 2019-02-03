import java.util.function.BiFunction;

/**
 * @author Oleg Cherednik
 * @since 03.02.2019
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(calc(create()));
    }

    private static Node create() {
        ValueNode node2 = new ValueNode(2);
        ValueNode node3 = new ValueNode(3);
        ValueNode node4 = new ValueNode(4);
        ValueNode node5 = new ValueNode(5);

        BiFunction<Double, Double, Double> add = (one, two) -> one + two;
        BiFunction<Double, Double, Double> multiply = (one, two) -> one * two;

        OperationNode addLeft = new OperationNode(add, node3, node2);
        OperationNode addRight = new OperationNode(add, node4, node5);
        return new OperationNode(multiply, addLeft, addRight);
    }

    public static double calc(Node node) {
        if (node instanceof ValueNode)
            return ((ValueNode)node).val;

        double left = calc(((OperationNode)node).left);
        double right = calc(((OperationNode)node).right);
        return ((OperationNode)node).function.apply(left, right);
    }

    public interface Node {
    }

    public static final class OperationNode implements Node {

        private final BiFunction<Double, Double, Double> function;
        private final Node left;
        private final Node right;

        public OperationNode(BiFunction<Double, Double, Double> function, Node left, Node right) {
            this.function = function;
            this.left = left;
            this.right = right;
        }
    }

    public static final class ValueNode implements Node {

        private final double val;

        public ValueNode(double val) {
            this.val = val;
        }
    }

}
