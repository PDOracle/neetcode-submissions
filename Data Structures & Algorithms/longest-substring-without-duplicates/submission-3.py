class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        sol = 0
        chars = set()
        l, r = 0, 0
        while r < len(s):
            while s[r] not in chars:
                chars.add(s[r])
                r += 1
                if r >= len(s):
                    return max(sol, r - l)
            sol = max(sol, r - l)
            if s[l] == s[r]:
                l += 1
            else:
                while s[l] != s[r]:
                    chars.remove(s[l])
                    l += 1
                l += 1
            r += 1
            sol = max(sol, r - l)
        sol = max(sol, r - l)
        return sol