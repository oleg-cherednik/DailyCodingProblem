import java.util.Arrays;

/**
 * @author Oleg Cherednik
 * @since 20.01.2021
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(Arrays.toString(getMinMax(4, 2, 7, 5, -1, 3, 6)));   // [-1, 7]
    }

    public static int[] getMinMax(int... arr) {
        int min = arr[0];
        int max = arr[0];

        for (int i = 1; i < arr.length; i += 2) {
            int one = arr[i];
            int two = i + 1 < arr.length ? arr[i + 1] : arr[i];
            boolean oneLess = one < two;

            min = Math.min(min, oneLess ? one : two);
            max = Math.max(max, oneLess ? two : one);
        }

        return new int[] { min, max };
    }

}
