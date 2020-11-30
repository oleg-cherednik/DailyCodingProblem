import java.util.Arrays;

/**
 * @author Oleg Cherednik
 * @since 02.01.2019
 */
public class Solution {

    public static void main(String... args) {
        int[] arr = { 4, 3, 5, 9, 9, 9, 4, 5, 1, 9, 2, 7, 1, 1, 4, 1, 2, 2, 1, 9 };
        System.out.println(Arrays.toString(arr));

        Stack stack = new Stack(arr.length);

        for (int val : arr) {
            stack.push(val);
            System.out.print(stack.max() + ", ");
        }

        System.out.println();

        for (int i = 0; i < arr.length; i++) {
            int max = stack.max();
            int val = stack.pop();
            System.out.print(val + ":" + max + " | ");
        }

        System.out.println();
    }

    public static final class Stack {

        private final int[] values;
        private final int[] maxValues;
        private int top = -1;

        public Stack(int size) {
            values = new int[size];
            maxValues = new int[size];
        }

        public void push(int val) {
            if (top + 1 == values.length)
                throw new StackOverflowError();

            top++;
            values[top] = val;
            maxValues[top] = Math.max(top == 0 ? Integer.MIN_VALUE : maxValues[top - 1], values[top]);
        }

        public int pop() {
            if (top == -1)
                throw new RuntimeException();
            return values[top--];
        }

        public int max() {
            if (top == -1)
                throw new RuntimeException();
            return maxValues[top];
        }
    }
}
