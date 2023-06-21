class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        int k = 0; // variable to keep track of the count of elements not equal to val
        
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] != val) {
                nums[k] = nums[i]; // move the element to the front of the array
                k++; // increment k
            }
        }
        
        return k;
    }
};
