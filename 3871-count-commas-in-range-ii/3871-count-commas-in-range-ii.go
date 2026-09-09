func countCommas(n int64) int64 {
   var power int64 =1_000
   var result int64 =0
   for power <=n{
    result += n-(power -1)
    if power > 9_223_372_036_854_775_807 / 1_000 {
            break
        }
        power *= 1_000
   }
   return result 
}