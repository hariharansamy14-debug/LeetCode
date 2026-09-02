func findContentChildren(g []int, s []int) int {
    greed := len(g)
    cookie := len(s)
    r :=0
    l :=0
    sort.Ints(g)
    sort.Ints(s)
    for l < cookie && r < greed {
        if g[r] <= s[l]{
            r = r + 1
        }
        l = l+1
    }
    return r
}