func findDisappearedNumbers(nums []int) []int {
    exists := make(map[int]bool)

    for _,num := range nums{
        exists[num]=true
    }
    var missing []int
    for i:=1;i<=len(nums);i++{
        if !exists[i]{
            missing = append(missing , i)
        }
    }
    return missing 
}