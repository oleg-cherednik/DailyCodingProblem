/**
 * @author Oleg Cherednik
 * @since 04.06.2019
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(isPalindrome(121));  // true
        System.out.println(isPalindrome(888));  // true
        System.out.println(isPalindrome(678));  // true
    }

    public static boolean isPalindrome(int val) {
        int width = getWidth(val);

        for (int i = 0, j = width - 1; i < j; i++, j--)
            if (getDigit(val, i) != getDigit(val, j))
                return false;

        return true;
    }

    private static int getWidth(int val) {
        int width = 0;

        while (val != 0) {
            width++;
            val /= 10;
        }

        return width;
    }

    private static int getDigit(int val, int i) {
        while (i-- > 0) {
            val /= 10;
        }

        return val % 10;
    }

}
