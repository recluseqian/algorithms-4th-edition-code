package ch02_sort;

import common.Const;
import edu.princeton.cs.algs4.In;

import java.io.File;

public class MergeSortBottomUp {

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

    public static void sort(Comparable[] arr) {
        int len = arr.length;
        aux = new Comparable[len];
        for (int sz = 1; sz < len; sz += sz) {
            for (int lo = 0; lo + sz < len; lo += sz) {
                int hi = Math.min(lo + 2 * sz, len);
                int mid = lo + sz;
                merge(arr, lo, mid, hi);
            }
        }
    }


    public static void main(String[] args) {
        File file = new File(Const.DATA_PATH + "tiny.txt");
        In in = new In(file);
        String[] arr = in.readAllStrings();
        MergeSortBottomUp.sort(arr);
        assert SortUtils.isSorted(arr);
        SortUtils.show(arr);
    }
}
