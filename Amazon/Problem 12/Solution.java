import java.util.Arrays;

/**
 * @author Oleg Cherednik
 * @since 27.01.2019
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(countUniqueWays(1, 1, 2)); // 1
        System.out.println(countUniqueWays(2, 1, 2)); // 2
        System.out.println(countUniqueWays(3, 1, 2)); // 3
        System.out.println(countUniqueWays(4, 1, 2)); // 5

        System.out.println(countUniqueWays(4, 1, 3, 5)); // 3
    }

    public static int countUniqueWays(int n, int... steps) {
        Arrays.sort(steps);
        return _countUniqueWays(n, 0, 0, steps);
    }

    private static int _countUniqueWays(int n, int cur, int res, int... steps) {
        if (cur == n)
            res++;

        if (cur < n) {
            for (int i = 0; i < steps.length; i++)
                res = _countUniqueWays(n, cur + steps[i], res, steps);
        }

        return res;
    }

}
