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
                '''
                countl, countr = 1, 1
                while l + countl < r and heights[l] >= heights[l + countl]:
                    countl += 1
                l += countl
                while l < r - countr and heights[r] >= heights[r - countr]:
                    countr += 1
                r -= countr
                '''
            elif heights[l] > heights[r]:
                '''
                countr = 1
                while l < r - countr and heights[r] >= heights[r - countr]:
                    countr += 1
                r -= countr
                '''
                while l < r and heights[r - 1] <= minimum:
                    r -= 1
                r -= 1
            else:
                '''
                countl = 1
                while l + countl < r and heights[l] >= heights[l + countl]:
                    countl += 1
                l += countl
                '''
                while l < r and heights[l + 1] <= minimum:
                    l += 1
                l += 1
        return maximum