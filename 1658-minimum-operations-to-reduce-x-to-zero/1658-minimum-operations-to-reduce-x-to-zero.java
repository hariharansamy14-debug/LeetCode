class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int tot =0 ;
        for(int num : nums){
            tot+=num;
        }

        int tar = tot -x;
        if (tar <0) return -1;
        if(tar == 0) return n;

        int left = 0;
        int sum =0;
        int max_sum = -1;
        for(int right =0 ;right <n;right++){
            sum += nums[right];
            while(left <= right && sum > tar){
                sum -= nums[left];
                left++;
            }
            if(sum == tar){
                max_sum = Math.max(max_sum,right-left+1);
            }
        }
        return max_sum ==-1?-1:n-max_sum;
    }
}