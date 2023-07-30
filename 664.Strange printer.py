class Solution:
    def strangePrinter(self, s: str) -> int:
        # Get the length of the input string
        n = len(s)
        
        # Create a n x n matrix to store the minimum number of turns needed to print s[i:j+1]
        dp = [[0] * n for _ in range(n)]
        
        # Loop backwards over the matrix to fill in the upper diagonal
        for i in range(n-1, -1, -1):
            # Initialize the diagonal values to 1, since it takes one turn to print a single character
            dp[i][i] = 1
            
            # Loop forwards over the matrix to fill in the lower diagonal
            for j in range(i+1, n):
                # If s[i] and s[j] are the same character, we can print them together in one turn
                if s[i] == s[j]:
                    dp[i][j] = dp[i][j-1]
                else:
                    # If s[i] and s[j] are different characters, we try to use the previously computed dp values
                    # and update the current dp value by taking the minimum value of the two possible options
                    dp[i][j] = float('inf')
                    for k in range(i, j):
                        dp[i][j] = min(dp[i][j], dp[i][k] + dp[k+1][j])
        
        # The minimum number of turns needed to print the entire string s is stored in dp[0][n-1]
        return dp[0][n-1]
