/**
 * @author Oleg Cherednik
 * @since 29.11.2018
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(findLowestMissingPositive1(new int[] { 3, 4, -1, 1 }));
        System.out.println(findLowestMissingPositive1(new int[] { 1, 2, 0 }));
    }

    public static int findLowestMissingPositive1(int[] arr) {
        if (arr == null || arr.length < 2)
            return -1;

        for (int i = 0; i < arr.length; ) {
            if (arr[i] <= 0 || arr[i] > arr.length || arr[i] - 1 == i)
                i++;
            else
                swap(arr, i, arr[i] - 1);
        }

        for (int i = 0; i < arr.length; i++)
            if (arr[i] - 1 != i)
                return i + 1;

        return -1;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
