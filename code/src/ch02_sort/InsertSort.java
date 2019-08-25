package ch02_sort;

import common.Const;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Selection;

import java.io.File;

public class InsertSort {

    public static void sort(Comparable[] arr) {

        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && SortUtils.less(arr[j], arr[j-1]); j--) {
                SortUtils.exch(arr, j, j-1);
            }
        }
    }

    public static void main(String[] args) {
        File file = new File(Const.DATA_PATH + "tiny.txt");
        In in = new In(file);
        String[] arr = in.readAllStrings();
        InsertSort.sort(arr);
        assert SortUtils.isSorted(arr);
        SortUtils.show(arr);
    }
}
