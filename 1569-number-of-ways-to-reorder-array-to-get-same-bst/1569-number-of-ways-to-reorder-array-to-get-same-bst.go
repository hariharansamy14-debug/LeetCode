func numOfWays(nums []int) int {
    
        const mod = 1_000_000_007
             n := len(nums)
        combo := make([][]int ,n+1)
        for i := range combo{
            combo[i] = make([]int , i+1 )
            combo[i][0] = 1
            combo[i][i] = 1
                for j:=1;j<i;j++{
                    combo[i][j] = (combo[i-1][j-1] + combo[i-1][j]) % mod
                }
        }

        var dfs func(arr []int) int 
        dfs = func(arr []int)int {
            if len(arr)<=2{
                return 1
                }

                root := arr[0] 
                var left , right []int 

                for i:=1;i<len(arr);i++{
                    if arr[i]<root{
                        left = append(left , arr[i])
                    } else{
                        
                        right = append(right , arr[i])
                    
                    }

                }
                    m := len(left)
                    k := len(right)

                    ways := combo[m+k][m]

                        leftways := dfs(left)
                        rightways := dfs(right)

                            res := ( ways * leftways ) % mod
                            res =  ( res * rightways ) % mod

                            return res
            
             }

            total := dfs(nums)
            return (total -1 + mod)%mod

}