package Bodlogo36;

import java.util.*;

public class Dasgal36 {

    static int twoStacks(int x, int[] a, int[] b) {
        int sum = 0, i = 0, j = 0, count = 0;

        while (i < a.length && sum + a[i] <= x) {
            sum += a[i];
            i++;
        }

        count = i;

        while (j < b.length && i >= 0) {
            sum += b[j];
            j++;

            while (sum > x && i > 0) {
                i--;
                sum -= a[i];
            }

            if (sum <= x) {
                count = Math.max(count, i + j);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int g = scanner.nextInt();

        for (int t = 0; t < g; t++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int x = scanner.nextInt();

            int[] a = new int[n];
            int[] b = new int[m];

            for (int i = 0; i < n; i++)
                a[i] = scanner.nextInt();
            for (int i = 0; i < m; i++)
                b[i] = scanner.nextInt();

            System.out.println(twoStacks(x, a, b));
        }
    }
}
