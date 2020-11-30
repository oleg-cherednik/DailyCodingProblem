import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Oleg Cherednik
 * @since 02.02.2019
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(Arrays.toString(getSubset(new int[] { 12, 1, 61, 5, 9, 2 }, 24)));
    }

    public static int[] getSubset(int[] arr, int k) {
        Deque<Integer> stack = new LinkedList<>();
        find(arr, 0, k, stack);
        return stack.stream().mapToInt(Integer::intValue).toArray();
    }

    private static boolean find(int[] arr, int i, int k, Deque<Integer> stack) {
        if (k == 0)
            return true;
        if (k < 0 || i >= arr.length)
            return false;

        for (; i < arr.length; i++) {
            stack.push(arr[i]);

            if (find(arr, i + 1, k - arr[i], stack))
                return true;

            stack.pop();
        }

        return false;
    }

}
