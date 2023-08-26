class Solution:
    def findLongestChain(self, pairs: List[List[int]]) -> int:
        sortedPairs = sorted(pairs, key=lambda x: x[1])# Sort by the 2nd element

        count=1
        lastPair=0
        for curPair in range(1,len(sortedPairs)):
            a,b=sortedPairs[lastPair]
            c,d=sortedPairs[curPair]
            if b<c:
                count+=1
                lastPair=curPair
        return count
