class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        sol = []
        before_prod = [1] * len(nums)
        after_prod = [1] * len(nums)
        for i in range(1, len(nums)):
            before_prod[i] = before_prod[i-1] * nums[i-1]
        for i in range(len(nums) - 2, -1, -1):
            after_prod[i] = after_prod[i+1] * nums[i+1]
        for i in range(len(nums)):
            sol.append(before_prod[i] * after_prod[i])
        return sol