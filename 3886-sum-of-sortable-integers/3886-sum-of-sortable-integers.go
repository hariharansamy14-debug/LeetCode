func sortableIntegers(nums []int) int {
	n := len(nums)
	ans := 0
	for k := 1; k <= n; k++ {
		if n%k != 0 {
			continue
		}
		valid := true
		maxPrev := -1 << 31
		for i := 0; i < n; i += k {
			sub := nums[i : i+k]
			descents := 0
			minVal := sub[0]
			maxVal := sub[0]
			for j := 0; j < k; j++ {
				if sub[j] < minVal {
					minVal = sub[j]
				}
				if sub[j] > maxVal {
					maxVal = sub[j]
				}
				if sub[j] > sub[(j+1)%k] {
					descents++
				}
			}
			if descents > 1 {
				valid = false
				break
			}
			if i > 0 && minVal < maxPrev {
				valid = false
				break
			}
			maxPrev = maxVal
		}
		if valid {
			ans += k
		}
	}
	return ans
}