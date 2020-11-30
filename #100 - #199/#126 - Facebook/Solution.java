import java.util.Arrays;

/**
 * @author Oleg Cherednik
 * @since 22.12.2018
 */
public class Solution {

    public static void main(String... args) {
        int[] arr = { 1, 2, 3, 4, 5, 6 };
        System.out.println(Arrays.toString(arr));   // [1, 2, 3, 4, 5, 6]
        rotate(arr, 2);
        System.out.println(Arrays.toString(arr));   // [3, 4, 5, 6, 1, 2]
    }

    public static void rotate(int[] arr, int k) {
        if ((k %= arr.length) != 0) {
            k = k < 0 ? arr.length + k : k;
            swapSubArr(arr, 0, arr.length);
            swapSubArr(arr, 0, arr.length - k);
            swapSubArr(arr, arr.length - k, arr.length);
        }
    }

    private static void swapSubArr(int[] arr, int from, int to) {
        for (int i = from, j = to - 1; i < j; i++, j--)
            swap(arr, i, j);
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
