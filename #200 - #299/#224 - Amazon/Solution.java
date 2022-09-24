import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Oleg Cherednik
 * @since 24.09.2022
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(getSmallestImpossibleSum(1, 2, 3, 10));   // 7
    }

    private static int getSmallestImpossibleSum(int... nums) {
        int sum = 1;

        for (int num : nums) {
            if (num > sum)
                break;

            sum += num;
        }

        return sum;
    }

}
