/**
 * @author Oleg Cherednik
 * @since 14.02.2019
 */
public class Solution {

    public static void main(String... args) {
        BitArray bitArray = new BitArray(16);
        bitArray.set(5, true);
        bitArray.set(6, true);
        bitArray.set(7, true);
        bitArray.set(9, true);
        bitArray.set(13, true);
        bitArray.set(15, true);

        for (int i = 0; i < 16; i++)
            System.out.println(i + ":" + bitArray.get(i));
    }

    public static final class BitArray {
        private static final int INDEX_LENGTH = 8;    // size of int

        private final int[] arr;

        public BitArray(int size) {
            arr = new int[size / INDEX_LENGTH + (size % INDEX_LENGTH != 0 ? 1 : 0)];
        }

        public void set(int i, boolean val) {
            if (val)
                arr[getArrayIndex(i)] |= getBitMask(i);
            else
                arr[getArrayIndex(i)] &= ~getBitMask(i);
        }

        public boolean get(int i) {
            return (arr[getArrayIndex(i)] & getBitMask(i)) != 0;
        }

        private static int getArrayIndex(int i) {
            return i / INDEX_LENGTH;
        }

        private static int getBitMask(int i) {
            return 1 << i % INDEX_LENGTH;
        }
    }

}
