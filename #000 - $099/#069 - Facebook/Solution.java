import java.util.Arrays;

/**
 * @author Oleg Cherednik
 * @since 07.02.2019
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(maxTriplet(new int[] { -10, -10, 5, 2 }));   // 500
    }

    public static int maxTriplet(int[] arr) {
        Arrays.sort(arr);
        int res = arr[arr.length - 1];
        return Math.max(res, arr[arr.length - 3] * arr[arr.length - 2] * arr[arr.length - 1]);
    }
}
