package ch02_sort;

import common.Const;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Merge;

import java.io.File;

public class MergeSort {

    private static Comparable[] aux;
    public static void merge(Comparable[] arr, int lo, int mid, int hi) {
        assert lo >= 0 && hi <= arr.length && arr.length == aux.length;

        System.arraycopy(arr, lo, aux, lo, hi - lo);

        int i = lo, j=mid;
        for (int k = lo; k < hi; k++) {
            if (i >= mid) {
                arr[k] = aux[j++];
            } else if (j >= hi) {
                arr[k] = aux[i++];
            } else if (SortUtils.less(arr[i], arr[j])) {
                arr[k] = aux[i++];
            } else {
                arr[k] = aux[j++];
            }
        }
    }

    public static void sort(Comparable[] arr, int lo, int hi) {
        if (hi - 1 <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(arr, lo, mid);
        sort(arr, mid, hi);
        merge(arr, lo, mid, hi);
    }
    public static void sort(Comparable[] arr) {
        aux = new Comparable[arr.length];
        sort(arr, 0, arr.length);
    }

    public static void main(String[] args) {
        File file = new File(Const.DATA_PATH + "tiny.txt");
        In in = new In(file);
        String[] arr = in.readAllStrings();
        Merge.sort(arr);
        assert SortUtils.isSorted(arr);
        SortUtils.show(arr);
    }
}
