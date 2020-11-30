import java.util.Arrays;

/**
 * @author Oleg Cherednik
 * @since 03.06.2019
 */
public class Solution {

    public static void main(String... args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        rotateRight(arr, 2);
        System.out.println(Arrays.toString(arr));   // { 4, 5, 1, 2, 3 }
    }

    public static void rotateRight(int[] arr, int k) {
        k %= arr.length;

        reverse(arr, 0, arr.length - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, arr.length - 1);
    }

    private static void reverse(int[] arr, int l, int r) {
        while (l < r)
            swap(arr, l++, r--);
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
