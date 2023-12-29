class Solution:
    def minDifficulty(self, jobDifficulty, d):
        if len(jobDifficulty) < d:
            return -1
        total_sum = sum(jobDifficulty)
        if total_sum == 0:
            return 0
        return self.helper(jobDifficulty, d, 0)

    def helper(self, jd, daysLeft, idx):
        length = len(jd)
        if daysLeft == 1:
            return max(jd[idx:])
        
        max_difficulty = jd[idx]
        daysLeft -= 1
        stop = length - idx - daysLeft + 1

        result = float('inf')
        for i in range(1, stop):
            max_difficulty = max(max_difficulty, jd[idx + i - 1])
            other = self.helper(jd, daysLeft, idx + i)
            result = min(result, other + max_difficulty)
        return result
