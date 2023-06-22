#include <vector>

class Solution {
public:
    std::vector<int> countBits(int n) {
        std::vector<int> ans(n + 1, 0); // Initialize the result vector with zeros
        
        for (int i = 1; i <= n; i++) {
            // Count the number of 1's in the binary representation of i
            ans[i] = ans[i >> 1] + (i & 1);
        }
        
        return ans;
    }
};
