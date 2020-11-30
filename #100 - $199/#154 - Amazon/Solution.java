import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Oleg Cherednik
 * @since 16.02.2019
 */
public class Solution {

    public static void main(String... args) {
        int[] arr = { 9, 12, 3, 5, 14, 10, 10 };
        System.out.println(Arrays.toString(arr));

        Stack<Integer> stack = new Stack<>();

        for (int item : arr)
            stack.push(item);

        for (int i = 0; i < arr.length; i++)
            System.out.println(stack.pop());
    }

    public static final class Stack<T> {
        private final Queue<Node<T>> maxHeap = new PriorityQueue<>();
        private int size;

        public void push(T item) {
            maxHeap.add(new Node<T>(size++, item));
        }

        public T pop() {
            if (size == 0)
                throw new RuntimeException();

            size--;
            return maxHeap.remove().item;
        }

        public static final class Node<T> implements Comparable<Node<T>> {
            private final int pos;
            private final T item;

            public Node(int pos, T item) {
                this.pos = pos;
                this.item = item;
            }

            @Override
            public int compareTo(Node<T> obj) {
                return Integer.compare(obj.pos, pos);
            }
        }
    }

}
