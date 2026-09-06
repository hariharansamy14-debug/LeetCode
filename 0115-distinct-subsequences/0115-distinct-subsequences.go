func numDistinct(s string, t string) int {
    n:=len(s)
    m:=len(t)
    memo := make([][]int,n)
    for i := range memo{
        memo[i]= make([]int,m)
        for j := range memo[i]{
            memo[i][j]=-1
        }
    }
    var f func (i,j int)int
     f=func(i int , j int  ) int{
    if j<0 {
        return 1
    }
    if i<0 {
        return 0
    }
    if memo[i][j]!= -1{
        return memo[i][j]
    }
    if s[i]==t[j]{
        memo[i][j]= f(i-1,j-1)+f(i-1,j)
    }else{
    memo[i][j]= f(i-1,j)
    }
    return memo[i][j]
}
    return f(n-1,m-1);
}
