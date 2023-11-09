class Solution(object):
    def countHomogenous(self, s):
        res = 0
        start = 0
        
        for i in range(len(s)):
            if s[i] != s[start]:
                appear = i - start
                while appear > 0:
                    res += appear
                    appear -= 1
                start = i
        
        appear = len(s) - start
        while appear > 0:
            res += appear
            appear -= 1
        
        return int(res % (10**9 + 7))
