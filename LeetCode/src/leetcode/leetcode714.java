package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author Lings
 * @Version 1.0
 */
public class leetcode714 {
    public static void main(String[] args) {
//        给定一个整数数组prices，其中第i个元素代表了第i天的股票价格 ；整数fee 代表了交易股票的手续费用。
//        你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
//        返回获得利润的最大值。
//        注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
//
//        示例 1：
//        输入：prices = [1, 3, 2, 8, 4, 9], fee = 2
//        输出：8
//        解释：能够达到的最大利润:
//        在此处买入prices[0] = 1
//        在此处卖出 prices[3] = 8
//        在此处买入 prices[4] = 4
//        在此处卖出 prices[5] = 9
//        总利润:((8 - 1) - 2) + ((9 - 4) - 2) = 8
//
//        示例 2：
//        输入：prices = [1,3,7,5,10,3], fee = 3
//        输出：6
//
//        提示：
//        1 <= prices.length <= 5 * 10^4
//        1 <= prices[i] < 5 * 10^4
//        0 <= fee < 5 * 10^4
        int[] a = {1,3,2,8,4,9};// 8
        System.out.println(Arrays.toString(a) + " 2 8 " + maxProfit(a,2));
        int[] b = {1,3,7,5,10,3};// 6
        System.out.println(Arrays.toString(b) + " 3 6 " + maxProfit(b,3));
        int[] c = {1,4,6,2,8,3,10,14};// 13
        System.out.println(Arrays.toString(c) + " 3 13 " + maxProfit(c,3));
        int[] d = {4,5,2,4,3,3,1,2,5,4};// 4
        System.out.println(Arrays.toString(d) + " 1 4 " + maxProfit(d,1));
        int[] e = {2,1,4,4,2,3,2,5,1,2};// 4
        System.out.println(Arrays.toString(e) + " 1 4 " + maxProfit(e,1));
        int[] f = {1,2,1,5,3,5,5,4,1,5};// 11
        System.out.println(Arrays.toString(f) + " 0 11 " + maxProfit(f,0));

    }

    public static int maxProfit(int[] prices, int fee) {
        // 贪心解法：假设第一天买入的时候加上手续费为股票价格
        int amount = 0;//股票收益
        int buy = prices[0] + fee;//买入价 ：第一天假设以 股票价格+手续费 买入
        for (int i = 1; i < prices.length; ++i) {
            if (prices[i] + fee < buy)// 判断下一天是否存在更便宜的 股票价格+手续费 更新最低价买入价 这里相当于重新开始了一轮交易了，所以要对比加上的手续费
                buy = prices[i] + fee;
            else if (prices[i] > buy){// 如果当天 股票价格 > 买入价 ，则计算当天的股票收益
                amount += prices[i]- buy; // 累计持续收益
                buy = prices[i];// 更新 最新买入价 应对股票持续上涨情况 不重复购买花销手续费
            }
        }
        return amount;
    }
}
