package ch02_sort;

import common.Const;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Shell;

import java.io.File;

public class ShellSort {

    public static void sort(Comparable[] arr) {
        int h = 1;
        while (h < arr.length / 3) {
            h = h * 3 + 1;
        }
        for (int i = h; i < arr.length; i++) {
            for (int j = i; j > h && SortUtils.less(arr[j], arr[j - h]); j -= h) {
                SortUtils.exch(arr, j, j - h);
            }
            h /= 3;
        }
    }

    public static void main(String[] args) {
        File file = new File(Const.DATA_PATH + "tiny.txt");
        In in = new In(file);
        String[] arr = in.readAllStrings();
        Shell.sort(arr);
        assert SortUtils.isSorted(arr);
        SortUtils.show(arr);
    }
}
