func targetIndices(nums []int, target int) []int {
    
            slices.Sort(nums)

      var result []int
        for i, val := range nums{

                if  val == target{
               result = append(result , i )
               
            }
        }
       
            return result
}