class Solution {
public:
    int findComplement(int num) {
        if (num == 0)
            return 1;
        
        unsigned int mask = ~0;  // Create a mask with all bits set to 1
        
        while (num & mask)
            mask <<= 1;  // Shift the mask left until it has the same number of bits as num
        
        return ~num & ~mask;  // Perform bitwise complement on both num and mask, and bitwise AND them
    }
};
