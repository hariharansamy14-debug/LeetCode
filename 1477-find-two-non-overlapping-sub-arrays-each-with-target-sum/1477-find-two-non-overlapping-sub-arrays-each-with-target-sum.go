func minSumOfLengths(arr []int, target int) int {
    n := len(arr)
    dp := make([]int, n)
    
    
    const INF = 1000000000 
    for i := range dp {
        dp[i] = INF
    }

    ans := INF
    left := 0
    currSum := 0
    minLen := INF

    for right := 0; right < n; right++ {
        currSum += arr[right]

       
        for currSum > target && left <= right {
            currSum -= arr[left]
            left++
        }

       
        if currSum == target {
            curLen := right - left + 1
            
           
            if left > 0 && dp[left-1] != INF {
                if dp[left-1]+curLen < ans {
                    ans = dp[left-1] + curLen
                }
            }

            if curLen < minLen {
                minLen = curLen
            }
        }

        dp[right] = minLen
    }

    if ans >= INF {
        return -1
    }
    return ans
}