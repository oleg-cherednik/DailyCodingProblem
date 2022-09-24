/**
 * @author Oleg Cherednik
 * @since 24.09.2022
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(getTotalNumber(6, 12));  // 4
    }

    private static int getTotalNumber(int N, int X) {
        int res = 0;

        for (int i = 1; i <= N; i++)
            if (X % i == 0 && X / i <= N)
                res++;

        return res;
    }

}
