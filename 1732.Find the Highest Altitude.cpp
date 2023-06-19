#include <vector>
#include <algorithm>

class Solution {
public:
    int largestAltitude(std::vector<int>& gain) {
        int highestAltitude = 0;
        int currentAltitude = 0;
        
        for (int i = 0; i < gain.size(); i++) {
            currentAltitude += gain[i];
            highestAltitude = std::max(highestAltitude, currentAltitude);
        }
        
        return highestAltitude;
    }
};
