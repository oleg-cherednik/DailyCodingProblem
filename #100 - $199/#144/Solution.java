import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Oleg Cherednik
 * @since 18.01.2019
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(findNearestLargerNumberIndex(0));
    }

    private static final int[] arr = { 4, 1, 3, 5, 6, 4 };
    private static final Map<Integer, Set<Integer>> mapNumPos = new HashMap<>();
    private static final Map<Integer, Integer> mapNumNextNum = new HashMap<>();

    static {
        Set<Integer> unique = new TreeSet<>();

        for (int i = 0; i < arr.length; i++) {
            unique.add(arr[i]);

            if (!mapNumPos.containsKey(arr[i]))
                mapNumPos.put(arr[i], new HashSet<>());

            mapNumPos.get(arr[i]).add(i);
        }

        Integer prv = null;

        for (Integer num : unique) {
            if (prv != null)
                mapNumNextNum.put(prv, num);
            prv = num;
        }
    }

    public static int findNearestLargerNumberIndex(int i) {
        int num = arr[i];
        Integer nextNum = mapNumNextNum.get(num);
        Set<Integer> nextNumPos = nextNum != null ? mapNumPos.get(nextNum) : Collections.emptySet();
        return nextNumPos.isEmpty() ? -1 : nextNumPos.iterator().next();
    }
}
