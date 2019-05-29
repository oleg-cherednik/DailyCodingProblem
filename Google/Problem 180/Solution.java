import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Oleg Cherednik
 * @since 29.05.2019
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(Arrays.toString(interleave(new ArrayDeque<>(Arrays.asList(5, 4, 3, 2, 1))).toArray(new Integer[0])));    // [1, 5, 2, 4, 3]
        System.out.println(Arrays.toString(interleave(new ArrayDeque<>(Arrays.asList(4, 3, 2, 1))).toArray(new Integer[0])));    // [1, 4, 2, 3]
    }

    public static Deque<Integer> interleave(Deque<Integer> stack) {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = stack.size() - 1; i > 1; i--) {
            for (int j = 0; j < i; j++)
                queue.add(stack.pop());

            for (int j = 0; j < i; j++)
                stack.push(queue.remove());
        }

        return stack;
    }

}
