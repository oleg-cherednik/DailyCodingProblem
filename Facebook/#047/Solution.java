/**
 * @author Oleg Cherednik
 * @since 28.12.2018
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(getMaxProfit(new int[] { 9, 11, 8, 5, 7, 10 }));   // 5
    }

    public static int getMaxProfit(int[] stockPrices) {
        int maxProfit = 0;
        int min = stockPrices[0];

        for (int day = 1; day < stockPrices.length; day++) {
            int curMaxProfit = stockPrices[day] - min;
            maxProfit = day == 1 ? curMaxProfit : Math.max(maxProfit, curMaxProfit);
            min = Math.min(min, stockPrices[day]);
        }

        return maxProfit;
    }
}
