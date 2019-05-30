/**
 * @author Oleg Cherednik
 * @since 31.04.2019
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(getGreatestCommonDenominator(new int[] { 42, 56, 14 }));  // 14
    }

    public static int getGreatestCommonDenominator(int[] arr) {
        int min = getMin(arr);

        for (int i = 1, j = min / 2; i < j; i++) {
            int k = min / i;

            if (isAccepted(k, arr))
                return k;
        }

        return Integer.MAX_VALUE;
    }

    private static int getMin(int[] arr) {
        int min = Integer.MAX_VALUE;

        for (int val : arr)
            min = Math.min(min, val);

        return min;
    }

    private static boolean isAccepted(int k, int[] arr) {
        for (int val : arr)
            if (val % k != 0)
                return false;
        return true;
    }


}
