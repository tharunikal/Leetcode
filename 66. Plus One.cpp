#include <vector>

class Solution {
public:
    std::vector<int> plusOne(std::vector<int>& digits) {
        int n = digits.size();
        
        // Iterate from the rightmost digit
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;  // Set to 0 and carry over
            } else {
                digits[i] += 1;
                return digits;  // No carry, return the updated array
            }
        }
        
        // If there is still a carry left after processing all digits
        digits.insert(digits.begin(), 1);
        return digits;
    }
};
