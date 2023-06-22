#include <unordered_map>
#include <string>

class Solution {
public:
    int romanToInt(std::string s) {
        std::unordered_map<char, int> romanValues = {
            {'I', 1},
            {'V', 5},
            {'X', 10},
            {'L', 50},
            {'C', 100},
            {'D', 500},
            {'M', 1000}
        };

        int result = 0;
        int prevValue = 0;

        for (char c : s) {
            int currValue = romanValues[c];
            result += currValue;

            if (currValue > prevValue) {
                result -= 2 * prevValue;
            }

            prevValue = currValue;
        }

        return result;
    }
};
