func maxNumOfSubstrings(s string) []string {
	n := len(s)
	first := make([]int, 26)
	last := make([]int, 26)
	for i := range first {
		first[i] = -1
		last[i] = -1
	}

	for i := 0; i < n; i++ {
		idx := int(s[i] - 'a')
		if first[idx] == -1 {
			first[idx] = i
		}
		last[idx] = i
	}

	type interval struct {
		start, end int
	}
	var intervals []interval

	for i := 0; i < 26; i++ {
		if first[i] == -1 {
			continue
		}

		l := first[i]
		r := last[i]
		valid := true

		for k := l; k <= r; k++ {
			cIdx := int(s[k] - 'a')
			if first[cIdx] < l {
				valid = false
				break
			}
			if last[cIdx] > r {
				r = last[cIdx]
			}
		}

		if valid {
			intervals = append(intervals, interval{l, r})
		}
	}

	sort.Slice(intervals, func(i, j int) bool {
		return intervals[i].end < intervals[j].end
	})

	var result []string
	prevEnd := -1

	for _, iv := range intervals {
		if iv.start > prevEnd {
			result = append(result, s[iv.start:iv.end+1])
			prevEnd = iv.end
		}
	}

	return result
}