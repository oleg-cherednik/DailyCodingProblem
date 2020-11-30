/**
 * @author Oleg Cherednik
 * @since 31.04.2019
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(findMaxSubarraySum(new int[] { 8, -1, 3, 4 }));  // 15;
        System.out.println(findMaxSubarraySum(new int[] { -4, 5, 1, 0 }));  // 6;
    }

    public static int findMaxSubarraySum(int[] arr) {
        int[] sum = new int[arr.length];
        sum[0] = arr[0];

        for (int i = 1; i < sum.length; i++)
            if (arr[i] >= 0)
                sum[i] = Math.max(sum[i - 1] + arr[i], arr[i]);
            else
                sum[i] = arr[i];

        int max = 0;
        int left = sum[0];

        for (int i = 0; i < sum.length; i++) {
            max = Math.max(max, sum[i]);

            if (sum[0] < 0 || i > 0 && sum[i] < sum[i - 1])
                continue;

            left = Math.max(left, max);
        }

        return Math.max(max, left + sum[sum.length - 1]);
    }

}
