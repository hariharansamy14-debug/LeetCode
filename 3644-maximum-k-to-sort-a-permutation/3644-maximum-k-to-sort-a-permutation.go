func sortPermutation(nums []int) int {
    
        k := -1

        for i:=0;i<len(nums);i++{
            if i != nums[i]{
                k&=nums[i]
            }
        }

        if k == -1{
            return 0
        }else{
            return k
        }

}