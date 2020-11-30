import java.util.Arrays;

/**
 * @author Oleg Cherednik
 * @since 14.01.2019
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 })));
        System.out.println(Arrays.toString(sort(new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 })));
        System.out.println(Arrays.toString(sort(new int[] { 18, 3, 11, 5, 9, 17, 18, 13, 5, 7 })));
    }

    public static int[] sort(int[] arr) {
        // bubble sort (but Pancake sorting should be)
        for (int left = 0, right = arr.length - 1; left < right; left++, right--) {
            for (int i = left; i < right; i++)
                if (arr[i] > arr[i + 1])
                    reverse(arr, i, i + 1);

            for (int i = right; i > left; i--)
                if (arr[i - 1] > arr[i])
                    reverse(arr, i - 1, i);
        }

        return arr;
    }

    private static void reverse(int[] arr, int i, int j) {
        while (i < j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
    }

}
