package Bodlogo7;

import java.util.*;

public class Dasgal7 {
    public static String encryption(String s) {
        s = s.replaceAll(" ", "");
        int L = s.length();
        int row = (int) Math.floor(Math.sqrt(L));
        int col = (int) Math.ceil(Math.sqrt(L));

        // Adjust rows if needed
        if (row * col < L) {
            row = col;
        }

        StringBuilder result = new StringBuilder();
        for (int j = 0; j < col; j++) {
            for (int i = 0; i < row; i++) {
                int index = i * col + j;
                if (index < L) {
                    result.append(s.charAt(index));
                }
            }
            if (j < col - 1) {
                result.append(" ");
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(encryption(s));
    }
}