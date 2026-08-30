func thirdMax(nums []int) int {
   seen:= make(map[int]bool)
   for _,num := range nums{
    seen[num]= true;
   }
   unique := make([]int,0,len(seen))
   for num:=range seen{
    unique = append(unique,num)
   }
   sort.Ints(unique)
   if len(unique) >=3{
    return unique[len(unique)-3];
   }
   return unique[len(unique)-1];

}