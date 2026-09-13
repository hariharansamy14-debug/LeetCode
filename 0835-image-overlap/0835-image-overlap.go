func largestOverlap(img1 [][]int, img2 [][]int) int {
	var a, b [][2]int
	n, maxOverlap := len(img1), 0

	for r := 0; r < n; r++ {
		for c := 0; c < n; c++ {
			if img1[r][c] == 1 { a = append(a, [2]int{r, c}) }
			if img2[r][c] == 1 { b = append(b, [2]int{r, c}) }
		}
	}

	var count [61][61]int
	for _, p1 := range a {
		for _, p2 := range b {
			dr, dc := p1[0]-p2[0]+30, p1[1]-p2[1]+30
			count[dr][dc]++
			if count[dr][dc] > maxOverlap {
				maxOverlap = count[dr][dc]
			}
		}
	}

	return maxOverlap
}