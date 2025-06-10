package Bodlogo35;

import java.util.*;

public class Dasgal35 {

    static int[] minSteps;

    public static int solve(int n) {
        if (minSteps[n] != -1)
            return minSteps[n];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        minSteps[n] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            int step = minSteps[current];

            if (current - 1 >= 0 && minSteps[current - 1] == -1) {
                minSteps[current - 1] = step + 1;
                queue.offer(current - 1);
            }

            for (int i = 2; i * i <= current; i++) {
                if (current % i == 0) {
                    int next = Math.max(i, current / i);
                    if (minSteps[next] == -1) {
                        minSteps[next] = step + 1;
                        queue.offer(next);
                    }
                }
            }

            if (minSteps[0] != -1)
                break;
        }

        return minSteps[0];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();

        while (q-- > 0) {
            int n = scanner.nextInt();
            minSteps = new int[n + 1];
            Arrays.fill(minSteps, -1);
            System.out.println(solve(n));
        }
    }
}
