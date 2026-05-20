class Solution:
    def isPalindrome(self, s: str) -> bool:
        alnum = ''.join(char.lower() for char in s if char.isalnum())
        l, r = 0, len(alnum) - 1
        while l <= r:
            if alnum[l] != alnum[r]:
                return False
            l += 1
            r -= 1
        return True