import java.util.Arrays;

/**
 * @author Oleg Cherednik
 * @since 15.02.2019
 */
public class Solution {

    public static void main(String... args) {
        int[] arr = {9, 12, 3, 5, 14, 10, 10};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(partition(arr, 10)));
    }

    public static int[] partition(int[] arr, int x) {
        for (int i = 0, lt = 0, gt = arr.length - 1; i < gt; ) {
            if (arr[i] < x)
                swap(arr, lt++, i++);
            else if (arr[i] > x)
                swap(arr, gt--, i);
            else
                i++;
        }

        return arr;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
