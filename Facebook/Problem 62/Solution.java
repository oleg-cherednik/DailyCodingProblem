/**
 * @author Oleg Cherednik
 * @since 04.02.2019
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(countTotalWays(2, 2));    // 2
        System.out.println(countTotalWays(3, 4));    // 10
    }

    public static int countTotalWays(int N, int M) {
        int[] arr = new int[M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i == 0)
                    arr[j] = 1;
                else
                    arr[j] += j == 0 ? 0 : arr[j - 1];
            }
        }

        return arr[M - 1];
    }
}
