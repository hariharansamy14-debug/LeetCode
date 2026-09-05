func firstStableIndex(nums []int, k int) int {
    n:=len(nums)
    currentmin :=nums[n-1]
    suffixmin := make([]int,n)
     for i:=n-1;i>=0;i--{
        if nums[i]<currentmin{
            currentmin = nums[i]
        }    
        suffixmin[i] = currentmin
     }
     currentmax :=nums[0]
     for i:=0;i<n;i++{
        if nums[i]>currentmax{
            currentmax = nums[i]
        }
        if currentmax - suffixmin[i]<=k{
            return i
        }
     }
     return -1
}