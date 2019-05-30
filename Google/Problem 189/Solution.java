import java.util.HashSet;
import java.util.Set;

/**
 * @author Oleg Cherednik
 * @since 31.05.2019
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(getLongestDistinctLength(new int[] { 5, 1, 3, 5, 2, 3, 4, 1 }));   // 5
    }

    public static int getLongestDistinctLength(int[] arr) {
        int res = 0;
        Set<Integer> unique = new HashSet<>();

        for (int i = 0, j = 0; j < arr.length; ) {
            if (unique.contains(arr[j]))
                unique.remove(arr[i++]);
            else {
                unique.add(arr[j]);
                res = Math.max(res, unique.size());
                j++;
            }
        }

        return res;
    }
}
