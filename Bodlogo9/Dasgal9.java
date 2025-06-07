package Bodlogo9;

import java.util.*;

public class Dasgal9 {

    public static List<String> bomberMan(int n, List<String> grid) {
        if (n == 1)
            return grid;

        // All cells filled with bombs
        if (n % 2 == 0) {
            return Collections.nCopies(grid.size(),
                    "O".repeat(grid.get(0).length()));
        }

        // After first explosion (n=3,7,11,...)
        List<String> firstExplosion = explode(grid);
        // After second explosion (n=5,9,13,...)
        List<String> secondExplosion = explode(firstExplosion);

        return (n % 4 == 3) ? firstExplosion : secondExplosion;
    }

    private static List<String> explode(List<String> grid) {
        int r = grid.size();
        int c = grid.get(0).length();
        char[][] result = new char[r][c];

        // Initialize with all bombs
        for (int i = 0; i < r; i++) {
            Arrays.fill(result[i], 'O');
        }

        // Detonate bombs
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid.get(i).charAt(j) == 'O') {
                    result[i][j] = '.';
                    // Up
                    if (i > 0)
                        result[i - 1][j] = '.';
                    // Down
                    if (i < r - 1)
                        result[i + 1][j] = '.';
                    // Left
                    if (j > 0)
                        result[i][j - 1] = '.';
                    // Right
                    if (j < c - 1)
                        result[i][j + 1] = '.';
                }
            }
        }

        // Convert to List<String>
        List<String> output = new ArrayList<>();
        for (char[] row : result) {
            output.add(new String(row));
        }
        return output;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        int n = scanner.nextInt();
        scanner.nextLine(); // consume newline

        List<String> grid = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            grid.add(scanner.nextLine());
        }

        List<String> result = bomberMan(n, grid);
        for (String row : result) {
            System.out.println(row);
        }
    }
}
