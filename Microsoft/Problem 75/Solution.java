/**
 * @author Oleg Cherednik
 * @since 07.02.2019
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(findLongestIncreasingSubsequence(new int[]{0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15}));  // 6
    }

    public static int findLongestIncreasingSubsequence(int[] arr) {
        int[] tmp = new int[arr.length];
        int res = 0;

        for (int i = 0; i < arr.length; i++) {
            int max = 0;

            for (int j = 0; j < i; j++)
                if (arr[j] < arr[i])
                    max = Math.max(max, tmp[j]);

            tmp[i] = max + 1;
            res = Math.max(res, tmp[i]);
        }

        return res;
    }

}
