/**
 * @author Oleg Cherednik
 * @since 01.06.2019
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(canGetEnd(new int[] { 1, 3, 1, 2, 0, 1 }));   // true
        System.out.println(canGetEnd(new int[] { 1, 2, 1, 0, 0 }));   // false
        System.out.println(canGetEnd(new int[] { 2, 2, 0, 0 }));   // false
    }

    public static boolean canGetEnd(int[] arr) {
        boolean[] tmp = new boolean[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            tmp[i] = i + arr[i] >= arr.length;

            for (int j = i + 1; j <= Math.min(i + arr[i], arr.length - 1) && !tmp[i]; j++)
                tmp[i] = tmp[j];
        }

        return tmp[0];
    }
}
