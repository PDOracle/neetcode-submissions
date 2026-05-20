class Solution:
    def maxArea(self, heights: List[int]) -> int:
        f = 0
        maximum = 0
        while f < len(heights) - 1:
            s = f + 1
            while s < len(heights):
                maximum = max(maximum, min(heights[f], heights[s]) * (s - f))
                s += 1
            f += 1
        return maximum
