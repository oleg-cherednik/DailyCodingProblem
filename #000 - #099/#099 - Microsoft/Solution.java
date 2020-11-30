/**
 * @author Oleg Cherednik
 * @since 11.02.2019
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(findLongestConsecutiveElementsLength(100, 4, 200, 1, 3, 2)); // 4
    }

    public static int findLongestConsecutiveElementsLength(int... arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : arr) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        boolean[] existed = new boolean[max - min + 1];

        for (int num : arr)
            existed[num - min] = true;

        int res = 0;

        for (int i = 0, cur = 0; i < existed.length; i++) {
            if (existed[i])
                res = Math.max(res, ++cur);
            else
                cur = 0;
        }

        return res;
    }

}
