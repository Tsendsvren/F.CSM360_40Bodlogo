package Bodlogo5;

import java.util.*;

public class Dasgal5 {
    static class Plus {
        int x, y, k, area;

        Plus(int x, int y, int k) {
            this.x = x;
            this.y = y;
            this.k = k;
            this.area = 4 * k + 1;
        }
    }

    public static boolean isOverlap(Plus a, Plus b, char[][] grid) {
        Set<String> cellsA = getCells(a);
        Set<String> cellsB = getCells(b);
        for (String cell : cellsA) {
            if (cellsB.contains(cell))
                return true;
        }
        return false;
    }

    public static Set<String> getCells(Plus p) {
        Set<String> cells = new HashSet<>();
        cells.add(p.x + "," + p.y);
        for (int i = 1; i <= p.k; i++) {
            cells.add((p.x + i) + "," + p.y);
            cells.add((p.x - i) + "," + p.y);
            cells.add(p.x + "," + (p.y + i));
            cells.add(p.x + "," + (p.y - i));
        }
        return cells;
    }

    public static List<Plus> findPluses(char[][] grid) {
        List<Plus> pluses = new ArrayList<>();
        int n = grid.length, m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'G') {
                    int maxK = 0;
                    while (true) {
                        int k = maxK + 1;
                        if (i - k >= 0 && i + k < n && j - k >= 0 && j + k < m &&
                                grid[i - k][j] == 'G' && grid[i + k][j] == 'G' &&
                                grid[i][j - k] == 'G' && grid[i][j + k] == 'G') {
                            maxK = k;
                        } else {
                            break;
                        }
                    }
                    for (int k = 0; k <= maxK; k++) {
                        pluses.add(new Plus(i, j, k));
                    }
                }
            }
        }
        return pluses;
    }

    public static int twoPluses(char[][] grid) {
        List<Plus> pluses = findPluses(grid);
        pluses.sort((a, b) -> b.area - a.area);

        int maxProduct = 0;
        for (int i = 0; i < pluses.size(); i++) {
            for (int j = i + 1; j < pluses.size(); j++) {
                if (!isOverlap(pluses.get(i), pluses.get(j), grid)) {
                    maxProduct = Math.max(maxProduct, pluses.get(i).area * pluses.get(j).area);
                    break; // Since we sorted, first non-overlapping gives max product
                }
            }
        }
        return maxProduct;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            grid[i] = scanner.next().toCharArray();
        }
        System.out.println(twoPluses(grid));
    }
}