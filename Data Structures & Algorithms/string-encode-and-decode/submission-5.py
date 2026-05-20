class Solution:

    def encode(self, strs: List[str]) -> str:
        if not strs:
            return ""
        encoded = ""
        str_sizes = []
        for string in strs:
            str_sizes.append(len(string))
        for size in str_sizes:
            encoded += str(size) + ','
        encoded += '#'
        encoded += ''.join(strs)
        return encoded
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
