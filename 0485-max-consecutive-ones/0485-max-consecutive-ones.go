func findMaxConsecutiveOnes(nums []int) int {
    count:=0
  maxcount:=0
  
  for _,num := range nums{
    if num==1{
      count = count + 1
      maxcount = max(maxcount,count)
    }else{
      count = 0
    }
  }
  return maxcount 
}