class Solution:
    def combinationSum4(self, nums: List[int], target: int) -> int:
        # Initialize an array dp where dp[i] represents the number of combinations to make sum 'i'.
        dp = [0] * (target + 1)
        
        # There is one way to make sum 0, which is by not selecting any number.
        dp[0] = 1
        
        # Iterate through the possible target sums from 1 to target.
        for currentSum in range(1, target + 1):
            # Iterate through the given numbers in nums.
            for numIndex in range(0, len(nums)):
                currentNum = nums[numIndex]
                # Check if subtracting currentNum from currentSum results in a non-negative value.
                if currentSum - currentNum >= 0:
                    # dp[i] can be achieved by adding the combination count at dp[i - currentNum].
                    dp[currentSum] += dp[currentSum - currentNum]
            
        # The final result is stored in dp[target].
        return dp[target]
