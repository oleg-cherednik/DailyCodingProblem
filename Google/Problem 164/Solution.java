/**
 * @author Oleg Cherednik
 * @since 31.03.2019
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(findDuplicate(new int[] { 1, 2, 3, 4, 5, 3 })); // 3
        System.out.println(findDuplicate(new int[] { 1, 2, 3, 4, 4, 5 })); // 4
    }

    public static int findDuplicate(int[] arr) {
        int expected = 0;
        int actual = 0;

        for (int i = 0; i < arr.length; i++) {
            expected += i;
            actual += arr[i];
        }

        return actual - expected;
    }

}
