class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        num_set = set(nums)
        sol = 0
        for num in num_set:
            if num - 1 not in num_set:
                count = 1
                while num + count in num_set:
                    count += 1
                if count > sol:
                    sol = count
        return sol