class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        anagrams = {}
        for i in range(len(strs)):
            curr = strs[i]
            curr_list = list(curr)
            curr_list.sort()
            s = ''.join(curr_list)
            if s not in anagrams:
                anagrams[s] = [curr]
            else:
                anagrams[s].append(curr)
        return list(anagrams.values())