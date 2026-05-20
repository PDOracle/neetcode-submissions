class Solution:

    def encode(self, strs: List[str]) -> str:
        if not strs:
            return ""
        encoder = ""
        str_sizes = []
        for string in strs:
            str_sizes.append(len(string))
        for size in str_sizes:
            encoder += str(size) + ','
        encoder += '#'
        '''for s in strs:
            encoder += s
        return encoder'''
        encoder += ''.join(strs)
        return encoder
    def decode(self, s: str) -> List[str]:
        if not s:
            return []
        size_list = []
        sol = []
        count = 0
        while s[count] != '#':
            curr = ""
            while s[count] != ',':
                curr += s[count]
                count += 1
            size_list.append(int(curr))
            count += 1
        count += 1
        for i in range(len(size_list)):
            sol.append(s[count:count + size_list[i]])
            count += size_list[i] 
        return sol
