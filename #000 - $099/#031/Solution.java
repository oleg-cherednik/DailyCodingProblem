/**
 * @author Oleg Cherednik
 * @since 01.02.2019
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(getEditDistance("kitten", "sitting"));
        System.out.println(getEditDistance("foo", "bar"));
        System.out.println(getEditDistance("money", "rooney"));
    }

    public static int getEditDistance(String one, String two) {
        int[] arr = new int[26];

        for (int i = 0; i < one.length(); i++)
            arr[one.charAt(i) - 'a']++;

        for (int i = 0; i < two.length(); i++)
            arr[two.charAt(i) - 'a']--;

        int add = 0;
        int sub = 0;

        for (int delta : arr) {
            if (delta > 0)
                add += delta;
            else if (delta < 0)
                sub += Math.abs(delta);
        }

        return Math.max(add, sub);
    }

}
