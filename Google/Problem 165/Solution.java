import java.util.Arrays;

/**
 * @author Oleg Cherednik
 * @since 31.03.2019
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(Arrays.toString(modify(new int[] { 3, 4, 9, 6, 1 }))); // [1, 1, 2, 1, 0]
    }

    public static int[] modify(int[] arr) {
        int[] res = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[i])
                    continue;

                res[i] = arr[j] == arr[i] ? res[j] : res[j] + 1;
                break;
            }
        }

        return res;
    }

}
