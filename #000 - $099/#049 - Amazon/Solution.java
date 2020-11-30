/**
 * @author Oleg Cherednik
 * @since 03.02.2019
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(findMaxSum(34, -50, 42, 14, -5, 86));    // 137
        System.out.println(findMaxSum(-5, -1, -8, -9));    // 0
    }

    public static int findMaxSum(int... arr) {
        int maxSum = 0;

        for (int i = 0, sum = 0; i < arr.length; i++) {
            maxSum = Math.max(maxSum, arr[i]);
            maxSum = Math.max(maxSum, sum = Math.max(sum + arr[i], 0));
        }

        return maxSum;
    }

}
