class Solution {
public:
    uint32_t reverseBits(uint32_t n) {
        uint32_t reversed = 0;
        for (int i = 0; i < 32; i++) {
            reversed <<= 1;  // Left shift by 1 to make room for the next bit
            reversed |= n & 1;  // Set the least significant bit of reversed to the current bit of n
            n >>= 1;  // Right shift n by 1 to get the next bit
        }
        return reversed;
    }
};
