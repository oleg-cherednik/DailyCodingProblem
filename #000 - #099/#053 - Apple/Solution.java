import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Oleg Cherednik
 * @since 03.02.2019
 */
public class Solution {

    public static void main(String... args) {
        Queue<Integer> queue = new Queue<>();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        System.out.println(queue.dequeue());    // 1
        System.out.println(queue.dequeue());    // 2

        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);

        System.out.println(queue.dequeue());    // 3
        System.out.println(queue.dequeue());    // 4
        System.out.println(queue.dequeue());    // 5
        System.out.println(queue.dequeue());    // 6
        System.out.println(queue.dequeue());    // 7
        System.out.println(queue.dequeue());    // 8
    }

    public static class Queue<V> {
        private final Deque<V> stackEnqueue = new LinkedList<>();
        private final Deque<V> stackDequeue = new LinkedList<>();

        public void enqueue(V value) {
            stackEnqueue.push(value);
        }

        public V dequeue() {
            if (stackDequeue.isEmpty())
                while (!stackEnqueue.isEmpty())
                    stackDequeue.push(stackEnqueue.remove());

            return stackDequeue.isEmpty() ? null : stackDequeue.remove();
        }
    }

}
