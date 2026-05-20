class Solution:
    def maxArea(self, heights: List[int]) -> int:
        ''' First Solution(Brute Force)
        f = 0
        maximum = 0
        while f < len(heights) - 1:
            s = f + 1
            while s < len(heights):
                maximum = max(maximum, min(heights[f], heights[s]) * (s - f))
                s += 1
            f += 1
        return maximum
        '''
        maximum = 0
        l, r = 0, len(heights) - 1
        while l < r:
            maximum = max(maximum, min(heights[l], heights[r]) * (r - l))
            if heights[l] == heights[r]:
                countl, countr = 1, 1
                while l + countl < r and heights[l] >= heights[l + countl]:
                    countl += 1
                l += countl
                while l < r - countr and heights[r] >= heights[r - countr]:
                    countr += 1
                r -= countr
            elif heights[l] > heights[r]:
                countr = 1
                while l < r - countr and heights[r] >= heights[r - countr]:
                    countr += 1
                r -= countr
            else:
                countl = 1
                while l + countl < r and heights[l] >= heights[l + countl]:
                    countl += 1
                l += countl
        return maximum
