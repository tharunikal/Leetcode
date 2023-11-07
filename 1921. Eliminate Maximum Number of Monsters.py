from math import ceil

class Solution:
    def eliminateMaximum(self, dist: List[int], speed: List[int]) -> int:
        n = len(dist)
        for i in range(n):
            dist[i] = ceil(dist[i] / speed[i])
            speed[i] = 0
        
        for num in dist:
            if num >= n:
                continue
            speed[num] += 1
        
        for i in range(1, len(speed)):
            speed[i] += speed[i - 1]
            if speed[i] > i:
                return i
        
        return n
