class Solution {
    private int[] treeProd, treeCount;
    private int k, curRem, targetX, totalWays;

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        int n = nums.length;
        this.k = k;
        this.treeProd = new int[4 * n];
        this.treeCount = new int[4 * n * k];

        build(1, 0, n - 1, nums);

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            update(1, 0, n - 1, queries[i][0], queries[i][1]);
            
            curRem = 1;
            targetX = queries[i][3];
            totalWays = 0;
            
            query(1, 0, n - 1, queries[i][2]);
            ans[i] = totalWays;
        }
        return ans;
    }

    private void merge(int node) {
        int L = node << 1, R = L | 1, lProd = treeProd[L];
        treeProd[node] = (lProd * treeProd[R]) % k;

        int pOff = node * k, lOff = L * k, rOff = R * k;
       
        System.arraycopy(treeCount, lOff, treeCount, pOff, k);

        for (int r = 0; r < k; r++) {
            int cnt = treeCount[rOff + r];
            if (cnt > 0) treeCount[pOff + (lProd * r) % k] += cnt;
        }
    }

    private void build(int node, int l, int r, int[] nums) {
        if (l == r) {
            treeProd[node] = nums[l] % k;
            treeCount[node * k + treeProd[node]] = 1;
            return;
        }
        int mid = (l + r) >> 1;
        build(node << 1, l, mid, nums);
        build(node << 1 | 1, mid + 1, r, nums);
        merge(node);
    }

    private void update(int node, int l, int r, int idx, int val) {
        if (l == r) {
            int off = node * k;
            for (int i = 0; i < k; i++) treeCount[off + i] = 0;
            treeProd[node] = val % k;
            treeCount[off + treeProd[node]] = 1;
            return;
        }
        int mid = (l + r) >> 1;
        if (idx <= mid) update(node << 1, l, mid, idx, val);
        else update(node << 1 | 1, mid + 1, r, idx, val);
        merge(node);
    }

   
    private void query(int node, int l, int r, int ql) {
        if (l >= ql) {
            int off = node * k;
            for (int rVal = 0; rVal < k; rVal++) {
                if ((curRem * rVal) % k == targetX) {
                    totalWays += treeCount[off + rVal];
                }
            }
            curRem = (curRem * treeProd[node]) % k;
            return;
        }
        int mid = (l + r) >> 1;
        if (ql <= mid) query(node << 1, l, mid, ql);
        query(node << 1 | 1, mid + 1, r, ql);
    }
}