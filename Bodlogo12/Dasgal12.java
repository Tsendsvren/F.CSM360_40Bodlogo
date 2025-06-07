package Bodlogo12;

import java.util.*;

public class Dasgal12 {

    public static long countShifts(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    private static long mergeSort(int[] arr, int left, int right) {
        long shifts = 0;
        if (left < right) {
            int mid = (left + right) / 2;
            shifts += mergeSort(arr, left, mid);
            shifts += mergeSort(arr, mid + 1, right);
            shifts += merge(arr, left, mid, right);
        }
        return shifts;
    }

    private static long merge(int[] arr, int left, int mid, int right) {
        int[] leftArr = Arrays.copyOfRange(arr, left, mid + 1);
        int[] rightArr = Arrays.copyOfRange(arr, mid + 1, right + 1);

        int i = 0, j = 0, k = left;
        long shifts = 0;

        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
                shifts += (leftArr.length - i);
            }
        }

        while (i < leftArr.length) {
            arr[k++] = leftArr[i++];
        }

        while (j < rightArr.length) {
            arr[k++] = rightArr[j++];
        }

        return shifts;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int queries = scanner.nextInt();
        while (queries-- > 0) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            System.out.println(countShifts(arr));
        }
        scanner.close();
    }
}
