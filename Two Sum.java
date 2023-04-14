class Solution {
    public int[] twoSum(int[] nums, int target) {
        int arr[]=new int[2];
        int ind=0;
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    arr[ind]=i;
                    arr[ind+1]=j;
                }
            }
        }
        return arr;
    }
}
