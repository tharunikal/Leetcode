#include <vector>

class Solution {
public:
    std::vector<int> findDisappearedNumbers(std::vector<int>& nums) {
        int n = nums.size();

        // Step 1: Mark the elements as negative
        for (int i = 0; i < n; ++i) {
            int idx = abs(nums[i]) - 1;
            nums[idx] = -abs(nums[idx]);
        }

        // Step 2: Find the positive elements
        std::vector<int> result;
        for (int i = 0; i < n; ++i) {
            if (nums[i] > 0) {
                result.push_back(i + 1);
            }
        }

        return result;
    }
};
