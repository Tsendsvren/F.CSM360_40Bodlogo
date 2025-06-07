package Bodlogo2;

import java.util.*;

public class Dasgal2 {

    public static String organizingContainers(List<List<Integer>> container) {
        int n = container.size();
        int[] capacity = new int[n];
        int[] balls = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                capacity[i] += container.get(i).get(j);
                balls[j] += container.get(i).get(j);
            }
        }

        Arrays.sort(capacity);
        Arrays.sort(balls);

        return Arrays.equals(capacity, balls) ? "Possible" : "Impossible";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();

        for (int t = 0; t < q; t++) {
            int n = scanner.nextInt();
            List<List<Integer>> container = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                List<Integer> row = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    row.add(scanner.nextInt());
                }
                container.add(row);
            }

            System.out.println(organizingContainers(container));
        }

        scanner.close();
    }
}