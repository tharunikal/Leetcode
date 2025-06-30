class Solution {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int n = pattern.length+1;
        int count=0;
        for(int i =0;i<=nums.length-n;i++){
            boolean match = true;
            for(int j =0;j<n-1;j++){
                if(pattern[j] !=Integer.compare(nums[i+j+1],nums[i+j])) {
                    match=false;
                    break;
                }
            }
            if(match){
                count++;
            }
        }
        return count;
    }
}
