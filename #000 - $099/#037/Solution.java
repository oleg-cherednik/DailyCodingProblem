import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Oleg Cherednik
 * @since 02.02.2019
 */
public class Solution {

    public static void main(String... args) {
        getPowerSet(new int[] { 1, 2, 3 }).forEach(arr -> System.out.println(Arrays.toString(arr)));
    }

    public static List<int[]> getPowerSet(int[] arr) {
        List<int[]> res = new ArrayList<>();
        res.add(new int[0]);

        for (int length = 1; length <= arr.length; length++) {
            for (int i = 0; i <= arr.length - length; i++) {
                int[] tmp = new int[length];
                System.arraycopy(arr, i, tmp, 0, length);
                res.add(tmp);
            }
        }

        return res;
    }

}
