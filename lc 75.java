class Solution {
    public void sortColors(int[] nums) {
        int mid = 0;
        int low =0;
        int high = nums.length-1;
        while(!(mid>high)){
            if(nums[mid]==0){
                swap(nums,mid,low);
                mid++;
                low++;
            }
            else if(nums[mid]==1){
                mid++;
            }

            else{
                swap(nums,mid,high);
                high--;
            }
        }

    }
    void swap (int [] nums,int a , int b){
        int temp = nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
}
