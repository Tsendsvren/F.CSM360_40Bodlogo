package Bodlogo39;

import java.util.*;

public class Dasgal39 {
    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        long[] diff = new long[n + 2];

        for (List<Integer> q : queries) {
            int a = q.get(0);
            int b = q.get(1);
            int k = q.get(2);
            diff[a] += k;
            diff[b + 1] -= k;
        }

        long max = 0, current = 0;
        for (int i = 1; i <= n; i++) {
            current += diff[i];
            max = Math.max(max, current);
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<List<Integer>> queries = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            queries.add(Arrays.asList(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }
        sc.close();

        System.out.println(arrayManipulation(n, queries));
    }
}
