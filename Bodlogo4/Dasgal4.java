package Bodlogo4;

import java.util.*;

public class Dasgal4 {

    public static List<Integer> absolutePermutation(int n, int k) {
        List<Integer> result = new ArrayList<>();
        if (k == 0) {
            for (int i = 1; i <= n; i++) {
                result.add(i);
            }
            return result;
        }
        if (n % (2 * k) != 0) {
            result.add(-1);
            return result;
        }
        boolean addK = true;
        for (int i = 1; i <= n; i++) {
            if (addK) {
                result.add(i + k);
            } else {
                result.add(i - k);
            }
            if (i % k == 0) {
                addK = !addK;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            List<Integer> res = absolutePermutation(n, k);
            if (res.get(0) == -1) {
                System.out.println(-1);
            } else {
                for (int num : res) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
        }
        scanner.close();
    }
}