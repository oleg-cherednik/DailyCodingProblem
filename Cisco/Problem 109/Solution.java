/**
 * @author Oleg Cherednik
 * @since 05.12.2019
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(Integer.toBinaryString(swapEvenOddBIts(0b10101010)));
        System.out.println(Integer.toBinaryString(swapEvenOddBIts(0b11100010)));
    }

    private static int swapEvenOddBIts(int val) {
        return (val & 0b01010101) << 1 | (val & 0b10101010) >> 1;
    }

}
