package ch02_sort;

import common.Const;
import edu.princeton.cs.algs4.In;

import java.io.File;

public class HeapSort {

    private static void sink(Comparable[] arr, int k, int N) {
        while (2 * k < N) {
            int j = 2 * k;
            if (SortUtils.less(arr[j], arr[j+1])) {
                j += 1;
            }
            SortUtils.exch(arr, k, j);
            k = j;
        }
    }
    public static void sort(Comparable[] arr) {
        Comparable[] newArr = new Comparable[arr.length + 1];
        System.arraycopy(arr, 0, newArr, 1, arr.length);
        int N = arr.length;
        for (int k = N/2; k >= 1; k--) {
            sink(newArr, k, N);
        }

        while (N > 1) {
            SortUtils.exch(newArr, N, 1);
            N--;
            sink(newArr, 1, N);
        }
        System.arraycopy(newArr, 1, arr, 0, arr.length);
    }

    public static void main(String[] args) {
        File file = new File(Const.DATA_PATH + "tiny.txt");
        In in = new In(file);
        String[] arr = in.readAllStrings();
        HeapSort.sort(arr);
        assert SortUtils.isSorted(arr);
        SortUtils.show(arr);
    }

}
