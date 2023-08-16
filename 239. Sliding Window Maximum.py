from collections import deque

class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        dq = deque()
        for n in nums[:k]:
            while dq and n > dq[-1]:
                dq.pop()
            dq.append(n)
        res = [dq[0]]
        l = 0
        for r in range(k, len(nums)):
            if nums[l] == dq[0]:
                dq.popleft()
            l += 1
            n = nums[r]
            while dq and n > dq[-1]:
                dq.pop()
            dq.append(n)
            res.append(dq[0])
        return res
