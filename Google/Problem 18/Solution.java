import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Oleg Cherednik
 * @since 24.05.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(Arrays.toString(maxSubArr(new int[] { 10, 5, 2, 7, 8, 7 }, 3))); // [10, 7, 8, 8]
    }

    public static int[] maxSubArr(int[] arr, int k) {
        int[] res = new int[arr.length - k + 1];
        Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0, j = 0, m = 0; j < arr.length; ) {
            maxHeap.add(arr[j++]);

            if (maxHeap.size() > k)
                maxHeap.remove(arr[i++]);
            if (maxHeap.size() == k)
                res[m++] = maxHeap.element();
        }

        return res;
    }

}
