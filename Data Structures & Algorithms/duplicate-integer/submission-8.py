class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        sol = set()
        for i in range(len(nums)):
            if nums[i] in sol:
                return True
            sol.add(nums[i])
        return False