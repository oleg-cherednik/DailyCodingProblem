import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Oleg Cherednik
 * @since 07.02.2019
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(check(new int[]{10, 5, 7}));    // true
        System.out.println(check(new int[]{10, 5, 1}));    // false
    }

    public static boolean check(int[] arr) {
        int replace = 0;
        Deque<Integer> stack = new LinkedList<>();

        for (int val : arr) {
            while (!stack.isEmpty() && val < stack.element()) {
                stack.pop();
                replace++;
            }

            if (replace > 1)
                return false;

            stack.push(val);
        }

        return true;
    }
}
