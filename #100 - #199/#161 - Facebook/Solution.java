/**
 * @author Oleg Cherednik
 * @since 31.03.2019
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(Long.toBinaryString(reverseBits(0xF0F0F0F0)));   // 0x0F0F0F0F
    }

    public static int reverseBits(int val) {
        for (long i = 1L, j = 1L << 31; i < j; i <<= 1, j >>= 1) {
            if ((val & i) != (val & j))
                val = (int)(val & ~i & val & ~j | (~val & i) | (~val & j));

            System.out.println(Long.toBinaryString(val));
        }

        return val;
    }

}
