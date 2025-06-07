package Bodlogo10;

import java.util.*;

public class Dasgal10 {

    public static void almostSorted(List<Integer> arr) {
        List<Integer> sorted = new ArrayList<>(arr);
        Collections.sort(sorted);

        if (arr.equals(sorted)) {
            System.out.println("yes");
            return;
        }

        List<Integer> diffIndices = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            if (!arr.get(i).equals(sorted.get(i))) {
                diffIndices.add(i);
            }
        }

        if (diffIndices.size() == 2) {
            int l = diffIndices.get(0) + 1;
            int r = diffIndices.get(1) + 1;
            System.out.println("yes");
            System.out.println("swap " + l + " " + r);
            return;
        }

        int start = diffIndices.get(0);
        int end = diffIndices.get(diffIndices.size() - 1);
        List<Integer> reversed = new ArrayList<>(arr);
        Collections.reverse(reversed.subList(start, end + 1));

        if (reversed.equals(sorted)) {
            System.out.println("yes");
            System.out.println("reverse " + (start + 1) + " " + (end + 1));
            return;
        }

        System.out.println("no");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(scanner.nextInt());
        }
        almostSorted(arr);
    }
}
