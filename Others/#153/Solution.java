/**
 * @author Oleg Cherednik
 * @since 28.02.2019
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(getMinDistance("dog cat hello cat dog dog hello cat world", "hello", "world"));   // 1
    }

    public static int getMinDistance(String str, String one, String two) {
        String[] words = str.split("\\s+");

        int posOne = -1;
        int posTwo = -1;
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(one))
                posOne = i;
            else if (words[i].equals(two))
                posTwo = i;
            else
                continue;

            if (posOne != -1 && posTwo != -1)
                res = Math.min(res, Math.abs(posTwo - posOne) - 1);
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }

}
