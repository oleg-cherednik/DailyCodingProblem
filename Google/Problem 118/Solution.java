import java.util.Arrays;

/**
 * @author Oleg Cherednik
 * @since 12.12.2018
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(Arrays.toString(squareAndSort(-9, -2, 0, 2, 3)));
    }

    public static int[] squareAndSort(int... sorted) {
        int[] res = new int[sorted.length];

        for (int i = 0, j = sorted.length - 1, k = res.length - 1; i <= j; k--) {
            int absLeft = Math.abs(sorted[i]);
            int absRight = Math.abs(sorted[j]);

            if (absLeft >= absRight) {
                res[k] = absLeft * absLeft;
                i++;
            } else {
                res[k] = absRight * absRight;
                j--;
            }
        }

        return res;
    }

}
