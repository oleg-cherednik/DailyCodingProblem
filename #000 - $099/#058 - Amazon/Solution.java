/**
 * @author Oleg Cherednik
 * @since 05.02.2019
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(findIndexByValue(new int[] { 13, 18, 25, 2, 8, 10 }, 8));    // 4
        System.out.println(findIndexByValue(new int[] { 7, 8, 9, 1, 2, 3, 4, 5, 6 }, 8)); // 1
    }

    public static Integer findIndexByValue(int[] arr, int val) {
        return find(arr, val, 0, arr.length - 1);
    }

    private static Integer find(int[] arr, int val, int left, int right) {
        if (left == right)
            return arr[left] == val ? left : null;

        int mid = (left + right) / 2;

        if (arr[left] <= arr[mid] && arr[left] <= val && val <= arr[mid]
                || arr[mid + 1] <= arr[right] && (arr[mid + 1] > val || val > arr[right]))
            return find(arr, val, left, mid);
        return find(arr, val, mid + 1, right);
    }

}
