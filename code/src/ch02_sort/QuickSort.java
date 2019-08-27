package ch02_sort;

import common.Const;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Quick;

import java.io.File;
import java.util.concurrent.TransferQueue;

public class QuickSort {

    public static void sort(Comparable[] arr) {
        sort(arr, 0, arr.length);
    }

    public static void sort(Comparable[] arr, int lo, int hi) {
        if (hi - lo <= 1) {
            return;
        }
        int j = partition(arr, lo, hi);
        sort(arr, lo, j);
        sort(arr, j+1, hi);
    }

    public static int partition(Comparable[] arr, int lo, int hi) {
        Comparable target = arr[lo];
        int i = lo, j = hi;
        while (true) {
            while (SortUtils.less(target, arr[++i])) {
                if (hi - i <= 1) {
                    break;
                }
            }

            while (SortUtils.less(arr[--j], target)) {
                if (j - lo <= 0) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            SortUtils.exch(arr, i, j);
        }
        SortUtils.exch(arr, lo, j);
        return j;
    }

    public static void main(String[] args) {
        File file = new File(Const.DATA_PATH + "tiny.txt");
        In in = new In(file);
        String[] arr = in.readAllStrings();
        Quick.sort(arr);
        assert SortUtils.isSorted(arr);
        SortUtils.show(arr);
    }
}
