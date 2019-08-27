package ch02_sort;

import common.Const;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Selection;

import java.io.*;

public class SelectionSort {

    public static void sort(Comparable[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (SortUtils.less(arr[j], arr[min])) {
                    min = j;
                }
                SortUtils.exch(arr, i, min);
            }
        }
    }

    public static void main(String[] args) {
        File file = new File(Const.DATA_PATH + "tiny.txt");
        In in = new In(file);
        String[] arr = in.readAllStrings();
        Selection.sort(arr);
        assert SortUtils.isSorted(arr);
        SortUtils.show(arr);
    }

}
