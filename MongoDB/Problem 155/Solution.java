import java.util.HashMap;
import java.util.Map;

/**
 * @author Oleg Cherednik
 * @since 28.02.2019
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(findMajorityElement(new int[] { 1, 2, 1, 1, 3, 4, 0 }));   // 1
    }

    public static int findMajorityElement(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = -1;

        for (int num : arr) {
            int count = map.getOrDefault(num, 0) + 1;

            if (res == -1 || count > map.getOrDefault(res, 0))
                res = num;

            map.put(num, count);
        }

        return res;
    }

}
