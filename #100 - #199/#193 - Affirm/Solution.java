/**
 * @author Oleg Cherednik
 * @since 23.09.2022
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(calcMaxProfit1(new int[] { 1, 3, 2, 8, 4, 10 }, 2)); // 9
        System.out.println(calcMaxProfit(new int[] { 1, 3, 2, 8, 4, 10 }, 2));  // 9
    }

    private static int calcMaxProfit1(int[] prices, int fee) {
        int curMaxProfit = 0;
        int hold = prices[0];

        for (int i = 1; i < prices.length; i++) {
            curMaxProfit = Math.max(curMaxProfit, prices[i] - hold - fee);
            hold = Math.min(hold, prices[i] - curMaxProfit);
        }

        return curMaxProfit;
    }

    private static int calcMaxProfit(int[] prices, int fee) {
        return calcMaxProfit(prices, 0, fee);
    }

    private static int calcMaxProfit(int[] prices, int lo, int fee) {
        if (lo >= prices.length - 1)
            return 0;

        int i = lo + 1;
        int maxProfit = 0;

        for (; i < prices.length; i++) {
            int curProfit = prices[i] - prices[lo] - fee;

            if (curProfit > 0) {
                int curMaxProfit = calcMaxProfit(prices, i + 1, fee);
                maxProfit = Math.max(maxProfit, curProfit + curMaxProfit);
            }
        }

        return maxProfit;
    }

}
