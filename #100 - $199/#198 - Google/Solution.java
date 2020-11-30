import java.util.Arrays;

/**
 * @author Oleg Cherednik
 * @since 03.06.2019
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(Arrays.toString(findLargestSubsetWithCondition(new int[] { 3, 5, 10, 20, 21 })));    // { 5, 10, 20 }
        System.out.println(Arrays.toString(findLargestSubsetWithCondition(new int[] { 1, 3, 6, 24 })));    // { 1, 3, 6, 24 }
    }

    public static int[] findLargestSubsetWithCondition(int[] arr) {
        int length = 0;
        int offs = 0;

        for (int i = 0, j = 0; j < arr.length; ) {
            int min = Math.min(arr[i], arr[j]);
            int max = Math.max(arr[i], arr[j]);

            if (max % min == 0) {
                if (j - i + 1 > length) {
                    length = j - i + 1;
                    offs = i;
                }

                j++;
            } else
                i = j;
        }

        int[] res = new int[length];

        for (int i = 0; i < length; i++)
            res[i] = arr[offs + i];

        return res;
    }

}
