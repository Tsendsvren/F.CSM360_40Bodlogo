package Bodlogo33;

import java.util.*;

public class Dasgal33 {
    static int[] parent;
    static int[] size;

    // Find with path compression
    static int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    // Union by size
    static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootY] = rootX;
            size[rootX] += size[rootY];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int totalNodes = 2 * n;

        parent = new int[totalNodes + 1];
        size = new int[totalNodes + 1];

        for (int i = 1; i <= totalNodes; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            union(u, v);
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= totalNodes; i++) {
            if (parent[i] == i && size[i] > 1) {
                min = Math.min(min, size[i]);
                max = Math.max(max, size[i]);
            }
        }

        System.out.println(min + " " + max);
    }
}
