/**
 * @author Oleg Cherednik
 * @since 27.05.2019
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(findSmallest(13)); // 2
        System.out.println(findSmallest(27)); // 3
    }

    public static int findSmallest(int n) {
        if (n == 0)
            return 0;

        int[] cache = new int[n + 1];

        for (int i = 1; i < cache.length; i++)
            cache[i] = Integer.MAX_VALUE;

        for (int i = 1; i < cache.length; i++) {
            int j = 1;

            while (j * j <= i) {
                cache[i] = Math.min(cache[i], cache[i - j * j] + 1);
                j++;
            }
        }

        return cache[n];
    }


}
