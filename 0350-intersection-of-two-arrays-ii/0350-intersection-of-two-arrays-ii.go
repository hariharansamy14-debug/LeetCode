func Counter(items[]int) map[int]int{
    counts := make(map[int]int)
    for _,item := range items{
        counts[item]++
    }
    return counts
}


func intersect(nums1 []int, nums2 []int) []int {
  counts := Counter(nums1)

  var result []int
  for _,num := range nums2{
    if count,exists := counts[num];exists && count >0{
        result = append(result,num)
        counts[num]--
    }
  }
  return result
}