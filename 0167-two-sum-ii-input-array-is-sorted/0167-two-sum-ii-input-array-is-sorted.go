func twoSum(numbers []int, target int) []int {
      
    start := 0
    end := len(numbers)-1
     
        for start < end{
                sum := numbers[start] + numbers[end]
                  if sum == target{
                    return []int{start + 1 ,end + 1}
                  } else if sum < target{
                         start = start + 1
                  }else{
                    end = end - 1
                  }
                  
        }

        return []int{-1,-1}

}