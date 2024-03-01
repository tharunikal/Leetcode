class Solution:
    def maximumOddBinaryNumber(self, s: str) -> str:
        chars = sorted(s)
        for i in range(len(chars) - 1, -1, -1):
            if chars[i] == '1':
                chars[i], chars[-1] = chars[-1], chars[i]
                break
        return ''.join(chars)
