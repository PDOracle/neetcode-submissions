class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        vals = {}
        for i in range(len(nums)):
            if nums[i] not in vals.keys():
                vals[target - nums[i]] = i
            else:
                return [vals.get(nums[i]), i]
