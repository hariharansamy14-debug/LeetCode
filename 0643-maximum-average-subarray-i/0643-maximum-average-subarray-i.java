class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int r =k-1;
        int l =0;
        int sum =0;
       int max =0;
     

       for(int i =0;i<k;i++){
        sum+=nums[i];
       }
        max = sum;
      while(r<n-1){
               sum = sum-nums[l];
               l++;
               r++;
               sum = sum+nums[r];
               
               
          max = Math.max(max,sum);
        }
        return (double)max/k;
    }
}