import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Oleg Cherednik
 * @since 16.01.2019
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(sum(1, 3)); // 5
    }

    private static final Map<Integer, Long> SUM = new HashMap<>();

    static {
        int i = 0;
        long sum = 0;

        SUM.put(-1, 0L);

        for (int num : Arrays.asList(1, 2, 3, 4, 5, 6))
            SUM.put(i++, sum += num);
    }

    public static long sum(int i, int j) {
        return SUM.get(j - 1) - SUM.get(i - 1);
    }

}
