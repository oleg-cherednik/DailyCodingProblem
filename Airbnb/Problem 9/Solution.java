/**
 * @author Oleg Cherednik
 * @since 08.12.2018
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(largesNonAdjacentNumbersSumb(new int[] { 2, 4, 6, 2, 5 }));  // 13
        System.out.println(largesNonAdjacentNumbersSumb(new int[] { 5, 1, 1, 5 }));  // 10
        System.out.println(largesNonAdjacentNumbersSumb(new int[] { 5, 1, -1, -1, 5 }));  // 10
    }

    public static int largesNonAdjacentNumbersSumb(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;
        if (arr.length == 1)
            return arr[0];
        if (arr.length == 2)
            return Math.max(arr[0], arr[1]);

        for (int i = 2; i < arr.length; i++) {
            if (i > 2)
                arr[i] = Math.max(arr[i - 2], arr[i - 3]) + Math.max(0, arr[i]);
            else
                arr[i] = arr[i - 2] + Math.max(0, arr[i]);
        }

        return Math.max(arr[arr.length - 1], arr[arr.length - 2]);
    }

}
