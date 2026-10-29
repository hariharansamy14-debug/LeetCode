import java.io.*;
import java.util.*;

class Solution {
    List<List<Integer>> adj;
    int[] parent, depth, heavy, head, pos, tree, tour;
    int curPos;
    char[] chars;
    int n;

    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        this.n = n;
        chars = s.toCharArray();
        adj = new ArrayList<>(n);
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        parent = new int[n];
        depth = new int[n];
        heavy = new int[n];
        head = new int[n];
        pos = new int[n];
        tour = new int[n];
        Arrays.fill(heavy, -1);

        dfs1(0, -1, 0);
        curPos = 0;
        dfs2(0, 0);

        tree = new int[4 * n];
        build(1, 0, n - 1);

        List<Boolean> ans = new ArrayList<>(queries.length);
        for (String q : queries) {
            if (q.charAt(0) == 'u') {
                int space1 = q.indexOf(' ', 7);
                int u = fastParseInt(q, 7, space1);
                char c = q.charAt(space1 + 1);
                chars[u] = c;
                update(1, 0, n - 1, pos[u], 1 << (c - 'a'));
            } else {
                int space1 = q.indexOf(' ', 6);
                int space2 = q.indexOf(' ', space1 + 1);
                int u = fastParseInt(q, 6, space1);
                int v = fastParseInt(q, space1 + 1, space2 == -1 ? q.length() : space2);
                int mask = queryPath(u, v);
                ans.add(mask == 0 || (mask & (mask - 1)) == 0);
            }
        }
        return ans;
    }

    private int fastParseInt(String s, int start, int end) {
        int res = 0;
        for (int i = start; i < end; i++) {
            res = res * 10 + (s.charAt(i) - '0');
        }
        return res;
    }

    private int dfs1(int u, int p, int d) {
        parent[u] = p;
        depth[u] = d;
        int size = 1, maxSub = 0;
        for (int v : adj.get(u)) {
            if (v != p) {
                int sub = dfs1(v, u, d + 1);
                size += sub;
                if (sub > maxSub) {
                    maxSub = sub;
                    heavy[u] = v;
                }
            }
        }
        return size;
    }

    private void dfs2(int u, int h) {
        head[u] = h;
        pos[u] = curPos;
        tour[curPos++] = u;
        if (heavy[u] != -1) {
            dfs2(heavy[u], h);
        }
        for (int v : adj.get(u)) {
            if (v != parent[u] && v != heavy[u]) {
                dfs2(v, v);
            }
        }
    }

    private void build(int node, int l, int r) {
        if (l == r) {
            tree[node] = 1 << (chars[tour[l]] - 'a');
            return;
        }
        int mid = (l + r) >> 1;
        int leftChild = node << 1;
        int rightChild = leftChild | 1;
        build(leftChild, l, mid);
        build(rightChild, mid + 1, r);
        tree[node] = tree[leftChild] ^ tree[rightChild];
    }

    private void update(int node, int l, int r, int idx, int val) {
        if (l == r) {
            tree[node] = val;
            return;
        }
        int mid = (l + r) >> 1;
        int leftChild = node << 1;
        int rightChild = leftChild | 1;
        if (idx <= mid) update(leftChild, l, mid, idx, val);
        else update(rightChild, mid + 1, r, idx, val);
        tree[node] = tree[leftChild] ^ tree[rightChild];
    }

    private int query(int node, int l, int r, int ql, int qr) {
        if (qr < l || ql > r) return 0;
        if (ql <= l && r <= qr) return tree[node];
        int mid = (l + r) >> 1;
        int leftChild = node << 1;
        int rightChild = leftChild | 1;
        return query(leftChild, l, mid, ql, qr) ^ query(rightChild, mid + 1, r, ql, qr);
    }

    private int queryPath(int u, int v) {
        int res = 0;
        while (head[u] != head[v]) {
            if (depth[head[u]] < depth[head[v]]) {
                int t = u; u = v; v = t;
            }
            res ^= query(1, 0, n - 1, pos[head[u]], pos[u]);
            u = parent[head[u]];
        }
        if (depth[u] > depth[v]) {
            int t = u; u = v; v = t;
        }
        res ^= query(1, 0, n - 1, pos[u], pos[v]);
        return res;
    }
}
