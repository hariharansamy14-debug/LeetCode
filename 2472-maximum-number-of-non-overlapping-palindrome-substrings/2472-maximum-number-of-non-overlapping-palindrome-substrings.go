func maxPalindromes(s string, k int) int {
    n := len(s)
    if n == 0 {
        return 0
    }

   
    isPalindrome := make([][]bool, n)
    for i := range isPalindrome {
        isPalindrome[i] = make([]bool, n)
    }

    for length := 1; length <= n; length++ {
        for left := 0; left <= n-length; left++ {
            right := left + length - 1
            if s[left] == s[right] && (length <= 2 || isPalindrome[left+1][right-1]) {
                isPalindrome[left][right] = true
            }
        }
    }

    
    dp := make([]int, n)
    for i := 0; i < n; i++ {
        if i > 0 {
            dp[i] = dp[i-1]
        }
        for j := 0; j <= i-k+1; j++ {
            if isPalindrome[j][i] {
                prev := 0
                if j > 0 {
                    prev = dp[j-1]
                }
                if prev+1 > dp[i] {
                    dp[i] = prev + 1
                }
            }
        }
    }

    return dp[n-1]
    }

   
