func distinctSubseqII(s string) int {
    const MOD = 1_000_000_007
   var dp [26]int

    for i:=0;i<len(s);i++ {
        charIn:= s[i]-'a'

        totalFar :=0;
        for _,count := range dp {
            totalFar = (totalFar+count)%MOD
        }

        dp[charIn]=(1+totalFar)%MOD

    }
    total:=0
    for _,count := range dp {
        total = (total+count)%MOD
    }
    return total

}