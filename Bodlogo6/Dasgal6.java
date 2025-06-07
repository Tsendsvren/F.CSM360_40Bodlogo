package Bodlogo6;

import java.util.*;

public class Dasgal6 {
    public static int nonDivisibleSubset(int k, List<Integer> s) {
        int[] remainderCounts = new int[k];
        for (int num : s) {
            remainderCounts[num % k]++;
        }

        int result = 0;
        if (remainderCounts[0] > 0) {
            result++; // зөвхөн нэг 0 үлдэгдэлтэй тоо
        }

        for (int r = 1; r <= k / 2; r++) {
            if (r != k - r) {
                result += Math.max(remainderCounts[r], remainderCounts[k - r]);
            } else {
                result++; // зөвхөн нэг r = k/2 тоо (k тэгш үед)
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        List<Integer> s = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            s.add(scanner.nextInt());
        }
        System.out.println(nonDivisibleSubset(k, s));
    }
}