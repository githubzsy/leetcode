package com.zhoushiya.leetcode.algorithm;

/**
 * @author zhoushiya
 * @date 2020/11/8 12:13
 * <p>
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * <p>
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 * 示例 2:
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 示例 3:
 * <p>
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= prices.length <= 3 * 10 ^ 4
 * 0 <= prices[i] <= 10 ^ 4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BestTimeToBuyAndSellStockII {
    public BestTimeToBuyAndSellStockII() {

    }

    /**
     * 官方解答：贪心算法，所有上涨日都买卖（计算利润），所有下跌日都不买卖（不计算利润）
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int ans = 0;
        int n = prices.length;
        for (int i = 1; i < n; ++i) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        return ans;
    }

    public int myMethod(int[] prices) {
        int buyPrice = -1;
        int salePrice = -1;
        int result = 0;

        for (int i = 0; i < prices.length; i++) {
            // 如果已持有股票
            if (buyPrice != -1) {
                // 且今天价格比昨天高
                if (i > 0 && prices[i] > prices[i - 1]) {
                    // 则继续更新股票售价
                    salePrice = prices[i];
                } else {
                    // 否则按昨天价格卖出股票
                    result += (salePrice - buyPrice);
                    salePrice = -1;
                    buyPrice = -1;
                }

                // 最后一天也要卖出股票
                if(i == prices.length-1 && salePrice!=-1){
                    result += (salePrice - buyPrice);
                    salePrice = -1;
                    buyPrice = -1;
                }
            }


            // 如果未持有股票
            // 且明天价格上涨
            // 则购入股票
            if (buyPrice == -1 && i < prices.length - 1 && prices[i] < prices[i + 1]) {
                buyPrice = prices[i];
            }
        }


        return result;


    }
}
