package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author alben.wong
 * @since 2020/10/20.
 * leetcode 322. 零钱兑换
 * 这个题目跟爬楼梯类似，但不完全相同
 * 1、回溯
 * 在理解上，回溯是最直接的
 * 用每一种硬币的每一个去进行尝试回溯
 * 2、dp
 * dp需要自下而上的思考
 * dp[i]为组成金额 i 所需最少的硬币数量
 * dp[i] = min{dp[i - coins[j]]} + 1
 *
 */
@Slf4j
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        if(amount == 0 || coins.length == 0){
            return 0;
        }
        return dp(coins, amount);
    }

    private int dp(int[] coins, int amount){
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for(int i = 1; i <= amount; i++){
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if(i - coin >= 0){
                    //加上coin这个硬币
                    min = Math.min(min, dp[i - coin] + 1);
                }
            }
            dp[i] = Math.min(dp[i], min);
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    // 回溯方法的解释
    // 回溯法三要素：退出条件，回溯过程，递归参数
    // 参数为当前用的硬币索引，硬币数组，当前已经产生的数值
    // 最终结果为: coinChange(0, coins, amount)
    private int coinChange(int idxCoin, int[] coins, int amount) {
        // 回溯退出
        if (amount == 0) {
            return 0;
        }
        // 回溯执行的条件，仍然有硬币可用或仍有余额
        if (idxCoin < coins.length && amount > 0) {
            // 当前值用几个当前硬币表示（向下取整）
            int maxVal = amount / coins[idxCoin];
            int minCost = Integer.MAX_VALUE;
            // 回溯核心内容，每取一个当前硬币，探索其他情况，x为当前用了几个该面值硬币
            for (int x = 0; x <= maxVal; x++) {
                // 仍有余额，即为 amount - coins[idxCoin] >= 0
                if (amount >= x * coins[idxCoin]) {
                    // 用下一个硬币试试
                    int res = coinChange(idxCoin + 1, coins, amount - x * coins[idxCoin]);
                    // 回溯成功，下一种情况也有解
                    if (res != -1){
                        // 与目前的最优解比比看
                        minCost = Math.min(minCost, res + x);
                    }
                }
            }
            // 最小代价没有更新，说明所有方案无效
            return (minCost == Integer.MAX_VALUE)? -1: minCost;
        }
        // 没有执行上一个返回那就是一次也没有运行，直接失败
        return -1;
    }

    @Test
    public void test(){
        CoinChange coinChange = new CoinChange();
        int[] coins = new int[]{1, 2, 5};
        int i = coinChange.coinChange(coins, 11);
        log.info("i={}", i);
    }

}
