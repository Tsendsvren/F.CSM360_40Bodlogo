package Bodlogo38;

import java.util.*;

public class Dasgal38 {
    public static int bestStartingStudent(int[] t) {
        int n = t.length;
        int[] diff = new int[n + 1];

        for (int i = 0; i < n; i++) {
            int need = t[i];
            if (need == 0) {
                diff[0]++;
                diff[n]--;
            } else if (need <= n) {
                int start = (i + 1) % n;
                int end = (i - need + n + 1) % n;
                diff[start]++;
                diff[end]--;
                if (start > end) {
                    diff[0]++;
                }
            }
        }

        int best = 0, sum = 0, max = -1;
        for (int s = 0; s < n; s++) {
            sum += diff[s];
            if (sum > max) {
                max = sum;
                best = s;
            }
        }

        return best + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] t = new int[n];
        for (int i = 0; i < n; i++)
            t[i] = sc.nextInt();
        System.out.println(bestStartingStudent(t));
        sc.close();
    }
}
