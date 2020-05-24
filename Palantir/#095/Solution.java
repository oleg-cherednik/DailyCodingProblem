import java.util.Arrays;

/**
 * @author Oleg Cherednik
 * @since 10.02.2019
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(Arrays.toString(findNextPermutation(new int[] { 1, 2, 3 })));    // [1, 3, 2]
        System.out.println(Arrays.toString(findNextPermutation(new int[] { 1, 3, 2 })));    // [2, 1, 3]
        System.out.println(Arrays.toString(findNextPermutation(new int[] { 2, 1, 3 })));    // [2, 3, 1]
        System.out.println(Arrays.toString(findNextPermutation(new int[] { 2, 3, 1 })));    // [3, 1, 2]
        System.out.println(Arrays.toString(findNextPermutation(new int[] { 3, 1, 2 })));    // [3, 2, 1]
        System.out.println(Arrays.toString(findNextPermutation(new int[] { 3, 2, 1 })));    // [1, 2, 3]
    }

    public static int[] findNextPermutation(int[] arr) {
        if (arr == null)
            return null;
        if (arr.length <= 1)
            return arr;

        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] >= arr[i + 1])
                continue;

            int j = arr.length;

            while (arr[--j] < arr[i]) ;

            swap(arr, i, j);
            swapTail(arr, i + 1);

            return arr;
        }

        swapTail(arr, 0);

        return arr;
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
