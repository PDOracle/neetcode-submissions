class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        sol = []
        index = 0
        while index < len(nums) - 1:
            target = nums[index] * -1
            l, r = index + 1, len(nums)-1
            while l < r:
                if nums[l] + nums[r] == target:
                    sol.append([nums[l], nums[r], nums[index]])
                    l += 1
                    while l < r and nums[l-1] == nums[l]:
                        l += 1
                    r -= 1
                    while l < r and nums[r] == nums[r+1]: 
                        r -= 1
                elif nums[l] + nums[r] < target:
                    l += 1
                    while l < r and nums[l-1] == nums[l]:
                        l += 1
                else:
                    r -= 1
                    while l < r and nums[r] == nums[r+1]: 
                        r -= 1
            index += 1
            while index < len(nums) and nums[index-1] == nums[index]:
                index += 1
        return sol