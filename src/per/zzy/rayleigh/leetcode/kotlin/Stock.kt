package per.zzy.rayleigh.leetcode.kotlin

import kotlin.math.max
import kotlin.math.min


/**
 * 给定一个数组 prices ，它的第 i 个元素 prices\[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 */
object Stock {
    // 会超时！！！
    // 分别计算当前天数到之后每天的差值，选出最大值，时间复杂度O(n^2)
    fun maxProfit(prices: IntArray): Int {
        var profit = 0
        for (i in prices.indices) {
            for (j in i + 1 ..< prices.size) {
                if (i + 1 >= prices.size) break
                val det = prices[j] - prices[i]
                if (det > profit) {
                    profit = det
                }
            }
        }
        return profit
    }

    // 计算当前和前一天差值，并通过差值计算最大收益
    fun maxProfit2(prices: IntArray): Int {
        var profit = 0
        var temp = 0
        for (i in prices.indices) {
            if (i == 0) continue // 注意越界问题
            val det = prices[i] - prices[i - 1]
            if (temp + det >= 0) {
                temp += det
                if (temp > profit) {
                    profit = temp
                }
            } else {
                // 当收益小于0时，要重置为0，不能小于0
                temp = 0
            }
        }
        return profit
    }

    // 动态规划，记录当天之前的最小值
    fun maxProfit3(prices: IntArray): Int {
        var profit = 0
        var minPrice = Int.MAX_VALUE
        for (p in prices) {
            minPrice = min(minPrice, p)
            profit = max(profit, p - minPrice)
        }
        return profit
    }


    /**
     * 122. 中等难度
     * 给你一个整数数组 prices ，其中 prices\[i] 表示某支股票第 i 天的价格。
     * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
     * 返回 你能获得的 最大 利润 。
     */

    // 计算出所有正差值之和
    fun maxProfit4(prices: IntArray): Int {
        var profit = 0
        for (i in prices.indices) {
            if (i == 0) continue // 注意越界问题
            val det = prices[i] - prices[i - 1]
            if (det > 0) {
                profit += det
            }
        }

        return profit
    }



}