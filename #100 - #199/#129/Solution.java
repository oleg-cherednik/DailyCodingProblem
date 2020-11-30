/**
 * @author Oleg Cherednik
 * @since 13.02.2019
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(floorSqrt(81));   // 9
        System.out.println(floorSqrt(9));    // 3
        System.out.println(floorSqrt(200));  // 14
    }

    public static int floorSqrt(int n) {
        if (n == 0 || n == 1)
            return n;

        int lo = 0;
        int hi = n;
        int sqrt = 0;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (mid * mid == n)
                return mid;

            if (mid * mid < n) {
                lo = mid + 1;
                sqrt = mid;
            } else
                hi = mid - 1;
        }

        return sqrt;
    }

}
