/**
 * @author Oleg Cherednik
 * @since 04.06.2019
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(findOffs(new int[] { 5, 7, 10, 3, 4 })); // 3
        System.out.println(findOffs(new int[] { 4, 5, 6, 7, 1, 2, 3 })); // 4
        System.out.println(findOffs(new int[] { 2, 1 })); // 1
    }

    public static int findOffs(int[] arr) {
        return find(arr, 0, arr.length - 1);
    }

    private static int find(int[] arr, int i, int j) {
        if (i == j)
            return i;
        int mid = (i + j) / 2;
        return arr[mid] < arr[j] ? find(arr, i, mid) : find(arr, mid + 1, j);
    }

}
