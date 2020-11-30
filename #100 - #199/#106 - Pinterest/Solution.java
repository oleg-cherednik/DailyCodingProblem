/**
 * @author Oleg Cherednik
 * @since 11.02.2019
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(check1(2, 0, 1, 0));      // true
        System.out.println(check1(1, 1, 0, 1));      // false
        System.out.println(check1(2, 3, 1, 0, 0));   // true

        System.out.println(check2(2, 0, 1, 0));      // true
        System.out.println(check2(1, 1, 0, 1));      // false
        System.out.println(check2(2, 3, 1, 0, 0));   // true
    }

    public static boolean check1(int... arr) {
        boolean[] tmp = new boolean[arr.length];
        tmp[tmp.length - 1] = true;

        for (int i = tmp.length - 2; i >= 0; i--) {
            if (arr[i] + i >= arr.length)
                tmp[i] = true;
            else {
                for (int j = i + 1; j < arr[i] + i + 1; j++) {
                    if (tmp[j]) {
                        tmp[i] = true;
                        break;
                    }
                }
            }
        }

        return tmp[0];
    }

    public static boolean check2(int... arr) {
        for (int i = 0, max = 1; i < arr.length - 1; i++)
            if ((max = Math.max(max - 1, arr[i])) == 0)
                return false;

        return true;
    }

}
