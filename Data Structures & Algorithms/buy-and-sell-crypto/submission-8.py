class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if len(prices) == 1:
            return 0
        l, r = 0, 1
        min_l = prices[l]
        profit = max(0, (prices[r] - prices[l]))
        while r < len(prices):
            max_r = prices[r]
            while r < len(prices) - 1 and prices[r] <= max_r:
                r += 1
            while l < r - 1 and prices[l] >= min_l:
                l += 1
            min_l = min(prices[l], min_l)
            profit = max(profit, (prices[r] - min_l))
            l = r
            r += 1
        return profit
