class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        tracker = {}
        for i in range(len(nums)):
            if nums[i] not in tracker:
                tracker[nums[i]] = 0
            tracker[nums[i]] += 1
        sort_frequency = sorted(tracker.items(), key = lambda x: x[1], reverse = True)
        sol = []
        for j in range(k):
            sol.append(sort_frequency[j][0])
        return sol