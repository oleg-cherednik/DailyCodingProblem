import java.util.Arrays;

/**
 * @author Oleg Cherednik
 * @since 18.01.2019
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(Arrays.toString(getSum(new int[]{1, 2, 3, 4, 5}, 9)));
    }

    public static int[] getSum(int[] arr, int k) {
        int i = 0;
        int j = 0;
        int sum = 0;

        while (j <= arr.length && sum != k) {
            if (sum < k)
                sum += arr[j++];
            else
                sum -= arr[i++];
        }

        int[] res = new int[j - i];
        System.arraycopy(arr, i, res, 0, res.length);

        return res;
    }

}
