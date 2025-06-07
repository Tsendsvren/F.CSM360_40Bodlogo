package Bodlogo8;

import java.util.*;

public class Dasgal8 {

    public static String gridSearch(List<String> G, List<String> P) {
        int R = G.size();
        int C = G.get(0).length();
        int r = P.size();
        int c = P.get(0).length();

        for (int i = 0; i <= R - r; i++) {
            for (int j = 0; j <= C - c; j++) {
                boolean match = true;
                for (int k = 0; k < r; k++) {
                    if (!G.get(i + k).substring(j, j + c).equals(P.get(k))) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return "YES";
                }
            }
        }
        return "NO";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();

        for (int test = 0; test < t; test++) {
            int R = scanner.nextInt();
            scanner.nextLine();

            List<String> G = new ArrayList<>();
            for (int i = 0; i < R; i++) {
                G.add(scanner.nextLine());
            }

            int r = scanner.nextInt();
            scanner.nextLine();

            List<String> P = new ArrayList<>();
            for (int i = 0; i < r; i++) {
                P.add(scanner.nextLine());
            }

            System.out.println(gridSearch(G, P));
        }
        scanner.close();
    }
}