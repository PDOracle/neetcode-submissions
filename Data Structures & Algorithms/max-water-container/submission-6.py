class Solution:
    def maxArea(self, heights: List[int]) -> int:
        maximum = 0
        l, r = 0, len(heights) - 1
        while l < r:
            minimum = min(heights[l], heights[r])
            maximum = max(maximum, minimum * (r - l))
            if heights[l] == heights[r]:
                while l < r and heights[l + 1] <= minimum:
                    l += 1
                l += 1
                while l < r and heights[r - 1] <= minimum:
                    r -= 1
                r -= 1
            elif heights[l] > heights[r]:
                while l < r and heights[r - 1] <= minimum:
                    r -= 1
                r -= 1
            else:
                while l < r and heights[l + 1] <= minimum:
                    l += 1
                l += 1
        return maximum