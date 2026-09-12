func maximumWeight(intervals [][]int) []int {
    n := len(intervals)
	a := make([]struct{ l, r, w, id int }, n)
	for i, v := range intervals {
		a[i] = struct{ l, r, w, id int }{v[0], v[1], v[2], i}
	}

	sort.Slice(a, func(i, j int) bool {
		if a[i].l != a[j].l {
			return a[i].l < a[j].l
		}
		if a[i].r != a[j].r {
			return a[i].r < a[j].r
		}
		return a[i].id < a[j].id
	})

	type state struct {
		w   int64
		idx [4]int
		len int
	}

	isBetter := func(s1, s2 state) bool {
		if s1.w != s2.w {
			return s1.w > s2.w
		}
		for i := 0; i < s1.len && i < s2.len; i++ {
			if s1.idx[i] != s2.idx[i] {
				return s1.idx[i] < s2.idx[i]
			}
		}
		return s1.len < s2.len
	}

	dp := make([][5]state, n+1)

	for i := n - 1; i >= 0; i-- {
		next := sort.Search(n, func(j int) bool {
			return a[j].l > a[i].r
		})

		for k := 1; k <= 4; k++ {
			best := dp[i+1][k]

			prev := dp[next][k-1]
			var cur [4]int
			copy(cur[:], prev.idx[:prev.len])
			cur[prev.len] = a[i].id
			l := prev.len + 1
			sort.Ints(cur[:l])

			take := state{w: prev.w + int64(a[i].w), idx: cur, len: l}
			if isBetter(take, best) {
				best = take
			}
			dp[i][k] = best
		}
	}

	best := state{}
	for k := 1; k <= 4; k++ {
		if isBetter(dp[0][k], best) {
			best = dp[0][k]
		}
	}

	return best.idx[:best.len]
}