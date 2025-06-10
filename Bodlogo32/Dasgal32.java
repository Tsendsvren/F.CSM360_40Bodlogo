package Bodlogo32;

import java.util.*;

class Dasgal32 {
    boolean canBeBSTInorder(int[] values) {
        if (values.length <= 1) {
            return true;
        }

        for (int i = 1; i < values.length; i++) {
            if (values[i] <= values[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        ArrayList<Integer> valuesList = new ArrayList<>();
        while (scanner.hasNextInt()) {
            valuesList.add(scanner.nextInt());
        }

        int[] values = new int[valuesList.size()];
        for (int i = 0; i < valuesList.size(); i++) {
            values[i] = valuesList.get(i);
        }

        Dasgal32 solution = new Dasgal32();
        boolean isBST = solution.canBeBSTInorder(values);
        System.out.println(isBST ? "Yes" : "No");

        scanner.close();
    }
}