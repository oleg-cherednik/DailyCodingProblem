import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Oleg Cherednik
 * @since 10.02.2019
 */
public class Solution {

    public static void main(String... args) {
        getAllPermutations(new int[] { 2, 3, 1 }).stream()
                                                 .map(Arrays::toString)
                                                 .forEach(System.out::println);
    }

    public static List<int[]> getAllPermutations(int[] arr) {
        if (arr == null || arr.length == 0)
            return Collections.emptyList();

        arr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arr);

        List<int[]> res = new ArrayList<>();
        res.add(Arrays.copyOf(arr, arr.length));

        while (getNextPermutation(arr) != null)
            res.add(Arrays.copyOf(arr, arr.length));

        return res;
    }

    private static int[] getNextPermutation(int[] arr) {
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] >= arr[i + 1])
                continue;

            int j = arr.length;

            while (arr[--j] < arr[i]) ;

            swap(arr, i, j);
            swapTail(arr, i + 1);
            return arr;
        }

        return null;
    }

    private static void swapTail(int[] arr, int i) {
        for (int j = arr.length - 1; i < j; i++, j--)
            swap(arr, i, j);
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
