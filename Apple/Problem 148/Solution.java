import java.util.Arrays;

/**
 * @author Oleg Cherednik
 * @since 16.02.2019
 */
public class Solution {

    public static void main(String... args) {
        int length = 3;
        Arrays.stream(grayCode(length))
              .mapToObj(code -> String.format("%" + length + 's', Integer.toBinaryString(code)).replace(' ', '0'))
              .forEach(System.out::println);
    }

    public static int[] grayCode(int n) {
        return gray(0, n, new int[(int)Math.pow(2, n)]);
    }

    private static int[] gray(int curLength, int maxLength, int[] codes) {
        if (curLength > maxLength)
            return codes;
        if (curLength == 0)
            codes[0] = 0;
        else
            for (int i = 0, t = 1 << (curLength - 1); i < t; i++)
                codes[t + i] = codes[t - i - 1] + (1 << (curLength - 1));

        return gray(curLength + 1, maxLength, codes);
    }

}
