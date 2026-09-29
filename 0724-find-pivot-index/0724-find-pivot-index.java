class Solution {
  
         int rightsum(int[]prefix,int pivot){
               return prefix[prefix.length-1]-prefix[pivot]; 
         }
          int leftsum(int[]prefix,int pivot){
            if(pivot == 0){
                return 0;
            }
           return prefix[pivot-1];
         }

    public int pivotIndex(int[] nums) {
        // int pivot = nums.length/2;
         int[]prefix = new int[nums.length];
        prefix[0]=nums[0];
        for(int i =1;i<nums.length;i++){
              prefix[i]= prefix[i-1] + nums[i];
        }
        for(int pivot =0;pivot<nums.length;pivot++ ){
          int right = rightsum(prefix,pivot);
          int left = leftsum(prefix,pivot);

          if(right == left){
            return pivot;
          }
        }
       return -1;

           
    }
}