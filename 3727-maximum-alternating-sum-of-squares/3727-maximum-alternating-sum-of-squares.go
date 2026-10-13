func maxAlternatingSum(nums []int) int64 {
      n := len(nums)
     arr := make([]int64 , n)

      for i:=0;i<n;i++{
        val := int64(nums[i])
        arr[i] = val*val
      }
     
     
         var score int64 = 0
      slices.Sort(arr)
        half := n/2
      for i:=0;i<n;i++{
            if i<half{
                    score -= arr[i]
            }else{
                score += arr[i]
            }
      }
      return score;
}