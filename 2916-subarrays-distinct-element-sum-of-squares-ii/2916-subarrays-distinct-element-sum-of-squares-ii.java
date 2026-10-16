class Solution {
    class SegmentTree {
        int n;
        long[] sum;
        long[] sumSq;
        long[] lazy;
        int mod = 1000000007;

        public SegmentTree(int n) {
            this.n = n;
            sum = new long[4 * n];
            sumSq = new long[4 * n];
            lazy = new long[4 * n];
        }

        private void push(int node, int l, int r) {
            if (lazy[node] != 0) {
                long v = lazy[node];
                int mid = (l + r) / 2;
                apply(2 * node, l, mid, v);
                apply(2 * node + 1, mid + 1, r, v);
                lazy[node] = 0;
            }
        }

        private void apply(int node, int l, int r, long v) {
            long len = (r - l + 1);
            sumSq[node] = (sumSq[node] + 2 * v * sum[node] % mod + v * v % mod * len) % mod;
            sumSq[node] = (sumSq[node] + mod) % mod;
            sum[node] = (sum[node] + v * len) % mod;
            sum[node] = (sum[node] + mod) % mod;
            lazy[node] = (lazy[node] + v) % mod;
        }

        public void update(int node, int l, int r, int ql, int qr, long v) {
            if (ql > r || qr < l) return;
            if (ql <= l && r <= qr) {
                apply(node, l, r, v);
                return;
            }
            push(node, l, r);
            int mid = (l + r) / 2;
            update(2 * node, l, mid, ql, qr, v);
            update(2 * node + 1, mid + 1, r, ql, qr, v);
            sum[node] = (sum[2 * node] + sum[2 * node + 1]) % mod;
            sumSq[node] = (sumSq[2 * node] + sumSq[2 * node + 1]) % mod;
        }

        public long query() {
            return sumSq[1];
        }
    }

    public int sumCounts(int[] nums) {
        int n = nums.length;
        SegmentTree tree = new SegmentTree(n);
        java.util.Map<Integer, Integer> last = new java.util.HashMap<>();
        long totalSum = 0;
        int mod = 1000000007;

        for (int j = 0; j < n; j++) {
            int i = last.getOrDefault(nums[j], -1);
            tree.update(1, 0, n - 1, i + 1, j, 1);
            last.put(nums[j], j);
            totalSum = (totalSum + tree.query()) % mod;
        }
        return (int) totalSum;
    }
}