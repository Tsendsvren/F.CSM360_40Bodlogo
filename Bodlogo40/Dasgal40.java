package Bodlogo40;

import java.util.*;

public class Dasgal40 {
    static final int MOD = 1_000_000_007;

    static class DSU {
        int[] parent, size;

        DSU(int n) {
            parent = new int[n + 1];
            size = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int a, int b) {
            int ra = find(a), rb = find(b);
            if (ra == rb)
                return;
            if (size[ra] < size[rb]) {
                parent[ra] = rb;
                size[rb] += size[ra];
            } else {
                parent[rb] = ra;
                size[ra] += size[rb];
            }
        }
    }

    static long C2(long n) {
        return n < 2 ? 0 : (n * (n - 1) / 2) % MOD;
    }

    static long C3(long n) {
        return n < 3 ? 0 : (n * (n - 1) % MOD * (n - 2) % MOD) * inv6 % MOD;
    }

    static final long inv6 = 166666668;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        DSU dsu = new DSU(n);

        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt(), v = sc.nextInt();
            String col = sc.next();
            if (col.equals("b")) {
                dsu.union(u, v);
            }
        }
        sc.close();

        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            int root = dsu.find(i);
            cnt.put(root, cnt.getOrDefault(root, 0) + 1);
        }

        long total = n >= 3 ? C3(n) : 0;
        long invalid = 0;
        for (long sz : cnt.values()) {
            invalid = (invalid + C3(sz)) % MOD;
            invalid = (invalid + C2(sz) * ((n - sz) % MOD) % MOD) % MOD;
        }

        long ans = (total - invalid + MOD) % MOD;
        System.out.println(ans);
    }
}
