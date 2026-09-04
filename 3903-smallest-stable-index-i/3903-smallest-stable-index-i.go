func firstStableIndex(nums []int, k int) int {
    n := len(nums)
    if n ==0{
        return -1
    }
    suffixmin := make([]int,n)
    currentmin := nums[n-1]
    for i:=n-1;i>=0;i--{
        if currentmin>nums[i]{
            currentmin = nums[i]
        }
        suffixmin[i]= currentmin
    }
    currentmax := nums[0]
    for i:=0;i<n ;i++{
        if currentmax < nums[i]{
            currentmax = nums[i]
        }

        if currentmax - suffixmin[i]<= k {
            return i
        } 
    }
    return -1
}