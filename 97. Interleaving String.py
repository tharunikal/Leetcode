class Solution:
    @cache
    def isInterleave(self, s1: str, s2: str, s3: str) -> bool:
        return True if (len(s1) == len(s2) == len(s3) == 0) or (s3 and (((s1 and s3[0] == s1[0]) and self.isInterleave(s1[1:], s2, s3[1:])) or ((s2 and s3[0] == s2[0]) and self.isInterleave(s1, s2[1:], s3[1:])))) else False
